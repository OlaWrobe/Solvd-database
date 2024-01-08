package com.solvd;

import com.solvd.secondBlock.model.Participant;
import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.persistence.ParticipantRepository;
import com.solvd.secondBlock.persistence.impl.ParticipantRepositoryImpl;
import com.solvd.secondBlock.persistence.mybatisimpl.SportTypeRepositoryBatisImpl;
import com.solvd.secondBlock.service.ParticipantService;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.SportTypeService;
import com.solvd.secondBlock.service.impl.ParticipantServiceImpl;
import com.solvd.secondBlock.service.impl.SportServiceImpl;
import com.solvd.secondBlock.service.impl.SportTypeServiceImpl;
import com.solvd.secondBlock.service.mybatisimpl.SportServiceBatisImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

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
//        try {
//            SportTypeRepositoryBatisImpl sportTypeDao = new SportTypeRepositoryBatisImpl();
//
//            // Example: Find a SportType by ID
//            Long sportTypeIdToFind = 3L; // Replace with the actual ID
//            SportType foundSportType = sportTypeDao.findById(sportTypeIdToFind);
//
//            if (foundSportType != null) {
//                System.out.println("Found SportType with ID " + sportTypeIdToFind + ": " + foundSportType.getName());
//            } else {
//                System.out.println("SportType not found with ID: " + sportTypeIdToFind);
//            }
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException("Error performing database operation", e);
//        }

        //MYBATIS
        SportService sportService = new SportServiceBatisImpl();
        SportTypeService sportTypeService = new SportTypeServiceImpl();

        SportType sportType = sportTypeService.findById(1L);

        Sport sport = new Sport(null, sportType, "Soccer", "Description for Soccer");

        sportService.create(sport);
        LOGGER.info("Created Sport: " + sport.getName());

        Sport retrievedSport = sportService.findById(1L);
        LOGGER.info("Retrieved Sport by ID: " + retrievedSport.getDescription());

        retrievedSport.setName("Footballxd");
        sportService.updateById(2L, retrievedSport);
        LOGGER.info("Updated Sport to name footballxd: " + retrievedSport.getName());

        Long participantId = 1L;
        Sport sportByParticipant = sportService.findByParticipantId(participantId);
        LOGGER.info("Sport found by Participant ID " + participantId + ": " + sportByParticipant.getName());

        sportService.deleteById(2L);
        LOGGER.info("Deleted Sport with ID: " + 2L);

        //business logic
        ParticipantService participantService = new ParticipantServiceImpl();

        Participant winner = participantService.findWinner();
        LOGGER.info("winner is player " + winner.getName() + " " + winner.getSurname());

    }
}