package com.solvd.secondBlock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    private Long id;
    private Country country;
    private Sport sport;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String gender;
    private String email;
    private List<IndividualScore> individualScoreList;
}
