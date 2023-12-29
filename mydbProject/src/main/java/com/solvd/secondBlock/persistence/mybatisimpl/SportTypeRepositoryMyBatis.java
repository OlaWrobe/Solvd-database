package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.SportType;
import org.apache.ibatis.annotations.Param;

public interface SportTypeRepositoryMyBatis {
    public void create(@Param("sportType") SportType sportType, @Param("SportId") Long SportId);

    void addSport(@Param("sportTypeId") Long sportTypeId, @Param("sportId") Long sportId);
}
