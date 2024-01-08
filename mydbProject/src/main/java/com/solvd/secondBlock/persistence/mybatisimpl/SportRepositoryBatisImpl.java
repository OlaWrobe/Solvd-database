package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.persistence.SportRepository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class SportRepositoryBatisImpl implements SportRepository {

    @Override
    public void create(Sport entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            sportRepository.create(entity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(@Param("id") Long id, @Param("updated") Sport updatedEntity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            sportRepository.updateById(id, updatedEntity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            sportRepository.deleteById(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Sport findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            return sportRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Sport findByParticipantId(Long participantId) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            return sportRepository.findByParticipantId(participantId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
