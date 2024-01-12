package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Venue;
import com.solvd.secondBlock.persistence.TeamScoreRepository;
import com.solvd.secondBlock.persistence.VenueRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class VenueRepositoryBatisImpl implements VenueRepository {
    @Override
    public void create(Venue entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            VenueRepository venueRepository = sqlSession.getMapper(VenueRepository.class);
            venueRepository.create(entity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, Venue updatedEntity) throws InterruptedException, SQLException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            VenueRepository venueRepository = sqlSession.getMapper(VenueRepository.class);
            venueRepository.updateById(id, updatedEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            VenueRepository venueRepository = sqlSession.getMapper(VenueRepository.class);
            venueRepository.deleteById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Venue findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            VenueRepository venueRepository = sqlSession.getMapper(VenueRepository.class);
            return venueRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Venue> findAll() throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            VenueRepository venueRepository = sqlSession.getMapper(VenueRepository.class);
            return venueRepository.findAll();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
