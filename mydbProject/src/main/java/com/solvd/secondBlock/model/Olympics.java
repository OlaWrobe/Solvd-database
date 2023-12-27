package com.solvd.secondBlock.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Olympics {
    private long id;
    private OlympicsType olympicsType;
    private Country country;
    private String name;
    private LocalDate start_date;
    private LocalDate end_date;
    private List<Game> games = new ArrayList<>();
    private List<Scoreboard> scoreboards = new ArrayList<>();

    public Olympics(long id, OlympicsType olympicsType, Country country, String name, LocalDate start_date, LocalDate end_date, List<Game> games, List<Scoreboard> scoreboards) {
        this.id = id;
        this.olympicsType = olympicsType;
        this.country = country;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.games = games;
        this.scoreboards = scoreboards;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OlympicsType getOlympicsType() {
        return olympicsType;
    }

    public void setOlympicsType(OlympicsType olympicsType) {
        this.olympicsType = olympicsType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Scoreboard> getScoreboards() {
        return scoreboards;
    }

    public void setScoreboards(List<Scoreboard> scoreboards) {
        this.scoreboards = scoreboards;
    }
}
