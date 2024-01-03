package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.Team;

import java.sql.SQLException;

public interface TeamRepository {
    public void create(Team team) throws InterruptedException;

    public void updateById(Long id, Team updatedTeam) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Team findById(Long id) throws InterruptedException;
}
