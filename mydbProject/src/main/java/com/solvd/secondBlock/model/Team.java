package com.solvd.secondBlock.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private long id;
    private Country country;
    private Participant captain;
    private String team_name;
    private int squad_size;
    private List<Participant> players = new ArrayList<>();

    public Team(long id, Country country, Participant captain, String team_name, int squad_size, List<Participant> players) {
        this.id = id;
        this.country = country;
        this.captain = captain;
        this.team_name = team_name;
        this.squad_size = squad_size;
        this.players = players;
    }
//GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Participant getCaptain() {
        return captain;
    }

    public void setCaptain(Participant captain) {
        this.captain = captain;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getSquad_size() {
        return squad_size;
    }

    public void setSquad_size(int squad_size) {
        this.squad_size = squad_size;
    }

    public List<Participant> getPlayers() {
        return players;
    }

    public void setPlayers(List<Participant> players) {
        this.players = players;
    }
}
