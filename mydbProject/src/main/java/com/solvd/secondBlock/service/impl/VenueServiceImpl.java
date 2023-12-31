package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.Venue;
import com.solvd.secondBlock.persistence.impl.VenueRepositoryImpl;
import com.solvd.secondBlock.persistence.VenueRepository;
import com.solvd.secondBlock.service.VenueService;

import java.sql.SQLException;
import java.util.List;

public class VenueServiceImpl implements VenueService {

    private static VenueRepository venueRepository;

    public VenueServiceImpl() {
        this.venueRepository = new VenueRepositoryImpl();
    }

    @Override
    public void create(Venue venue) throws InterruptedException {
        venueRepository.create(venue);
    }

    @Override
    public List<Venue> findAll() throws InterruptedException {
        return venueRepository.findAll();
    }

    @Override
    public void updateById(Long id, Venue updatedVenue) throws InterruptedException, SQLException {
        venueRepository.updateById(id, updatedVenue);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        venueRepository.deleteById(id);
    }

    @Override
    public Venue findById(Long id) throws InterruptedException {
        return venueRepository.findById(id);
    }
}
