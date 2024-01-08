package com.solvd.secondBlock.service;

import com.solvd.secondBlock.model.Sport;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface SportService {
    public Sport create(Sport sport) throws InterruptedException;

    public Sport findById(Long id) throws InterruptedException;

    public void deleteById(Long id) throws InterruptedException;

    public void updateById(Long id, Sport sport) throws InterruptedException, SQLException;

    public Sport findByParticipantId(Long id) throws InterruptedException;
}
