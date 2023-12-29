package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Sport;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.Optional;

public interface SportRepositoryMyBatis {
    //public void create(Sport sport) throws InterruptedException;

    //public void updateById(@Param("sportId") Long id, @Param("sport") Sport updatedSport) throws InterruptedException, SQLException;

    //public void deleteById(Long id) throws InterruptedException;

    public Optional<Sport> findById(Long id) throws InterruptedException;
}
