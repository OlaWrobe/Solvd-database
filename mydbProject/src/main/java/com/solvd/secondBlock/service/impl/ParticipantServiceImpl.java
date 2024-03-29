package com.solvd.secondBlock.service.impl;

import com.solvd.secondBlock.model.*;
import com.solvd.secondBlock.persistence.ParticipantRepository;
import com.solvd.secondBlock.persistence.impl.ParticipantRepositoryImpl;
import com.solvd.secondBlock.service.*;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class ParticipantServiceImpl implements ParticipantService {
    private final CountryService countryService;
    private final IndividualScoreService individualScoreService;
    private final SportService sportService;
    private final ParticipantRepository participantRepository;
    private final SportTypeService sportTypeService;

    public ParticipantServiceImpl() {
        this.sportTypeService = new SportTypeServiceImpl();
        this.individualScoreService = new IndividualScoreServiceImpl();
        this.participantRepository = new ParticipantRepositoryImpl();
        this.sportService = new SportServiceImpl();
        this.countryService = new CountryServiceImpl();
    }

    @Override
    public void create(Participant participant) throws InterruptedException {
        participant.setId(null);
        this.participantRepository.create(participant);
    }

    @Override
    public void updateById(Long id, Participant updatedParticipant) throws InterruptedException, SQLException {
        this.participantRepository.updateById(id, updatedParticipant);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.participantRepository.deleteById(id);
    }

    @Override
    public Participant findById(Long id) throws InterruptedException {
        Participant participant = participantRepository.findById(id);

        Country country = countryService.findByParticipantId(id);
        participant.setCountry(country);

        Sport sport = sportService.findByParticipantId(id);
        SportType sportType = sportTypeService.findBySportId(sport.getId());
        sport.setSportType(sportType);

        participant.setSport(sport);

        List<IndividualScore> individualScoreList = individualScoreService.findIndividualScoresById(id);
        participant.setIndividualScoreList(individualScoreList);

        return participant;
    }

    public Participant findCaptainByTeamId(Long id) throws InterruptedException {
        return this.participantRepository.findCaptainByTeamId(id);
    }

    public List<Participant> findPlayersByTeamId(Long id) throws InterruptedException {
        return this.participantRepository.findPlayersByTeamId(id);
    }

    @Override
    public Participant findWinner() throws InterruptedException {
        Participant winner = null;
        Time time = new Time(24, 00, 00);
        List<Participant> list = this.findAll();

        for (Participant participant : list) {
            if (participant.getIndividualScoreList().size() > 0) {
                for (IndividualScore score : participant.getIndividualScoreList()
                ) {
                    Time scoreTime = score.getTime();
                    int result = time.compareTo(scoreTime);

                    if (result > 0) {
                        winner = participant;
                    }
                    time = scoreTime;

                }
            }
        }
        return winner;
    }

    public List<Participant> findAll() throws InterruptedException {
        List<Participant> participantList = this.participantRepository.findAll();
        for (Participant participant : participantList
        ) {
            List<IndividualScore> individualScoreList = individualScoreService.findIndividualScoresById(participant.getId());
            participant.setIndividualScoreList(individualScoreList);
        }
        return participantList;
    }
}
