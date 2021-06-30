package com.simswap.swapi.model;

public class FlightCrew extends Crew{

	private Integer pilotLicense;

	public FlightCrew(Integer staffNumber, String name, Position position) {
		super(staffNumber, name, position);
	}

	public FlightCrew(Integer staffNumber, String name, Position position,Integer pilotLicense) {
		super(staffNumber, name, position);
		this.pilotLicense = pilotLicense;
	}

    @Override
	public Integer getLicense() {
		return pilotLicense;
	}

	@Override
	public void setLicense(Integer license){
		this.pilotLicense = license;
	}

	
}
