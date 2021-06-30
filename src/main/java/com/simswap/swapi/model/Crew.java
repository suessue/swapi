package com.simswap.swapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Crew {

    private Integer staffNumber;
    private String name;
    @JsonIgnore
    private Flight assignedFlight;
    private Position position;
    private Integer license;

    public Crew() {
    }

    public Crew(Integer staffNumber, String name, Position position) {
        this.staffNumber = staffNumber;
        this.name = name;
        this.position = position;
    }

    public String toString() {
        return String.format("%1$3s, STAFF#: %2$5d, NAME: %3$s", this.position, staffNumber, name);

    }

    public Integer getLicense() {
        return license;
    }

	public void setLicense(Integer license) {
        this.license = license;
    }


    public String getPosition() {
        return position.toString();
    }

	public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(Integer staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight getAssignedFlight() {
        return assignedFlight;
    }

    public void setAssignedFlight(Flight assignedFlight) {
        this.assignedFlight = assignedFlight;
    }


}
