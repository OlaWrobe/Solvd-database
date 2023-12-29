package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.SportType;

import java.util.List;

public interface SportTypeRepository {
    public void create(SportType sportType) throws InterruptedException;

    public void updateById(Long id, SportType updatedType) throws InterruptedException;

    public void deleteById(Long id) throws InterruptedException;

    public SportType findById(Long id) throws InterruptedException;

    public SportType findBySportID(Long sportId) throws InterruptedException;
}
