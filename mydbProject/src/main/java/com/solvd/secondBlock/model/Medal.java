package com.solvd.secondBlock.model;

public class Medal {
    private long id;
    private String medal_name;

    public Medal(long id, String medal_name) {
        this.id = id;
        this.medal_name = medal_name;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedal_name() {
        return medal_name;
    }

    public void setMedal_name(String medal_name) {
        this.medal_name = medal_name;
    }
}
