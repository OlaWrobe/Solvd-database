package com.solvd.secondBlock.service.impl;


import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.impl.SportRepositoryImpl;
import com.solvd.secondBlock.persistence.SportRepository;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.SportTypeService;

import java.sql.SQLException;

public class SportServiceImpl implements SportService {
    private final SportTypeService sportTypeService;
    private final SportRepository sportRepository;

    public SportServiceImpl() {
        this.sportTypeService = new SportTypeServiceImpl();
        this.sportRepository = new SportRepositoryImpl();
    }

    public Sport create(Sport sport) throws InterruptedException {
        sport.setId(null);
        sportRepository.create(sport);
        if (sport.getSportType().getId() == null) {
            sportTypeService.create(sport.getSportType());
        }
        return sport;
    }

    public Sport getById(Long id) throws InterruptedException {
        Sport sport = sportRepository.findById(id);
        SportType sportType = sportTypeService.findBySportId(sport.getId());
        sport.setSportType(sportType);
        return sport;
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        sportRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, Sport sport) throws InterruptedException, SQLException {
        sportRepository.updateById(id, sport);
    }

    public Sport findByParticipantId(Long id) throws InterruptedException {
        return sportRepository.findByParticipantId(id);
    }

}
