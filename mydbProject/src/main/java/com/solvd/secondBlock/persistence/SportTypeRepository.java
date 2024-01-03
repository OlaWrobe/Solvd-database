package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.SportType;

public interface SportTypeRepository extends UniversalDao<SportType> {

    public SportType findBySportID(Long sportId) throws InterruptedException;
}
