package com.solvd.secondBlock.model;

public class Country {
    private long id;
    private String country_name;

    public Country(long id, String country_name) {
        this.id = id;
        this.country_name = country_name;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
