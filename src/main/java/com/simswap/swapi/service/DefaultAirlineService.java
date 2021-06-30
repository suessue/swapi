package com.simswap.swapi.service;

import com.simswap.swapi.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
public class DefaultAirlineService implements AirlineService {

    private final List<Crew> allCrew;
    private final List<Flight> allFlights;


    //TODO
    //check if there's a better way to initialize this service.
    public DefaultAirlineService() {
        System.out.println("LOADING AIRLINE DATA...");
        LocalDate today = LocalDate.of(2020, Month.NOVEMBER, 23);

        //creating flights
        Flight flight1 = new Flight("001", "LHR", today);
        Flight flight2 = new Flight("247", "EZE", today);
        Flight flight3 = new Flight("500", "BOM", today);

        //adding flights to flight list
        this.allFlights = new ArrayList<>(Arrays.asList(flight1, flight2, flight3));

        //creating FLight crew (First example just to test different constructor for flightCrew)
        Crew cap1 = new FlightCrew(111, "John Smith", Position.CAP);
        cap1.setLicense(1111);
        Crew cap2 = new FlightCrew(222, "Moh Zayed", Position.CAP, 2222);
        Crew fo1 = new FlightCrew(444, "Ahmed Al Maktoum", Position.FO, 4444);
        Crew fo2 = new FlightCrew(555, "Tom Banks", Position.FO, 5555);

        //creating Cabin crew
        Crew sc1 = new CabinCrew(666, "Maria Bonita", Position.SC, 6666);
        Crew sc2 = new CabinCrew(777, "Tano Moltisanti", Position.SC, 7777);
        Crew cc1 = new CabinCrew(888, "Galley Queen", Position.CC, 8888);
        Crew cc2 = new CabinCrew(999, "Super Suppy", Position.CC, 9999);

        //adding crew to flights and updating assigned flight info for crew

        flight1.addFullCrew(cap1, fo1, sc1, cc1);
        flight2.addFullCrew(cap2, fo2, sc2, cc2);

        //updating Airline Crew List
        allCrew = new ArrayList<>(Arrays.asList(cap1, cap2, fo1, fo2, sc1, sc2, cc1, cc2));

    }

    public DefaultAirlineService(List<Crew> allCrew, List<Flight> allFlights) {
        this.allCrew = allCrew;
        this.allFlights = allFlights;
    }


    @Override
    public String getCrewByStaffNumber() {
        return null;
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        return allFlights.stream().filter(f -> f.getFlightNumber()
                .equals(flightNumber)).findFirst().orElse(null);
    }

    @Override
    public Crew getCrewByStaffNumber(Integer staffNumber) {
        return allCrew.stream().filter(c -> c.getStaffNumber()
                .equals(staffNumber)).findFirst().orElse(null);
    }

    @Override
    public List<Flight> getAllFlights() {
        return allFlights;
    }

    @Override
    public List<Crew> getAllCrew() {
        return allCrew;
    }

    @Override
    public void addListOfCrew(List<Crew> crewList) {
        allCrew.addAll(crewList);
    }

    @Override
    public List<Crew> getCrewByFlightNumber(String flightNumber) {
        Flight flight = allFlights.stream().filter(f -> f.getFlightNumber().equals(flightNumber))
                .findFirst().orElse(null);
        return flight != null ? flight.getCrew() : null;
    }


    @Override
    public void addFlight(Flight flight) {
        allFlights.add(flight);
    }

    @Override
    public String swapCrew(List<Integer> crewPair) {
        Crew firstCrew = getCrewByStaffNumber(crewPair.get(0));
        Crew secondCrew = getCrewByStaffNumber(crewPair.get(1));

        if (firstCrew.getPosition().equals(secondCrew.getPosition())) {
            updateCrewAndFlightInfo(firstCrew, secondCrew);
            return "SUCCESSFUL OPERATION.";
        } else {
            return "INVALID OPERATION. PLEASE CHECK YOUR INFO";
        }
    }

    public void updateCrewAndFlightInfo(Crew firstCrew, Crew secondCrew) {

        Flight flightFirstCrewBeforeSwap = firstCrew.getAssignedFlight();
        firstCrew.setAssignedFlight(secondCrew.getAssignedFlight());
        secondCrew.setAssignedFlight(flightFirstCrewBeforeSwap);
        //update flight information for each crew
        firstCrew.getAssignedFlight().replaceCrew(firstCrew, secondCrew);
        secondCrew.getAssignedFlight().replaceCrew(secondCrew, firstCrew);

        System.out.println("*****SWAP SUCCESSFUL*****\n");

    }

    public Crew createCrew(List<String> crewInfo){

        if (crewInfo.size() != 4) {
            System.out.println("*** SEND REQUIRED INFO, ONLY ***");
            return null;

        }

        Integer staffNumber = Integer.parseInt(crewInfo.get(0));
        String name = crewInfo.get(1);
        Position position = Position.valueOf(crewInfo.get(2));
        Integer license = Integer.parseInt(crewInfo.get(3));

        Crew newCrew;

        if (position.equals(Position.FO) || position.equals(Position.CAP)){
            newCrew = new FlightCrew(staffNumber, name, position, license);

        } else {
            newCrew = new CabinCrew(staffNumber, name, position, license);
        }

        allCrew.add(newCrew);

        System.out.println("YOU HAVE SUCCESSFULLY CREATED " +
                newCrew.getPosition() + " - " +
                newCrew.getName() + "\n");


        return newCrew;
    }

    @Override
    public String assignCrew(Integer staffNumber, String flightNumber) {
        Flight f = getFlightByNumber(flightNumber);
        Crew c = getCrewByStaffNumber(staffNumber);
        c.setAssignedFlight(f);
        f.getCrew().add(c);

        return c.getName() +" HAS BEEN ASSIGNED TO EE"+ flightNumber;
    }

}
