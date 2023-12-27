package com.solvd.secondBlock.model;

import java.util.ArrayList;
import java.util.List;

public class SportType {
    private long id;
    private String name;
    private boolean is_individual;

    public SportType(long id, String name, boolean is_individual) {
        this.id = id;
        this.name = name;
        this.is_individual = is_individual;
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

    public boolean isIs_individual() {
        return is_individual;
    }

    public void setIs_individual(boolean is_individual) {
        this.is_individual = is_individual;
    }
}
