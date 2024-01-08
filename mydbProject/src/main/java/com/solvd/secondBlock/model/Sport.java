package com.solvd.secondBlock.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sport {
    private Long id;
    private SportType sportType;
    private String name;
    private String description;

}
