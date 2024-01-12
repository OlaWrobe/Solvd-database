package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Participant;
import com.solvd.secondBlock.persistence.ParticipantRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class ParticipantRepositoryBatisImpl implements ParticipantRepository {
    @Override
    public Participant findCaptainByTeamId(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            return participantRepository.findCaptainByTeamId(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Participant> findPlayersByTeamId(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            return participantRepository.findPlayersByTeamId(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Participant> findAll() throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            return participantRepository.findAll();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Participant entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            participantRepository.create(entity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Long id, Participant updatedEntity) throws InterruptedException, SQLException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            participantRepository.updateById(id, updatedEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            participantRepository.deleteById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Participant findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            ParticipantRepository participantRepository = sqlSession.getMapper(ParticipantRepository.class);
            return participantRepository.findById(id);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
