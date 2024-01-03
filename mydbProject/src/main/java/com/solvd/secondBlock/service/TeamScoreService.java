package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.TeamScore;

import java.sql.SQLException;
import java.util.List;

public interface TeamScoreService {
    public void create(TeamScore teamScore) throws InterruptedException;

    public void updateById(Long id, TeamScore updatedTeamSore) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public TeamScore findById(Long id) throws InterruptedException;

    public List<TeamScore> findScoresById(Long id) throws InterruptedException;
}
