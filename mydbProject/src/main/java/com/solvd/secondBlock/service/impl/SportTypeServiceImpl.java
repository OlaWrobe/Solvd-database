package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.Impl.SportTypeRepositoryImpl;
import com.solvd.secondBlock.service.SportTypeService;

public class SportTypeServiceImpl implements SportTypeService {
    public final SportTypeRepositoryImpl sportTypeRepositoryImpl = new SportTypeRepositoryImpl();

    public void create(SportType sportType) throws InterruptedException {
        sportTypeRepositoryImpl.create(sportType);
    }

    public void updateById(Long id, SportType updatedType) throws InterruptedException {
        sportTypeRepositoryImpl.updateById(id, updatedType);
    }

    public void deleteById(Long id) throws InterruptedException {
        sportTypeRepositoryImpl.deleteById(id);
    }

    public SportType findById(Long id) throws InterruptedException {
        return sportTypeRepositoryImpl.findById(id);
    }

    @Override
    public SportType findBySportId(Long sportID) throws InterruptedException {
        return sportTypeRepositoryImpl.findBySportID(sportID);
    }
}
