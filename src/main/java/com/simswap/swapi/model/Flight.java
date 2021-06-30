package com.simswap.swapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDate;
import java.util.*;


public class Flight {

	private String flightNumber;
	private String destination;
	@JsonIgnore
	private List<Crew> crew;
	private LocalDate flightDate;

	public Flight() {

	}


	public Flight(String flightNumber, String destination, LocalDate flightDate) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.flightDate = flightDate;
		this.crew = new ArrayList<>();
	}

	public void addFullCrew(Crew captain, Crew fo, Crew sc, Crew cc) {

		crew.add(captain);
		crew.add(fo);
		crew.add(sc);
		crew.add(cc);

		captain.setAssignedFlight(this);
		fo.setAssignedFlight(this);
		sc.setAssignedFlight(this);
		cc.setAssignedFlight(this);

		System.out.printf("All the crew has been added. The flight %s is complete.%n", this.flightNumber);

	}


	public void replaceCrew(Crew crewToBeAdded, Crew crewToBeRemoved){
		int index = crew.indexOf(crewToBeRemoved);
		crew.set(index, crewToBeAdded);

	}

	public String toString(){
		return "EE" + this.flightNumber + " - DXB/" + this.destination
					+ " DATE: " + flightDate.toString();
	}


	public List<Crew> getCrew() {
		return crew;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDestination() {
		return destination;
	}

}
