package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Team;
import com.solvd.secondBlock.model.TeamScore;
import com.solvd.secondBlock.persistence.TeamRepository;
import com.solvd.secondBlock.persistence.TeamScoreRepository;
import com.solvd.secondBlock.persistence.impl.TeamScoreRepositoryImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class TeamScoreRepositoryBatisImpl implements TeamScoreRepository {
    @Override
    public List<TeamScore> findScoresById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamScoreRepository teamScoreRepository = sqlSession.getMapper(TeamScoreRepository.class);
            return teamScoreRepository.findScoresById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(TeamScore entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamScoreRepository teamScoreRepository = sqlSession.getMapper(TeamScoreRepository.class);
            teamScoreRepository.create(entity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, TeamScore updatedEntity) throws InterruptedException, SQLException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamScoreRepository teamScoreRepository = sqlSession.getMapper(TeamScoreRepository.class);
            teamScoreRepository.findScoresById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamScoreRepository teamScoreRepository = sqlSession.getMapper(TeamScoreRepository.class);
            teamScoreRepository.deleteById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TeamScore findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            TeamScoreRepository teamScoreRepository = sqlSession.getMapper(TeamScoreRepository.class);
            return teamScoreRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
