package com.assignment.app.source;

import java.io.Serializable;

public class Formula1DriverObj implements Serializable {

    private String name;
    private String location;
    private String team;
    private Integer noOfFirstPositions;
    private Integer noOfSecondPositions;
    private Integer noOfThirdPositions;
    private Integer points;
    private Integer noOfRaceParticipated;


    public Formula1DriverObj(String name, String location, String team, Integer noOfFirstPositions,
                             Integer noOfSecondPositions, Integer noOfThirdPositions,
                             Integer points, Integer noOfRaceParticipated) {
        this.name = name;
        this.location = location;
        this.team = team;
        this.noOfFirstPositions = noOfFirstPositions;
        this.noOfSecondPositions = noOfSecondPositions;
        this.noOfThirdPositions = noOfThirdPositions;
        this.points = points;
        this.noOfRaceParticipated = noOfRaceParticipated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getNoOfFirstPositions() {
        return noOfFirstPositions;
    }

    public void setNoOfFirstPositions(Integer noOfFirstPositions) {
        this.noOfFirstPositions = noOfFirstPositions;
    }

    public Integer getNoOfSecondPositions() {
        return noOfSecondPositions;
    }

    public void setNoOfSecondPositions(Integer noOfSecondPositions) {
        this.noOfSecondPositions = noOfSecondPositions;
    }

    public Integer getNoOfThirdPositions() {
        return noOfThirdPositions;
    }

    public void setNoOfThirdPositions(Integer noOfThirdPositions) {
        this.noOfThirdPositions = noOfThirdPositions;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getNoOfRaceParticipated() {
        return noOfRaceParticipated;
    }

    public void setNoOfRaceParticipated(Integer noOfRaceParticipated) {
        this.noOfRaceParticipated = noOfRaceParticipated;
    }
}
