package com.jeongjjuna.databaseservice;


import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan
public class BusinessCalculationService {

    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}
