package com.solvd.secondBlock.service.impl;


import com.solvd.secondBlock.persistence.SportRepository;
import com.solvd.secondBlock.service.SportService;
import com.solvd.secondBlock.service.SportTypeService;

public class SportServiceImpl implements SportService {
    private final SportTypeService sportTypeService;

    public SportServiceImpl() {
        this.sportTypeService = new SportTypeServiceImpl();
    }
}
