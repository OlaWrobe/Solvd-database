package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.mybatisimpl.SportTypeRepositoryBatisImpl;
import com.solvd.secondBlock.service.SportTypeService;

public class SportTypeServiceBatisImpl implements SportTypeService {

    private final SportTypeRepositoryBatisImpl sportTypeRepositoryBatis = new SportTypeRepositoryBatisImpl();

    @Override
    public void create(SportType sportType) throws InterruptedException {
        sportTypeRepositoryBatis.create(sportType);
    }

    @Override
    public void updateById(Long id, SportType updatedType) throws InterruptedException {
        sportTypeRepositoryBatis.updateById(id, updatedType);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        sportTypeRepositoryBatis.deleteById(id);
    }

    @Override
    public SportType findById(Long id) throws InterruptedException {
        return sportTypeRepositoryBatis.findById(id);
    }

    @Override
    public SportType findBySportId(Long sportID) throws InterruptedException {
        // Implement this method using your MyBatis repository
        // Example: return sportTypeRepositoryBatis.findBySportId(sportID);
        throw new UnsupportedOperationException("Method not implemented yet");
    }
}
