package com.solvd.secondBlock.persistence;

import com.solvd.secondBlock.model.Participant;
import com.solvd.secondBlock.model.Sport;

import java.sql.SQLException;

public interface ParticipantRepository {
    public void create(Participant participant) throws InterruptedException;

    public void updateById(Long id, Participant updatedParticipant) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Participant findById(Long id) throws InterruptedException;
}
