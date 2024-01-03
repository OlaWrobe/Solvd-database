package com.solvd.secondBlock.persistence;

import java.sql.SQLException;

public interface UniversalDao<T> {
    void create(T entity) throws InterruptedException;

    void updateById(Long id, T updatedEntity) throws InterruptedException, SQLException;

    void deleteById(Long id) throws InterruptedException;

    T findById(Long id) throws InterruptedException;
}
