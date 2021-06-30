package com.simswap.swapi.service;

import com.simswap.swapi.model.Crew;
import com.simswap.swapi.model.Flight;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AirlineService {


    String getCrewByStaffNumber();
    Flight getFlightByNumber(String flightNumber);
    Crew getCrewByStaffNumber(Integer staffNumber);
    List<Flight> getAllFlights();
    List<Crew> getAllCrew();
    void addFlight(Flight flight);
    void addListOfCrew(List <Crew> listOfCrew);
    List <Crew> getCrewByFlightNumber(String flightNumber);
    String swapCrew(List<Integer> crewPair);
    void updateCrewAndFlightInfo(Crew firstCrew, Crew secondCrew);
    Crew createCrew(List<String> crewInfo);
    String assignCrew(Integer staffNumber, String flightNumber);
}

