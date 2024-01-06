package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.SportTypeRepository;
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

public class SportTypeRepositoryBatisImpl implements SportTypeRepository {

    private SqlSessionFactory sessionFactory;

    @Override
    public void create(SportType entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            sportRepository.create(entity);

            sqlSession.commit();  // Remember to commit changes
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportTypeDao", e);
        }
    }

    @Override
    public void updateById(Long id, SportType updatedEntity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("updatedEntity", updatedEntity);
            sportRepository.updateById(id, updatedEntity);

            sqlSession.commit();  // Remember to commit changes
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportTypeDao", e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            sportRepository.deleteById(id);

            sqlSession.commit();  // Remember to commit changes
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportTypeDao", e);
        }
    }

    @Override
    public SportType findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            return sportRepository.findById(id);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SportTypeDao", e);
        }
    }

    @Override
    public SportType findBySportID(Long sportId) throws InterruptedException {
        return null;
    }
}
