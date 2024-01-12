package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.Participant;
import com.solvd.secondBlock.service.impl.ParticipantServiceImpl;

import java.sql.SQLException;
import java.util.List;

public interface ParticipantService {
    public void create(Participant participant) throws InterruptedException;

    public void updateById(Long id, Participant updatedParticipant) throws InterruptedException, SQLException;

    public void deleteById(Long id) throws InterruptedException;

    public Participant findById(Long id) throws InterruptedException;

    public Participant findCaptainByTeamId(Long id) throws InterruptedException;

    public List<Participant> findPlayersByTeamId(Long id) throws InterruptedException;

    public Participant findWinner() throws InterruptedException;

    public List<Participant> findAll() throws InterruptedException;

}
