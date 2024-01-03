package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.Country;
import com.solvd.secondBlock.persistence.CountryRepository;
import com.solvd.secondBlock.persistence.impl.CountryRepositoryImpl;
import com.solvd.secondBlock.service.CountryService;

import java.sql.SQLException;

public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public CountryServiceImpl() {
        this.countryRepository = new CountryRepositoryImpl();
    }

    @Override
    public void create(Country country) throws InterruptedException {
        this.countryRepository.create(country);
    }

    @Override
    public void updateById(Long id, Country updatedCountry) throws InterruptedException, SQLException {
        this.countryRepository.updateById(id, updatedCountry);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.countryRepository.deleteById(id);
    }

    @Override
    public Country findById(Long id) throws InterruptedException {
        return this.countryRepository.findById(id);
    }

    @Override
    public Country findByParticipantId(Long id) throws InterruptedException {
        return this.countryRepository.findByParticipantId(id);
    }

    public Country findByTeamId(Long id) throws InterruptedException {
        return this.countryRepository.findByTeamId(id);
    }
}
