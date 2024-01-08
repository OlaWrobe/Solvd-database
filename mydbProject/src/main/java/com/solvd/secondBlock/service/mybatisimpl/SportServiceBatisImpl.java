package com.solvd.secondBlock.service.mybatisimpl;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.SportRepository;
import com.solvd.secondBlock.persistence.mybatisimpl.SportRepositoryBatisImpl;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.SportTypeService;

import java.sql.SQLException;

public class SportServiceBatisImpl implements SportService {

    private final SportTypeService sportTypeServiceBatis;
    private final SportRepository sportRepositoryBatis;

    public SportServiceBatisImpl() {
        this.sportTypeServiceBatis = new SportTypeServiceBatisImpl();
        this.sportRepositoryBatis = new SportRepositoryBatisImpl();
    }

    @Override
    public Sport create(Sport sport) throws InterruptedException {
        sport.setId(null);
        sportRepositoryBatis.create(sport);

        if (sport.getSportType().getId() == null) {
            sportTypeServiceBatis.create(sport.getSportType());
        }

        return sport;
    }

    @Override
    public Sport findById(Long id) throws InterruptedException {
        Sport sport = sportRepositoryBatis.findById(id);
        SportType sportType = sportTypeServiceBatis.findBySportId(sport.getId());
        sport.setSportType(sportType);
        return sport;
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        sportRepositoryBatis.deleteById(id);
    }

    @Override
    public void updateById(Long id, Sport sport) throws SQLException, InterruptedException {
        sport.setId(id);
        sportRepositoryBatis.updateById(id, sport);
    }

    @Override
    public Sport findByParticipantId(Long id) throws InterruptedException {
        return sportRepositoryBatis.findByParticipantId(id);
    }
}
