package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Sport;

public interface SportRepository extends UniversalDao<Sport> {

    public Sport findByParticipantId(Long id) throws InterruptedException;
}
