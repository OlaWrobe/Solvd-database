package com.solvd.secondBlock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class TeamScore {
    private Long id;
    private Game game;
    private int teamPoints;
    private Time teamTime;

}
