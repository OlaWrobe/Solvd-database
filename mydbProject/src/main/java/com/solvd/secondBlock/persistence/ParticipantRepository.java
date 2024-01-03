package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Participant;

import java.util.List;

public interface ParticipantRepository extends UniversalDao<Participant> {
    public Participant findCaptainByTeamId(Long id) throws InterruptedException;

    public List<Participant> findPlayersByTeamId(Long id) throws InterruptedException;

    public List<Participant> findAll() throws InterruptedException;
}
