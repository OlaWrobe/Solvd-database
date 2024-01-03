package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Country;

public interface CountryRepository extends UniversalDao<Country> {

    public Country findByParticipantId(Long id) throws InterruptedException;

    public Country findByTeamId(Long id) throws InterruptedException;
}
