package com.solvd;

import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.mybatisimpl.SportTypeRepositoryBatisImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    static {
        System.setProperty("log4j2.configurationFile", "src/main/resources/log4j2.xml");
    }

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, SQLException {
//        //CREATING SPORTS
//        SportService sstest = new SportServiceImpl();
//        Sport sport = sstest.getById(1L);
//        LOGGER.info("random sport info " + sport.getId() + " " + sport.getName() + " " + sport.getSportType().getId());
//
//        SportType sportType = new SportType(1L, "name", false);
//        Sport sport1 = new Sport(1L, sportType, "test", "test");
//        Sport tst = sstest.create(sport1);
//        LOGGER.info("New sport " + tst.getId() + " " + tst.getName() + " " + tst.getSportType().getId());
//        sstest.deleteById(4L);
//        //Participant
//        CountryService cs = new CountryServiceImpl();
//        ParticipantService ps = new ParticipantServiceImpl();
//        Country country = cs.findById(2L);
//        sport = sstest.getById(1L);
//        Participant person = ps.findById(1L);
//        LOGGER.info("Person with id 1 " + person.getName() + " " + person.getSurname());
//        Participant personToUpdate = new Participant(1L, country, sport, "KK", "AA", LocalDate.now(), "Male", "Mail", null);
//        ps.updateById(1L, personToUpdate);
//        person = ps.findById(1L);
//        LOGGER.info("Person with id 1 after changes " + person.getName() + " " + person.getSurname());
//        try {
//            sstest.getById(4L);
//        } catch (NullPointerException e) {
//            LOGGER.info("data with index 4 deleted");
//            throw new NullPointerException();
//        }
        try {
            SportTypeRepositoryBatisImpl sportTypeDao = new SportTypeRepositoryBatisImpl();

            // Example: Find a SportType by ID
            Long sportTypeIdToFind = 3L; // Replace with the actual ID
            SportType foundSportType = sportTypeDao.findById(sportTypeIdToFind);

            if (foundSportType != null) {
                System.out.println("Found SportType with ID " + sportTypeIdToFind + ": " + foundSportType.getName());
            } else {
                System.out.println("SportType not found with ID: " + sportTypeIdToFind);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException("Error performing database operation", e);
        }
    }
}