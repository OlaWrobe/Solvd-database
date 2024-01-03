package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.IndividualScore;
import com.solvd.secondBlock.persistence.IndividualScoreRepository;
import com.solvd.secondBlock.persistence.impl.IndividualScoreRepositoryImpl;
import com.solvd.secondBlock.service.IndividualScoreService;

import java.sql.SQLException;
import java.util.List;

public class IndividualScoreServiceImpl implements IndividualScoreService {
    IndividualScoreRepository individualScoreRepository;

    public IndividualScoreServiceImpl() {
        this.individualScoreRepository = new IndividualScoreRepositoryImpl();
    }

    //CREATE WILL NOT WORK CUZ THERE IS NO GAME DAO
    @Override
    public void create(IndividualScore individualScore) throws InterruptedException {
        this.individualScoreRepository.create(individualScore);
    }

    @Override
    public void updateById(Long id, IndividualScore updatedIndividualScore) throws InterruptedException, SQLException {
        this.individualScoreRepository.updateById(id, updatedIndividualScore);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.individualScoreRepository.deleteById(id);
    }

    @Override
    public IndividualScore findById(Long id) throws InterruptedException {
        return this.individualScoreRepository.findById(id);
    }

    public List<IndividualScore> findIndividualScoresById(Long id) throws InterruptedException {
        return this.individualScoreRepository.findIndividualScoresById(id);
    }
}
