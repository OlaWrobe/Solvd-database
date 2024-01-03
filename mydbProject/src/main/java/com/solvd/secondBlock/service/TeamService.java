package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.Team;
import com.solvd.secondBlock.model.TeamScore;

import java.sql.SQLException;

public interface TeamService {
    public Team create(Team team) throws InterruptedException;

    public void updateById(Long id, Team updatedTeam) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Team findById(Long id) throws InterruptedException;

    //public Team findWinner();

    //public Team findLargest();

}
