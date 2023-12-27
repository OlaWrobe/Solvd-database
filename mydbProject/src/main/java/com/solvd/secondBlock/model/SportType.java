package com.solvd.secondBlock.model;

import java.util.ArrayList;
import java.util.List;

public class SportType {
    private long id;
    private String name;
    private boolean isIndividual;

    public SportType(long id, String name, boolean isIndividual) {
        this.id = id;
        this.name = name;
        this.isIndividual = isIndividual;
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

    public boolean getisIndividual() {
        return isIndividual;
    }

    public void setisIndividual(boolean isIndividual) {
        this.isIndividual = isIndividual;
    }
}
