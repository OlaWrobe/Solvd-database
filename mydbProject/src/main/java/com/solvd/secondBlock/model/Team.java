package com.solvd.secondBlock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Team {
    private Long id;
    private Country country;
    private Participant captain;
    private String teamName;
    private int squadSize;
    private List<Participant> players = new ArrayList<>();
    private List<TeamScore> teamScoreList = new ArrayList<>();

}
