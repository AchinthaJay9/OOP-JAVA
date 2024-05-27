package com.assignment.app.source;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Race implements Serializable {

    private Date date;
    private List<Positions> positionsList;

    public Race() {
    }

    public Race(Date date, List<Positions> positionsList) {
        this.date = date;
        this.positionsList = positionsList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Positions> getPositionsList() {
        return positionsList;
    }

    public void setPositionsList(List<Positions> positionsList) {
        this.positionsList = positionsList;
    }

}
