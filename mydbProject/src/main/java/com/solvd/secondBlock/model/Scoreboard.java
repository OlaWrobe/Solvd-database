package com.solvd.secondBlock.model;


import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
    private long id;
    private Sport sport;
    private Map<Participant, Object[]> participantMedalsAndPlaces = new HashMap<>();
    private Map<Team, Object[]> teamMedalsAndPlaces = new HashMap<>();

    public Scoreboard(long id, Sport sport, Map<Participant, Object[]> participantMedalsAndPlaces, Map<Team, Object[]> teamMedalsAndPlaces) {
        this.id = id;
        this.sport = sport;
        this.participantMedalsAndPlaces = participantMedalsAndPlaces;
        this.teamMedalsAndPlaces = teamMedalsAndPlaces;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Map<Participant, Object[]> getParticipantMedalsAndPlaces() {
        return participantMedalsAndPlaces;
    }

    public void setParticipantMedalsAndPlaces(Map<Participant, Object[]> participantMedalsAndPlaces) {
        this.participantMedalsAndPlaces = participantMedalsAndPlaces;
    }

    public Map<Team, Object[]> getTeamMedalsAndPlaces() {
        return teamMedalsAndPlaces;
    }

    public void setTeamMedalsAndPlaces(Map<Team, Object[]> teamMedalsAndPlaces) {
        this.teamMedalsAndPlaces = teamMedalsAndPlaces;
    }
}
