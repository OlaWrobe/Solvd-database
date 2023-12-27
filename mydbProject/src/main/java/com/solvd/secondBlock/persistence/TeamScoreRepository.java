package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Game;
import com.solvd.secondBlock.model.TeamScore;

import java.sql.SQLException;

public interface TeamScoreRepository {
    public void create(TeamScore teamScore, Game game) throws InterruptedException;

    public void updateById(int id, TeamScore updatedTeamScore) throws InterruptedException, SQLException;

    public void deleteById(int id) throws InterruptedException;

    //public TeamScore findById(int id) throws InterruptedException;

}
