package com.solvd;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.SportType;
import com.solvd.secondBlock.model.Venue;
import com.solvd.secondBlock.persistence.Impl.VenueRepositoryImpl;
import com.solvd.secondBlock.persistence.VenueRepository;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.VenueService;
import com.solvd.secondBlock.service.impl.SportServiceImpl;
import com.solvd.secondBlock.service.impl.VenueServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {
        SportService sstest = new SportServiceImpl();
        Sport sport = sstest.getById(1L);
        System.out.println(sport.getId() + " " + sport.getName() + " " + sport.getSportType().getId());
        //VENUE SERVICE TEST
        SportType sportType = new SportType(1L, "name", false);
        Sport sport1 = new Sport(1L, sportType, "test", "test");
        sstest.create(sport1);
        sstest.deleteById(4L);
        sstest.updateById(3L, sport1);
    }

}