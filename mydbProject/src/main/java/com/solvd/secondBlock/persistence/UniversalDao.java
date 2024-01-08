package com.solvd.secondBlock.persistence;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface UniversalDao<T> {
    void create(T entity) throws InterruptedException;

    void updateById(@Param("id") Long id, @Param("updated") T updatedEntity) throws InterruptedException, SQLException;

    void deleteById(Long id) throws InterruptedException;

    T findById(Long id) throws InterruptedException;
}
