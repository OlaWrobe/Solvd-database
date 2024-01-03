package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.TeamScore;
import com.solvd.secondBlock.persistence.TeamScoreRepository;
import com.solvd.secondBlock.persistence.impl.TeamScoreRepositoryImpl;

import java.sql.SQLException;

public class TeamScoreServiceImpl implements TeamScoreRepository {
    TeamScoreRepository teamScoreRepository;

    public TeamScoreServiceImpl() {
        this.teamScoreRepository = new TeamScoreRepositoryImpl();
    }

    //CREATE WILL NOT WORK CUZ THERE IS NO GAME
    @Override
    public void create(TeamScore teamScore) throws InterruptedException {
        this.teamScoreRepository.create(teamScore);
    }

    @Override
    public void updateById(Long id, TeamScore updatedTeamSore) throws InterruptedException, SQLException {
        this.teamScoreRepository.updateById(id, updatedTeamSore);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.teamScoreRepository.deleteById(id);
    }

    @Override
    public TeamScore findById(Long id) throws InterruptedException {
        return this.teamScoreRepository.findById(id);
    }
}
