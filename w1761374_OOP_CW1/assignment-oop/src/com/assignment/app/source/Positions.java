package com.assignment.app.source;

import java.io.Serializable;

public class Positions implements Serializable {

    private String name;
    private Integer position;
    private Integer points;

    public Positions() {
    }
//passing values to get staticsts
    public Positions(String name, Integer position, Integer points) {
        this.name = name;
        this.position = position;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
