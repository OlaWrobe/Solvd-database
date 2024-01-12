package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.Country;
import com.solvd.secondBlock.model.Participant;
import com.solvd.secondBlock.model.Team;
import com.solvd.secondBlock.model.TeamScore;
import com.solvd.secondBlock.persistence.TeamRepository;
import com.solvd.secondBlock.persistence.TeamScoreRepository;
import com.solvd.secondBlock.persistence.mybatisimpl.TeamRepositoryBatisImpl;
import com.solvd.secondBlock.service.CountryService;
import com.solvd.secondBlock.service.ParticipantService;
import com.solvd.secondBlock.service.TeamScoreService;
import com.solvd.secondBlock.service.TeamService;

import java.sql.SQLException;
import java.util.List;

public class TeamServiceBatisImpl implements TeamService {
    private final TeamRepository teamRepositoryBatis;
    private final CountryService countryServiceBatis;
    private final ParticipantService participantServiceBatis;
    private final TeamScoreService teamScoreServiceBatis;

    public TeamServiceBatisImpl() {
        this.teamRepositoryBatis = new TeamRepositoryBatisImpl();
        this.countryServiceBatis = new CountryServiceBatisimpl();
        this.participantServiceBatis = new ParticipantServiceBatisImpl();
        this.teamScoreServiceBatis = new TeamScoreServiceBatisImpl();
    }

    @Override
    public Team create(Team team) throws InterruptedException {
        team.setId(null);
        teamRepositoryBatis.create(team);
        return team;
    }

    @Override
    public void updateById(Long id, Team updatedTeam) throws InterruptedException, SQLException {
        this.teamRepositoryBatis.updateById(id, updatedTeam);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.teamRepositoryBatis.deleteById(id);
    }

    @Override
    public Team findById(Long id) throws InterruptedException {
        Team team = teamRepositoryBatis.findById(id);

        Country country = countryServiceBatis.findByTeamId(id);
        team.setCountry(country);

        Participant captain = participantServiceBatis.findCaptainByTeamId(id);
        team.setCaptain(captain);

        List<Participant> players = participantServiceBatis.findPlayersByTeamId(id);
        team.setPlayers(players);

        List<TeamScore> teamScores = teamScoreServiceBatis.findScoresById(id);
        team.setTeamScoreList(teamScores);

        return team;
    }


}
