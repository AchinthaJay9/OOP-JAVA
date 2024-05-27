package com.assignment.app.source;

import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {


    private Integer noOfFirstPositions;
    private Integer noOfSecondPositions;
    private Integer noOfThirdPositions;
    private Integer points;
    private Integer noOfRaceParticipated;

    public Formula1Driver(String name, String location, String team) {
        super(name, location, team);
    }

    public Formula1Driver(String name, String location, String team,
                          Integer noOfFirstPositions, Integer noOfSecondPositions,
                          Integer noOfThirdPositions, Integer points, Integer noOfRaceParticipated) {
        super(name, location, team);
        this.noOfFirstPositions = noOfFirstPositions;
        this.noOfSecondPositions = noOfSecondPositions;
        this.noOfThirdPositions = noOfThirdPositions;
        this.points = points;
        this.noOfRaceParticipated = noOfRaceParticipated;
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
