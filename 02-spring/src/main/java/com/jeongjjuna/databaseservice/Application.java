package com.jeongjjuna.databaseservice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        try(var context =
                    new AnnotationConfigApplicationContext(BusinessCalculationService.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
