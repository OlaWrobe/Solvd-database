package com.solvd.secondBlock.model;

import java.sql.Time;

public class TeamScore {
    private long id;
    private Team team;
    private Game game;
    private int team_points;
    private Time team_time;

    public TeamScore(long id, Team team, Game game, int team_points, Time team_time) {
        this.id = id;
        this.team = team;
        this.game = game;
        this.team_points = team_points;
        this.team_time = team_time;
    }
//GETTERS AND SETTERS

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTeam_points() {
        return team_points;
    }

    public void setTeam_points(int team_points) {
        this.team_points = team_points;
    }

    public Time getTeam_time() {
        return team_time;
    }

    public void setTeam_time(Time team_time) {
        this.team_time = team_time;
    }
}
