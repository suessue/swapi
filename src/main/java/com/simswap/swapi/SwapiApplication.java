package com.simswap.swapi;

import com.simswap.swapi.model.Crew;
import com.simswap.swapi.model.Flight;
import com.simswap.swapi.service.AirlineService;
import com.simswap.swapi.service.DefaultAirlineService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SwapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwapiApplication.class, args);
    }


//    @Bean
//    public AirlineService initializeAirline() {
//        return new DefaultAirlineService().initializeAirline();
//    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            //test beans
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }

            //test initialize Airline
//                AirlineService airlineService = new DefaultAirlineService();
//
//                List<Crew> crew = airlineService.getAllCrew();
//
//                for (Crew c : crew) {
//                    System.out.println(c.getName());
//                }


        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//    }
}
