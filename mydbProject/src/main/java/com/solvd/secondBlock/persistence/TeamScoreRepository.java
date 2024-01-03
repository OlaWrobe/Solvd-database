package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.Team;
import com.solvd.secondBlock.model.TeamScore;

import java.sql.SQLException;

public interface TeamScoreRepository {
    public void create(TeamScore teamScore) throws InterruptedException;

    public void updateById(Long id, TeamScore updatedTeamSore) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public TeamScore findById(Long id) throws InterruptedException;
}
