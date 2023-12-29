package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.persistence.SportRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class SportRepositoryBatisImpl implements SportRepositoryMyBatis {

    @Override
    public Optional<Sport> findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);
            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);

            Sport sport2 = sportRepository.findById(2L);
            return Optional.ofNullable(sport2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
