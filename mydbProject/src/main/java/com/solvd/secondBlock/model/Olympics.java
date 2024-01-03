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
public class Olympics {
    private Long id;
    private OlympicsType olympicsType;
    private Country country;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Game> games = new ArrayList<>();
    private List<Scoreboard> scoreboards = new ArrayList<>();

}
