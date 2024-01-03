package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Venue;

import java.util.List;

public interface VenueRepository extends UniversalDao<Venue> {
    public List<Venue> findAll() throws InterruptedException;

}
