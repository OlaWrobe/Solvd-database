package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Game;
import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.TeamScore;

import java.sql.SQLException;

public interface SportRepository {
    public void create(Sport sport) throws InterruptedException;

    public void updateById(Long id, Sport updatedSport) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Sport findById(Long id) throws InterruptedException;
}
