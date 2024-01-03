package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.Country;

import java.sql.SQLException;

public interface CountryService {
    public void create(Country country) throws InterruptedException;

    public void updateById(Long id, Country updatedCountry) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Country findById(Long id) throws InterruptedException;

    public Country findByParticipantId(Long id) throws InterruptedException;

    public Country findByTeamId(Long id) throws InterruptedException;
}
