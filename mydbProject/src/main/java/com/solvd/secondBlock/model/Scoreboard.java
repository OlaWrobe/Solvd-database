package com.solvd.secondBlock.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Scoreboard {
    private Long id;
    private Sport sport;
    private Map<Participant, Object[]> participantMedalsAndPlaces = new HashMap<>();
    private Map<Team, Object[]> teamMedalsAndPlaces = new HashMap<>();

}
