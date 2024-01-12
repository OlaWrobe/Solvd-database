package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.TeamScore;
import com.solvd.secondBlock.persistence.TeamScoreRepository;
import com.solvd.secondBlock.persistence.VenueRepository;
import com.solvd.secondBlock.persistence.mybatisimpl.TeamScoreRepositoryBatisImpl;
import com.solvd.secondBlock.persistence.mybatisimpl.VenueRepositoryBatisImpl;
import com.solvd.secondBlock.service.TeamScoreService;

import java.sql.SQLException;
import java.util.List;

public class TeamScoreServiceBatisImpl implements TeamScoreService {
    private final TeamScoreRepository teamScoreRepositoryBatis;

    public TeamScoreServiceBatisImpl() {
        this.teamScoreRepositoryBatis = new TeamScoreRepositoryBatisImpl();
    }

    @Override
    public void create(TeamScore teamScore) throws InterruptedException {
        teamScore.setId(null);
        this.teamScoreRepositoryBatis.create(teamScore);
    }

    @Override
    public void updateById(Long id, TeamScore updatedTeamSore) throws InterruptedException, SQLException {
        this.teamScoreRepositoryBatis.updateById(id, updatedTeamSore);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.teamScoreRepositoryBatis.deleteById(id);
    }

    @Override
    public TeamScore findById(Long id) throws InterruptedException {
        return this.teamScoreRepositoryBatis.findById(id);
    }

    @Override
    public List<TeamScore> findScoresById(Long id) throws InterruptedException {
        return this.teamScoreRepositoryBatis.findScoresById(id);
    }
}
