package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.IndividualScore;
import com.solvd.secondBlock.service.IndividualScoreService;

import java.sql.SQLException;

public class IndividualScoreServiceImpl implements IndividualScoreService {
    

    //CREATE WILL NOT WORK CUZ THERE IS NO GAME
    @Override
    public void create(IndividualScore individualScore) throws InterruptedException {

    }

    @Override
    public void updateById(Long id, IndividualScore updatedIndividualScore) throws InterruptedException, SQLException {

    }

    @Override
    public void deleteById(Long id) throws InterruptedException {

    }

    @Override
    public IndividualScore findById(Long id) throws InterruptedException {
        return null;
    }

}
