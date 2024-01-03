package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.IndividualScore;

import java.sql.SQLException;

public interface IndividualScoreService {
    public void create(IndividualScore individualScore) throws InterruptedException;

    public void updateById(Long id, IndividualScore updatedIndividualScore) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public IndividualScore findById(Long id) throws InterruptedException;
}
