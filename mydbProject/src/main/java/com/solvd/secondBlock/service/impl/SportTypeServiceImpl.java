package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.Impl.SportTypeRepositoryImpl;
import com.solvd.secondBlock.service.SportTypeService;

public class SportTypeServiceImpl implements SportTypeService {
    public final SportTypeRepositoryImpl sportTypeRepositoryImpl = new SportTypeRepositoryImpl();

    public void create(SportType sportType) throws InterruptedException {
        sportTypeRepositoryImpl.create(sportType);
    }

    public void updateById(int id, SportType updatedType) throws InterruptedException {
        sportTypeRepositoryImpl.updateById(id, updatedType);
    }

    public void deleteById(int id) throws InterruptedException {
        sportTypeRepositoryImpl.deleteById(id);
    }

    public SportType findById(int id) throws InterruptedException {
        return sportTypeRepositoryImpl.findById(id);
    }
}
