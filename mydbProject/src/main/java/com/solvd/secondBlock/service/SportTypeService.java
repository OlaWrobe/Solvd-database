package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.Impl.SportTypeRepositoryImpl;

public interface SportTypeService {

    public void create(SportType sportType) throws InterruptedException;

    public void updateById(int id, SportType updatedType) throws InterruptedException;

    public void deleteById(int id) throws InterruptedException;

    public SportType findById(int id) throws InterruptedException;
    

}
