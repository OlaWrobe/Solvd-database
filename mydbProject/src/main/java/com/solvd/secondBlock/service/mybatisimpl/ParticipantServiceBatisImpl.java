package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.*;
import com.solvd.secondBlock.persistence.ParticipantRepository;
import com.solvd.secondBlock.persistence.mybatisimpl.ParticipantRepositoryBatisImpl;
import com.solvd.secondBlock.service.*;
import com.solvd.secondBlock.service.impl.IndividualScoreServiceImpl;
import com.solvd.secondBlock.service.impl.ParticipantServiceImpl;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class ParticipantServiceBatisImpl implements ParticipantService {
    private final ParticipantRepository participantRepositoryBatis;
    private final CountryService countryServiceBatis;
    private final IndividualScoreService individualScoreService;
    private final SportService sportServiceBatis;
    private final SportTypeService sportTypeServiceBatis;

    public ParticipantServiceBatisImpl() {
        this.participantRepositoryBatis = new ParticipantRepositoryBatisImpl();
        this.countryServiceBatis = new CountryServiceBatisimpl();
        this.individualScoreService = new IndividualScoreServiceBatisImpl();
        this.sportServiceBatis = new SportServiceBatisImpl();
        this.sportTypeServiceBatis = new SportTypeServiceBatisImpl();
    }

    @Override
    public void create(Participant participant) throws InterruptedException {
        participant.setId(null);
        this.participantRepositoryBatis.create(participant);
    }

    @Override
    public void updateById(Long id, Participant updatedParticipant) throws InterruptedException, SQLException {
        this.participantRepositoryBatis.updateById(id, updatedParticipant);
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        this.participantRepositoryBatis.deleteById(id);
    }

    @Override
    public Participant findById(Long id) throws InterruptedException {
        Participant participant = participantRepositoryBatis.findById(id);

        Country country = countryServiceBatis.findByParticipantId(id);
        participant.setCountry(country);

        Sport sport = sportServiceBatis.findByParticipantId(id);
        SportType sportType = sportTypeServiceBatis.findBySportId(sport.getId());
        sport.setSportType(sportType);

        participant.setSport(sport);

        List<IndividualScore> individualScoreList = individualScoreService.findIndividualScoresById(id);
        participant.setIndividualScoreList(individualScoreList);
        return participant;
    }

    @Override
    public Participant findCaptainByTeamId(Long id) throws InterruptedException {
        return this.participantRepositoryBatis.findCaptainByTeamId(id);
    }

    public List<Participant> findPlayersByTeamId(Long id) throws InterruptedException {
        return this.participantRepositoryBatis.findPlayersByTeamId(id);
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

    @Override
    public List<Participant> findAll() throws InterruptedException {
        List<Participant> participantList = this.participantRepositoryBatis.findAll();
        for (Participant participant : participantList
        ) {
            List<IndividualScore> individualScoreList = individualScoreService.findIndividualScoresById(participant.getId());
            participant.setIndividualScoreList(individualScoreList);
        }
        return participantList;
    }
}
