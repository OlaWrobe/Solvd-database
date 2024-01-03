package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
//        Sport tst = sstest.create(sport1);
//        System.out.println(tst.getId());
//        sstest.deleteById(4L);
//        sstest.updateById(3L, sport1);

    }
}