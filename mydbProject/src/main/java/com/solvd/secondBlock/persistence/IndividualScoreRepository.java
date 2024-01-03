package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.IndividualScore;

import java.util.List;

public interface IndividualScoreRepository extends UniversalDao<IndividualScore> {
    public List<IndividualScore> findIndividualScoresById(Long id) throws InterruptedException;
}
