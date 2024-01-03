package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.TeamScore;

import java.util.List;

public interface TeamScoreRepository extends UniversalDao<TeamScore> {

    public List<TeamScore> findScoresById(Long id) throws InterruptedException;
}
