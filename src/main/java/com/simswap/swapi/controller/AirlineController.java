package com.simswap.swapi.controller;

import com.simswap.swapi.model.Crew;
import com.simswap.swapi.model.Flight;
import com.simswap.swapi.service.DefaultAirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class AirlineController {
    //TODO
    //why field injection not recommended?
    @Autowired
    private DefaultAirlineService defaultAirlineService;

    @GetMapping("/teste")
    public String firstTest() {
        return "Très bien, demoiselle!";
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return defaultAirlineService.getAllFlights();
    }

    @GetMapping("/flight/{flightNumber}")
    public Flight getFlightByNumber(@PathVariable String flightNumber) {
        return defaultAirlineService.getFlightByNumber(flightNumber);
    }

    @GetMapping("/crew")
    public List<Crew> getAllCrew() {
        return defaultAirlineService.getAllCrew();
    }

    @PostMapping("/crew")
    public Crew createCrew(@RequestBody List<String> crewInfo) {
        return defaultAirlineService.createCrew(crewInfo);
    }

    @GetMapping("/crew/{staffNumber}")
    public Crew getCrewByStaffNumber(@PathVariable Integer staffNumber) {
        return defaultAirlineService.getCrewByStaffNumber(staffNumber);
    }

    //for test only. add filtering features to crew endpoint
    @GetMapping("/crew/flight/{flightNumber}")
    public List<Crew> getCrewByFlightNumber(@PathVariable String flightNumber) {
        return defaultAirlineService.getCrewByFlightNumber(flightNumber);
    }

    //TODO
    //implementar swap, ver como passar 2 parametros, melhorar interface. swap no es una resource? creo una?
    @PostMapping("swap")
    public String swapCrew(@RequestBody List<Integer> crewPair) {
        return defaultAirlineService.swapCrew(crewPair);
    }

    @PatchMapping("/crew/{staffNumber}")
    public String assignFlight(@PathVariable Integer staffNumber, @RequestParam String flightNumber) {
        return defaultAirlineService.assignCrew(staffNumber, flightNumber);
    }




}
