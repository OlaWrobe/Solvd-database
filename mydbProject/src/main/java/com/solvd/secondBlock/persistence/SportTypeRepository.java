package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.SportType;

import java.util.List;

public interface SportTypeRepository {
    public void create(SportType sportType) throws InterruptedException;

    public void updateById(int id, SportType updatedType) throws InterruptedException;

    public void deleteById(int id) throws InterruptedException;

    public SportType findById(int id) throws InterruptedException;
}
