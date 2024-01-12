package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Country;
import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.persistence.CountryRepository;
import com.solvd.secondBlock.persistence.SportRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class CountryRepositoryBatisImpl implements CountryRepository {
    @Override
    public void create(Country country) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            countryRepository.create(country);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, Country updatedCountry) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            countryRepository.updateById(id, updatedCountry);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            countryRepository.deleteById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Country findById(Long id) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            return countryRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Country findByParticipantId(Long id) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            return countryRepository.findByParticipantId(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Country findByTeamId(Long id) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            CountryRepository countryRepository = sqlSession.getMapper(CountryRepository.class);
            return countryRepository.findByTeamId(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
