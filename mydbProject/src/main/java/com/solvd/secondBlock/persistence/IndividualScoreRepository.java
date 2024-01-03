package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.IndividualScore;
import com.solvd.secondBlock.model.Sport;

import java.sql.SQLException;

public interface IndividualScoreRepository {
    public void create(IndividualScore individualScore) throws InterruptedException;

    public void updateById(Long id, IndividualScore updatedIndividualScore) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public IndividualScore findById(Long id) throws InterruptedException;
}
