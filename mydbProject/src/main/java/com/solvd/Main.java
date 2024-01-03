package com.solvd;

import com.solvd.secondBlock.model.*;
import com.solvd.secondBlock.service.CountryService;
import com.solvd.secondBlock.service.IndividualScoreService;
import com.solvd.secondBlock.service.ParticipantService;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.impl.CountryServiceImpl;
import com.solvd.secondBlock.service.impl.IndividualScoreServiceImpl;
import com.solvd.secondBlock.service.impl.ParticipantServiceImpl;
import com.solvd.secondBlock.service.impl.SportServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    static {
        System.setProperty("log4j2.configurationFile", "src/main/resources/log4j2.xml");
    }

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, SQLException {
        //CREATING SPORTS
        SportService sstest = new SportServiceImpl();
        Sport sport = sstest.getById(1L);
        LOGGER.info("random sport info " + sport.getId() + " " + sport.getName() + " " + sport.getSportType().getId());

        SportType sportType = new SportType(1L, "name", false);
        Sport sport1 = new Sport(1L, sportType, "test", "test");
        Sport tst = sstest.create(sport1);
        LOGGER.info("New sport " + tst.getId() + " " + tst.getName() + " " + tst.getSportType().getId());
        sstest.deleteById(4L);
        //Participant
        CountryService cs = new CountryServiceImpl();
        ParticipantService ps = new ParticipantServiceImpl();
        Country country = cs.findById(2L);
        sport = sstest.getById(1L);
        Participant person = ps.findById(1L);
        LOGGER.info("Person with id 1 " + person.getName() + " " + person.getSurname());
        Participant personToUpdate = new Participant(1L, country, sport, "KK", "AA", LocalDate.now(), "Male", "Mail", null);
        ps.updateById(1L, personToUpdate);
        person = ps.findById(1L);
        LOGGER.info("Person with id 1 after changes " + person.getName() + " " + person.getSurname());
        try {
            sstest.getById(4L);
        } catch (NullPointerException e) {
            LOGGER.info("data with index 4 deleted");
            throw new NullPointerException();
        }
    }
}