package com.solvd.secondBlock.model;

public class GameType {
    private long id;
    private String name;

    public GameType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
