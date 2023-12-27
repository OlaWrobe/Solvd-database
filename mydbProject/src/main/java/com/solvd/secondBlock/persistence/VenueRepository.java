package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Venue;

import java.util.List;

public interface VenueRepository {

    public void create(Venue venue) throws InterruptedException;

    public List<Venue> findAll() throws InterruptedException;

    public void updateById(int id, Venue updatedVenue) throws InterruptedException;

    public void deleteById(int id) throws InterruptedException;

    public Venue findById(int id) throws InterruptedException;
}
