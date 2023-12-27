package com.solvd;

import com.solvd.secondBlock.model.Venue;
import com.solvd.secondBlock.persistence.Impl.VenueRepositoryImpl;
import com.solvd.secondBlock.persistence.VenueRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "NewPassword");
    }

}