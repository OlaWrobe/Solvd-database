package com.solvd;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.SportRepository;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.impl.SportServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class Main {
    static {
        System.setProperty("log4j2.configurationFile", "src/main/resources/log4j2.xml");
    }

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, SQLException {
//        SportService sstest = new SportServiceImpl();
//        Sport sport = sstest.getById(1L);
//        System.out.println(sport.getId() + " " + sport.getName() + " " + sport.getSportType().getId());
//        //VENUE SERVICE TEST
//        SportType sportType = new SportType(1L, "name", false);
//        Sport sport1 = new Sport(1L, sportType, "test", "test");
//        sstest.create(sport1);
//        sstest.deleteById(4L);
//        sstest.updateById(3L, sport1);

        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);
            SportRepository sportRepository = sqlSession.getMapper(SportRepository.class);

            Sport sport2 = sportRepository.findById(2L);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}