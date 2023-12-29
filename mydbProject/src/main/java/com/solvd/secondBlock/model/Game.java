package com.solvd.secondBlock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private Long id;
    private Venue venue;
    private Sport sport;
    private GameType gameType;
    private List<IndividualScore> individualScoreList = new ArrayList<>();
    private List<TeamScore> teamScoreList = new ArrayList<>();
    private Participant winnerParticipant;
    private Team winningTeam;
    private String result;
    private LocalDate dateOfGame;
}
