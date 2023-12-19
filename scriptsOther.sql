#ALTER TABLE

ALTER TABLE sports MODIFY COLUMN description VARCHAR(100);

ALTER TABLE teams MODIFY COLUMN team_name VARCHAR(100);

ALTER TABLE participants ADD COLUMN email VARCHAR(50);

ALTER TABLE participants ADD CONSTRAINT uc_email UNIQUE (email);

ALTER TABLE individual_scores MODIFY COLUMN distance DECIMAL(5,2);

ALTER TABLE mydb.venues CHANGE COLUMN address venue_address VARCHAR(150);

#UPDATES

UPDATE countries
SET country_name = 'Australia'
WHERE country_name LIKE "%LAND OF CANGAROOS";

UPDATE participants
SET country_id = (
		SELECT id
		FROM countries
		WHERE country_name LIKE "Australia"
		)
WHERE id = 7;

UPDATE mydb.sports
SET description = 'The most popular team sport worldwide; known as soccer in some countries.'
WHERE name = 'Football';

UPDATE mydb.sports
SET description = 'Team sport where two teams try to score points by throwing a ball through the opposing basket.'
WHERE name = 'Basketball';

UPDATE mydb.scoreboards
SET medal_id = CASE 
		WHEN place = 1
			THEN 1
		WHEN place = 2
			THEN 2
		WHEN place = 3
			THEN 3
		END;

UPDATE mydb.games
SET winner_team_id = CASE 
		WHEN (
				SELECT team_points
				FROM mydb.team_scores
				WHERE game_id = 7
					AND team_id = 3
				) > (
				SELECT team_points
				FROM mydb.team_scores
				WHERE game_id = 7
					AND team_id = 4
				)
			THEN 3
		WHEN (
				SELECT team_points
				FROM mydb.team_scores
				WHERE game_id = 7
					AND team_id = 3
				) < (
				SELECT team_points
				FROM mydb.team_scores
				WHERE game_id = 7
					AND team_id = 4
				)
			THEN 4
		ELSE NULL
		END
	,result = CASE 
		WHEN (
				SELECT team_points
				FROM mydb.team_scores
				WHERE game_id = 7
					AND team_id = 3
				) = (
				SELECT team_points
				FROM mydb.team_scores
				WHERE game_id = 7
					AND team_id = 4
				)
			THEN 'Tie'
		ELSE 'Win'
		END
WHERE id = 7;

UPDATE mydb.venues
SET capacity = 60000
WHERE venue_name LIKE '%ARENA%';

UPDATE mydb.games AS g
JOIN mydb.olympics AS o ON g.olympics_id = o.olympics_id

SET g.date_of_game = DATE_ADD(o.start_date, INTERVAL 3 DAY)
WHERE o.olympics_id > 1;

UPDATE mydb.teams t
JOIN mydb.countries c ON t.country_id = c.id

SET team_name = CONCAT (
		'National '
		,c.country_name
		,' Team'
		);

SELECT *
FROM teams;

UPDATE mydb.teams t1
JOIN (
	SELECT team_id
		,count(*) AS cnt
	FROM team_has_members t2
	GROUP BY team_id
	) t2 ON t2.team_id = t1.id

SET t1.squad_size = t2.cnt;

SELECT *
FROM teams;

#DELETES

DELETE
FROM mydb.medals
WHERE medal_name NOT IN (
		'Silver'
		,'Gold'
		,'Bronze'
		);

DELETE
FROM mydb.individual_scores
WHERE (points IS NOT NULL) + (distance IS NOT NULL) + (TIME IS NOT NULL) > 1;

DELETE teams
FROM mydb.teams t
LEFT JOIN mydb.team_has_members thm ON t.id = thm.team_id
WHERE thm.team_id IS NULL;

DELETE
FROM mydb.participants
WHERE id NOT IN (
		SELECT participant_id
		FROM mydb.individual_scores
		UNION
		SELECT member_id
		FROM mydb.team_has_members
		);

DELETE
FROM mydb.olympics
WHERE id IN (
		SELECT id
		FROM (
			SELECT id
				,ROW_NUMBER() OVER (
					PARTITION BY olympics_type_id
					,country_id
					,name
					,start_date
					,end_date ORDER BY id
					) AS rownum
			FROM olympics
			) AS sub
		WHERE rownum > 1
		);

DELETE v
FROM mydb.venues v
LEFT JOIN mydb.games g ON v.id = g.venue_id
WHERE g.venue_id IS NULL;

DELETE s
FROM mydb.sports s
LEFT JOIN mydb.participants p ON s.id = p.sport_id
WHERE p.sport_id IS NULL;

DELETE O
FROM mydb.olympics o
LEFT JOIN mydb.games g ON o.id = g.olympics_id
WHERE g.olympics_id IS NULL;

DELETE
FROM mydb.scoreboards
WHERE id = 7;

DELETE
FROM mydb.game_types
WHERE name = 'Round of 16';

SELECT *
FROM games g
LEFT JOIN olympics o ON o.id = g.olympics_id
LEFT JOIN olympics_types ot ON ot.id = o.olympics_type_id
LEFT JOIN venues v ON v.id = g.venue_id
LEFT JOIN sports s ON s.id = g.sport_id
LEFT JOIN game_types gt ON gt.id = g.game_type_id
LEFT JOIN participants p ON p.id = g.winner_id
LEFT JOIN teams t ON t.id = winner_team_id
LEFT JOIN team_has_members thm ON thm.team_id = t.id
LEFT JOIN individual_scores isc ON g.id = isc.game_id
LEFT JOIN team_scores ts ON g.id = ts.game_id
LEFT JOIN sport_types st ON st.id = s.sport_type_id
LEFT JOIN scoreboards sc ON sc.olympics_id = o.id
LEFT JOIN medals m ON m.id = sc.medal_id
LEFT JOIN countries c ON c.id = o.country_id;

SELECT games.id AS game_id
	,teams.team_name
FROM mydb.games
RIGHT JOIN mydb.teams ON games.winner_team_id = teams.id;

#AGG WITHOUT HAVING
SELECT c.id
	,c.country_name
	,COUNT(o.id) AS olympic_count
FROM mydb.countries c
JOIN mydb.olympics o ON c.id = o.country_id
GROUP BY c.id;

SELECT c.id, c.country_name, AVG(squad_size)
FROM teams t
JOIN countries c ON c.id = t.country_id
GROUP BY country_id;

SELECT v.name AS venue_name, s.name AS sport_name, count(v.id) AS venue_usage
FROM venues v
JOIN games g ON v.id = g.venue_id
JOIN sports s ON s.id = g.sport_id
GROUP BY v.name, s.name, v.id;

SELECT t.team_name, MAX(team_points)
FROM team_scores ts
JOIN teams t ON t.id = ts.team_id
GROUP BY t.id, t.team_name;

SELECT olympics_id, COUNT(medal_id)
FROM scoreboards
WHERE medal_id = 1
GROUP BY olympics_id;

SELECT game_id, AVG(time)
FROM individual_scores
GROUP BY game_id;

SELECT st.name, COUNT(sport_type_id)
FROM sports s 
JOIN sport_types st ON s.sport_type_id = st.id
GROUP BY st.name, sport_type_id;

#AGG WITH HAVING
SELECT c.country_name, COUNT(p.id) AS amt_of_ppl_above_30
FROM participants p 
JOIN countries c ON c.id = p.country_id
WHERE 2013 - year(birthdate) > 30
GROUP BY c.country_name, country_id
HAVING count(p.id) >1;

