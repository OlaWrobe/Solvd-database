SET FOREIGN_KEY_CHECKS = 0;

-- Delete records and reset auto-incremented IDs for each table
TRUNCATE TABLE mydb.individual_scores;
ALTER TABLE mydb.individual_scores AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.team_scores;
ALTER TABLE mydb.team_scores AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.scoreboards;
ALTER TABLE mydb.scoreboards AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.team_has_members;
ALTER TABLE mydb.team_has_members AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.medals;
ALTER TABLE mydb.medals AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.games;
ALTER TABLE mydb.games AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.teams;
ALTER TABLE mydb.teams AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.game_types;
ALTER TABLE mydb.game_types AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.olympics;
ALTER TABLE mydb.olympics AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.olympics_types;
ALTER TABLE mydb.olympics_types AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.venues;
ALTER TABLE mydb.venues AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.participants;
ALTER TABLE mydb.participants AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.sports;
ALTER TABLE mydb.sports AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.sport_types;
ALTER TABLE mydb.sport_types AUTO_INCREMENT = 1;

TRUNCATE TABLE mydb.countries;
ALTER TABLE mydb.countries AUTO_INCREMENT = 1;

-- Enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;


#countries
INSERT INTO mydb.countries (country_name) VALUES ('United States');
INSERT INTO mydb.countries (country_name) VALUES ('United Kingdom');
INSERT INTO mydb.countries (country_name) VALUES ('LAND OF CANGAROOS');
INSERT INTO mydb.countries (country_name) VALUES ('France');
INSERT INTO mydb.countries (country_name) VALUES ('Brazil');

#venues
INSERT INTO mydb.venues (name, address, capacity) VALUES ('Stadium A', '123 Main St', 50000);
INSERT INTO mydb.venues (name, address, capacity) VALUES ('Arena B', '456 Oak St', 30000);
INSERT INTO mydb.venues (name, address, capacity) VALUES ('Test place', '123 lorem impsum', 20000);

#sport_types
INSERT INTO mydb.sport_types (name, is_individual) VALUES ('Team Sports', 0);
INSERT INTO mydb.sport_types (name, is_individual) VALUES ('Athletidics', 1);
INSERT INTO mydb.sport_types (name, is_individual) VALUES ('forgotten sport', 1);
#sports
INSERT INTO mydb.sports (sport_type_id, name, description) VALUES (1, 'Football', 'Association football');
INSERT INTO mydb.sports (sport_type_id, name, description) VALUES (1, 'Basketball', 'Team sport with ball');
INSERT INTO mydb.sports (sport_type_id, name, description) VALUES (2, 'Athletics', 'Track and field events');

#participants
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (1, 2, 'Michael', 'Jordan', '1963-02-17', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (1, 2, 'Serena', 'Williams', '1981-09-26', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (1, 3, 'LeBron', 'James', '1984-12-30', 'Male');

INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (2, 2, 'David', 'Beckham', '1975-05-02', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (2, 2, 'Jessica', 'Ennis-Hill', '1986-01-28', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (2, 3, 'Andy', 'Murray', '1987-05-15', 'Male');
-- bad australia
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (2, 3, 'John', 'Doe', '1990-01-15', 'Male');
-- Participants from Australia
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (3, 2, 'Patrick', 'Mills', '1988-08-11', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (3, 2, 'Cate', 'Campbell', '1992-05-20', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (3, 2, 'Steve', 'Hooker', '1982-07-16', 'Male');

-- Participants from France
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (4, 1, 'Antoine', 'Griezmann', '1991-03-21', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (4, 2, 'Marie', 'José Pérec', '1968-05-09', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (4, 2, 'Renaud', 'Lavillenie', '1986-09-05', 'Male');

-- Participants from Brazil
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (5, 2, 'Neymar', 'Junior', '1992-02-05', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (5, 2, 'Marta', 'Vieira da Silva', '1986-02-19', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (5, 1, 'Thiago', 'Braz', '1993-12-16', 'Male');

-- more participants
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (4, 1, 'player1B', 'sr1', '1990-03-21', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (4, 1, 'player2B', 'sr2', '1968-03-09', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (4, 1, 'player3B', 'sr3', '1989-01-05', 'Male');

-- Participants from Brazil
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (5, 1, 'player1A', 'sr1a', '2000-02-05', 'Male');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (5, 1, 'player2a', 'sr2a', '1997-02-19', 'Female');
INSERT INTO mydb.participants (country_id, sport_id, name, surname, birthdate, gender) VALUES (5, 1, 'player3a', 'sr3a', '1992-12-16', 'Male');

#medals 
INSERT INTO mydb.medals (medal_name) VALUES ('Gold');
INSERT INTO mydb.medals (medal_name) VALUES ('Silver');
INSERT INTO mydb.medals (medal_name) VALUES ('Bronze');
INSERT INTO mydb.medals (medal_name) VALUES ('EOEOE');

#teams
-- Team 1
INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (1, 1, 'Team USA', 0);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (1, 1);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (1 ,2);

-- Team 2
INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (2, 4, 'Team UK', 0);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (2, 4);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (2, 5);

-- team australia
INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (3, 8, 'Team Aus', 0);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (3, 8);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (3, 10);

-- Teams from France
INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (4, 12, 'Team Fra', 0);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (4, 12);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (4, 13);

-- Teams from Brazil
INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (5, 14, 'Team Bra', 0);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (5, 14);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (5, 15);

-- 

INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (2,2,"dummy",0);

INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (5, 17, 'Team Brazil big', 3);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (7, 17);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (7, 18);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (7, 19);

INSERT INTO mydb.teams (country_id, captain_id, team_name, squad_size) VALUES (4, 20, 'Team France big', 3);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (8, 20);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (8, 21);
INSERT INTO mydb.team_has_members (team_id, member_id) VALUES (8, 22);


#olympics types
INSERT INTO mydb.olympics_types (name) VALUES ('Summer Olympics');
INSERT INTO mydb.olympics_types (name) VALUES ('Winter Olympics');

#olympics
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (1, 1, 'Summer Olympics 2008', '2008-08-08', '2008-08-24');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (2, 2, 'Winter Olympics 2010', '2010-02-12', '2010-02-28');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (2, 2, 'Winter Olympics 2010', '2010-02-12', '2010-02-28');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (2, 3, 'Summer Olympics 2025', '2025-02-12', '2025-02-28');

INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (1, 1, 'Summer Olympics 2012', '2012-07-27', '2012-08-12');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (1, 1, 'Summer Olympics 2016', '2016-08-05', '2016-08-21');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (2, 2, 'Winter Olympics 2014', '2014-02-07', '2014-02-23');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (2, 2, 'Winter Olympics 2018', '2018-02-09', '2018-02-25');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (1, 3, 'Summer Olympics 2025', '2025-07-21', '2025-08-06');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (1, 4, 'Summer Olympics 2012', '2012-07-27', '2012-08-12');
INSERT INTO mydb.olympics (olympics_type_id, country_id, name, start_date, end_date) VALUES (1, 5, 'Summer Olympics 2016', '2016-08-05', '2016-08-21');

#game_types
INSERT INTO mydb.game_types (name) VALUES ('Finals');
INSERT INTO mydb.game_types (name) VALUES ('Semifinals');
INSERT INTO mydb.game_types (name) VALUES ('Quarterfinals');
INSERT INTO mydb.game_types (name) VALUES ('Round of 16');

#games

INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_id, result, date_of_game) VALUES (2, 2, 3, 3,1, 'Win', '2008-08-20');

-- Game 1: Semifinal 1
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 2,1, 'Win', '2008-08-10');
-- Game 2: Semifinal 2
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 2,1, 'Win', '2008-08-11');
-- Game 3: Semifinal 3
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 2,1, 'Win', '2008-08-12');
-- Game 4: Semifinal 4
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 2,2, 'win', '2008-08-13');
-- Game 4: Semifinal 5
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 2,4, 'win', '2008-08-14');
-- Game 4: Semifinal 6
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 2,1, 'NUN', '2008-08-15');
-- finale 
INSERT INTO mydb.games (olympics_id, venue_id, sport_id, game_type_id,winner_team_id, result, date_of_game) VALUES (1, 1, 2, 1,1, 'Win', '2008-08-24');

#individual scores
INSERT INTO mydb.individual_scores (participant_id, game_id, time) VALUES (3, 1, '00:11:45');
INSERT INTO mydb.individual_scores (participant_id, game_id, time) VALUES (6, 1, '00:12:30');
INSERT INTO mydb.individual_scores (participant_id, game_id, time,distance) VALUES (1,7,'00:12:12',13);
#teamScores
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (8, 1, 3);
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (8, 2, 2);

-- Game 1: Semifinal 1
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (2, 1, 3); -- Team USA
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (2, 2, 2); -- Team UK

-- Game 2: Semifinal 2
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (3, 1, 4); -- Team USA
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (3, 3, 1); -- Team Australia

-- Game 3: Semifinal 3
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (4, 1, 2); -- Team USA
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (4, 4, 1); -- Team France

-- Game 4: Semifinal 4
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (5, 2, 3); -- Team UK
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (5, 3, 2); -- Team Australia

-- Game 5: Semifinal 5
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (6, 2, 2); -- Team UK
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (6, 4, 3); -- Team France

-- Game 6: Semifinal 6
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (7, 3, 1); -- Team Australia
INSERT INTO mydb.team_scores (game_id, team_id, team_points) VALUES (7, 4, 2); -- Team France

#scoreboards
INSERT INTO mydb.scoreboards (olympics_id, sport_id, participant_id, medal_id, place)
VALUES (2, 3, 3, NULL, 1); 

INSERT INTO mydb.scoreboards (olympics_id, sport_id, participant_id, medal_id, place)
VALUES (2, 3, 6, NULL, 2); 

-- Team USA (Gold)
INSERT INTO mydb.scoreboards (olympics_id, sport_id, team_id, medal_id, place)
VALUES (1, 2, 1, NULL, 1); -- Gold Medal - 1st Place

-- Team UK (Silver)
INSERT INTO mydb.scoreboards (olympics_id, sport_id, team_id, medal_id, place)
VALUES (1, 2, 2, NULL, 2); -- Silver Medal - 2nd Place

-- Team Australia (Bronze)
INSERT INTO mydb.scoreboards (olympics_id, sport_id, team_id, medal_id, place)
VALUES (1, 2, 3, NULL, 3); -- Bronze Medal - 3rd Place

-- Team France (No Medal)
INSERT INTO mydb.scoreboards (olympics_id, sport_id, team_id, medal_id, place)
VALUES (1, 2, 4, NULL, 4); -- No Medal - 4th Place

INSERT INTO mydb.scoreboards(olympics_id, sport_id, participant_id,medal_id, place)
VALUES (1, 2, 7, NULL, 1);