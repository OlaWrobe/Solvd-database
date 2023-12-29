package com.solvd.secondBlock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class IndividualScore {
    private Long id;
    private Time time;
    private int points;
    private float distance;

}
