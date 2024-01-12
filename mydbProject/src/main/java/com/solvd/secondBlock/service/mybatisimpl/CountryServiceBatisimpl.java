package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.Country;
import com.solvd.secondBlock.persistence.CountryRepository;
import com.solvd.secondBlock.persistence.mybatisimpl.CountryRepositoryBatisImpl;
import com.solvd.secondBlock.service.CountryService;

import java.sql.SQLException;

public class CountryServiceBatisimpl implements CountryService {

    private final CountryRepository countryRepositoryBatis;

    public CountryServiceBatisimpl() {
        this.countryRepositoryBatis = new CountryRepositoryBatisImpl();
    }

    @Override
    public void create(Country country) throws InterruptedException {
        this.countryRepositoryBatis.create(country);
    }

    @Override
    public void updateById(Long id, Country updatedCountry) throws InterruptedException, SQLException {
        this.countryRepositoryBatis.updateById(id, updatedCountry);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.countryRepositoryBatis.deleteById(id);
    }

    @Override
    public Country findById(Long id) throws InterruptedException {
        return this.countryRepositoryBatis.findById(id);
    }

    @Override
    public Country findByParticipantId(Long id) throws InterruptedException {
        return this.countryRepositoryBatis.findByParticipantId(id);
    }

    @Override
    public Country findByTeamId(Long id) throws InterruptedException {
        return this.countryRepositoryBatis.findByTeamId(id);
    }
}
