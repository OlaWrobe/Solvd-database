package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Team;
import com.solvd.secondBlock.persistence.IndividualScoreRepository;
import com.solvd.secondBlock.persistence.TeamRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class TeamRepositoryBatisImpl implements TeamRepository {
    @Override
    public void create(Team entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamRepository teamRepository = sqlSession.getMapper(TeamRepository.class);
            teamRepository.create(entity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, Team updatedEntity) throws InterruptedException, SQLException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamRepository teamRepository = sqlSession.getMapper(TeamRepository.class);
            teamRepository.updateById(id, updatedEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamRepository teamRepository = sqlSession.getMapper(TeamRepository.class);
            teamRepository.deleteById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Team findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamRepository teamRepository = sqlSession.getMapper(TeamRepository.class);
            return teamRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
