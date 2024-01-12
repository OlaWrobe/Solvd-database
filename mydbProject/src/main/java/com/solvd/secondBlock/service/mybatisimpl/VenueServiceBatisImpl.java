package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.Venue;
import com.solvd.secondBlock.persistence.VenueRepository;
import com.solvd.secondBlock.persistence.mybatisimpl.VenueRepositoryBatisImpl;
import com.solvd.secondBlock.service.VenueService;

import java.sql.SQLException;
import java.util.List;

public class VenueServiceBatisImpl implements VenueService {
    private final VenueRepository venueRepositoryBatis;

    public VenueServiceBatisImpl() {
        this.venueRepositoryBatis = new VenueRepositoryBatisImpl();
    }

    @Override
    public void create(Venue venue) throws InterruptedException {
        venue.setId(null);
        this.venueRepositoryBatis.create(venue);
    }

    @Override
    public List<Venue> findAll() throws InterruptedException {
        return this.venueRepositoryBatis.findAll();
    }

    @Override
    public void updateById(Long id, Venue updatedVenue) throws InterruptedException, SQLException {
        this.venueRepositoryBatis.updateById(id, updatedVenue);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.venueRepositoryBatis.deleteById(id);
    }

    @Override
    public Venue findById(Long id) throws InterruptedException {
        return this.venueRepositoryBatis.findById(id);
    }
}
