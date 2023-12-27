package com.solvd.secondBlock.model;

import java.sql.Time;

public class IndividualScore {
    private long id;
    private Participant participant;
    private Time time;
    private int points;
    private float distance;

    public IndividualScore(long id, Participant participant, Time time, int points, float distance) {
        this.id = id;
        this.participant = participant;
        this.time = time;
        this.points = points;
        this.distance = distance;
    }

    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
