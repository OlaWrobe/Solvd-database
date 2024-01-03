package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.Venue;

import java.sql.SQLException;
import java.util.List;

public interface VenueService {
    public void create(Venue venue) throws InterruptedException;

    public List<Venue> findAll() throws InterruptedException;

    public void updateById(Long id, Venue updatedVenue) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Venue findById(Long id) throws InterruptedException;
}
