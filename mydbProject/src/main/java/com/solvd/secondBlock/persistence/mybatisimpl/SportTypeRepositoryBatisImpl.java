package com.solvd.secondBlock.persistence.mybatisimpl;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.SportTypeRepository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class SportTypeRepositoryBatisImpl implements SportTypeRepository {

    @Override
    public void create(SportType entity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            sportRepository.create(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(@Param("id") Long id, @Param("updated") SportType updatedEntity) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportTypeRepository = sqlSession.getMapper(SportTypeRepository.class);
            sportTypeRepository.updateById(id, updatedEntity);
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

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            sportRepository.deleteById(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SportType findById(Long id) throws InterruptedException {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            return sportRepository.findById(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SportType findBySportID(Long sportId) {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true)) {

            SportTypeRepository sportRepository = sqlSession.getMapper(SportTypeRepository.class);
            return sportRepository.findBySportID(sportId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
