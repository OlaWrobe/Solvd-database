package com.solvd.secondBlock.model;

public class Sport {
    private long id;
    private SportType sportType;
    private String name;
    private String description;

    public Sport(long id, SportType sportType, String name, String description) {
        this.id = id;
        this.sportType = sportType;
        this.name = name;
        this.description = description;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
