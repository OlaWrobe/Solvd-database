package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.IndividualScore;
import com.solvd.secondBlock.persistence.IndividualScoreRepository;
import com.solvd.secondBlock.persistence.impl.IndividualScoreRepositoryImpl;
import com.solvd.secondBlock.persistence.mybatisimpl.IndividualScoreRepositoryBatisImpl;
import com.solvd.secondBlock.service.IndividualScoreService;

import java.sql.SQLException;
import java.util.List;

public class IndividualScoreServiceBatisImpl implements IndividualScoreService {
    private final IndividualScoreRepository individualScoreRepositoryBatis;

    public IndividualScoreServiceBatisImpl() {
        this.individualScoreRepositoryBatis = new IndividualScoreRepositoryBatisImpl();
    }

    @Override
    public void create(IndividualScore individualScore) throws InterruptedException {
        individualScore.setId(null);
        this.individualScoreRepositoryBatis.create(individualScore);
    }

    @Override
    public void updateById(Long id, IndividualScore updatedIndividualScore) throws InterruptedException, SQLException {
        this.individualScoreRepositoryBatis.updateById(id, updatedIndividualScore);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.individualScoreRepositoryBatis.deleteById(id);
    }

    @Override
    public IndividualScore findById(Long id) throws InterruptedException {
        return this.individualScoreRepositoryBatis.findById(id);
    }

    @Override
    public List<IndividualScore> findIndividualScoresById(Long id) throws InterruptedException {
        return this.individualScoreRepositoryBatis.findIndividualScoresById(id);
    }
}
