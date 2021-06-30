package com.simswap.swapi.model;

public class CabinCrew extends Crew{

	private Integer sepLicense;

	public CabinCrew(Integer staffNumber, String name, Position position, Integer sepLicense) {
		super(staffNumber, name, position);
		this.sepLicense = sepLicense;
	}


	@Override
	public Integer getLicense(){
		return sepLicense;
	};

	@Override
	public void setLicense(Integer license){
		this.sepLicense = license;
	}

}
