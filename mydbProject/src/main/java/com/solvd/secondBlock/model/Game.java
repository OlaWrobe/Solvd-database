package com.solvd.secondBlock.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private long id;
    private Venue venue;
    private Sport sport;
    private GameType gameType;
    private List<IndividualScore> individualScoreList = new ArrayList<>();
    private List<TeamScore> teamScoreList = new ArrayList<>();
    private Participant winnerParticipant;
    private Team winningTeam;
    private String result;
    private LocalDate date_of_game;

    public Game(long id, Venue venue, Sport sport, GameType gameType, List<IndividualScore> individualScoreList, List<TeamScore> teamScoreList, Participant winnerParticipant, Team winningTeam, String result, LocalDate date_of_game) {
        this.id = id;
        this.venue = venue;
        this.sport = sport;
        this.gameType = gameType;
        this.individualScoreList = individualScoreList;
        this.teamScoreList = teamScoreList;
        this.winnerParticipant = winnerParticipant;
        this.winningTeam = winningTeam;
        this.result = result;
        this.date_of_game = date_of_game;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public List<IndividualScore> getIndividualScoreList() {
        return individualScoreList;
    }

    public void setIndividualScoreList(List<IndividualScore> individualScoreList) {
        this.individualScoreList = individualScoreList;
    }

    public List<TeamScore> getTeamScoreList() {
        return teamScoreList;
    }

    public void setTeamScoreList(List<TeamScore> teamScoreList) {
        this.teamScoreList = teamScoreList;
    }

    public Participant getWinnerParticipant() {
        return winnerParticipant;
    }

    public void setWinnerParticipant(Participant winnerParticipant) {
        this.winnerParticipant = winnerParticipant;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getDate_of_game() {
        return date_of_game;
    }

    public void setDate_of_game(LocalDate date_of_game) {
        this.date_of_game = date_of_game;
    }
}
