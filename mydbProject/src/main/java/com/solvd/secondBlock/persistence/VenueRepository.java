package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Venue;

import java.util.List;

public interface VenueRepository {

    public void create(Venue venue) throws InterruptedException;

    public List<Venue> findAll() throws InterruptedException;

    public void updateById(Long id, Venue updatedVenue) throws InterruptedException;

    public void deleteById(Long id) throws InterruptedException;

    public Venue findById(Long id) throws InterruptedException;
}
