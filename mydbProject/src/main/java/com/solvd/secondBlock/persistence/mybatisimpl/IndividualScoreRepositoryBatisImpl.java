package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.IndividualScore;
import com.solvd.secondBlock.persistence.CountryRepository;
import com.solvd.secondBlock.persistence.IndividualScoreRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class IndividualScoreRepositoryBatisImpl implements IndividualScoreRepository {

    @Override
    public void create(IndividualScore entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            IndividualScoreRepository individualScoreRepository = sqlSession.getMapper(IndividualScoreRepository.class);
            individualScoreRepository.create(entity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, IndividualScore updatedEntity) throws InterruptedException, SQLException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            IndividualScoreRepository individualScoreRepository = sqlSession.getMapper(IndividualScoreRepository.class);
            individualScoreRepository.updateById(id, updatedEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            IndividualScoreRepository individualScoreRepository = sqlSession.getMapper(IndividualScoreRepository.class);
            individualScoreRepository.deleteById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IndividualScore findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            IndividualScoreRepository individualScoreRepository = sqlSession.getMapper(IndividualScoreRepository.class);
            return individualScoreRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<IndividualScore> findIndividualScoresById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            IndividualScoreRepository individualScoreRepository = sqlSession.getMapper(IndividualScoreRepository.class);
            return individualScoreRepository.findIndividualScoresById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
