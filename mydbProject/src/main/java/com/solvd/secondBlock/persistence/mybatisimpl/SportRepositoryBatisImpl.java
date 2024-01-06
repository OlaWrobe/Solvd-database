package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.persistence.SportRepository;
import com.solvd.secondBlock.persistence.UniversalDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SportRepositoryBatisImpl implements UniversalDao<Sport> {

    private SqlSessionFactory sessionFactory;

    @Override
    public void create(Sport entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            sportRepository.create(entity);

            sqlSession.commit();  // Remember to commit changes
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportRepository", e);
        }
    }

    @Override
    public void updateById(Long id, Sport updatedEntity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("updatedEntity", updatedEntity);
            sportRepository.updateById(id, updatedEntity);

            sqlSession.commit();  // Remember to commit changes
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportRepository", e);
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

            sqlSession.commit();  // Remember to commit changes
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportRepository", e);
        }
    }

    @Override
    public Sport findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);
            return sportRepository.findById(id);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportRepository", e);
        }
    }
}
