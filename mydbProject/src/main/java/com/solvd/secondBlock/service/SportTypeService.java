package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.SportType;

public interface SportTypeService {

    public void create(SportType sportType) throws InterruptedException;

    public void updateById(Long id, SportType updatedType) throws InterruptedException;

    public void deleteById(Long id) throws InterruptedException;

    public SportType findById(Long id) throws InterruptedException;

    public SportType findBySportId(Long sportID) throws InterruptedException;

}
