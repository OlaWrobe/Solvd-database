package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.*;
import com.solvd.secondBlock.persistence.ParticipantRepository;
import com.solvd.secondBlock.persistence.TeamRepository;
import com.solvd.secondBlock.persistence.impl.TeamRepositoryImpl;
import com.solvd.secondBlock.service.*;

import java.sql.SQLException;
import java.util.List;

public class TeamServiceImpl implements TeamService {
    private final CountryService countryService;
    private final TeamScoreService teamScoreService;
    private final ParticipantService participantService;
    private final TeamRepository teamRepository;

    public TeamServiceImpl() {
        this.countryService = new CountryServiceImpl();
        this.teamScoreService = new TeamScoreServiceImpl();
        this.participantService = new ParticipantServiceImpl();

        this.teamRepository = new TeamRepositoryImpl();
    }

    //WONT WORK CUZ THERE IS NO GAME DAO
    @Override
    public Team create(Team team) throws InterruptedException {
        team.setId(null);
        this.teamRepository.create(team);
        if (countryService.findById(team.getCountry().getId()) == null) {
            countryService.create(team.getCountry());
        }
        if (participantService.findById(team.getCaptain().getId()) == null) {
            participantService.create(team.getCaptain());
        }
        for (Participant player : team.getPlayers()
        ) {
            if (participantService.findById(player.getId()) == null) {
                participantService.create(player);
            }
        }
        for (TeamScore ts : team.getTeamScoreList()
        ) {
            if (teamScoreService.findById(ts.getId()) == null) {
                teamScoreService.create(ts);
            }
        }
        return team;
    }

    @Override
    public void updateById(Long id, Team updatedTeam) throws InterruptedException, SQLException {
        this.teamRepository.updateById(id, updatedTeam);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.teamRepository.deleteById(id);
    }

    @Override
    public Team findById(Long id) throws InterruptedException {
        Team team = teamRepository.findById(id);

        Country country = countryService.findByTeamId(id);
        team.setCountry(country);

        Participant captain = participantService.findCaptainByTeamId(id);
        team.setCaptain(captain);

        List<Participant> players = participantService.findPlayersByTeamId(id);
        team.setPlayers(players);

        List<TeamScore> teamScores = teamScoreService.findScoresById(id);
        team.setTeamScoreList(teamScores);

        return team;
    }
}