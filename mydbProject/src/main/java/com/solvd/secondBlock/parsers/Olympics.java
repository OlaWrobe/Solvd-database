package com.solvd.secondBlock.parsers;

import com.solvd.secondBlock.model.Sport;
import com.solvd.secondBlock.model.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Olympics {
    private List<Sport> sports;
    private List<Team> teams;
}