package com.assignment.app.source;

import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {

    private Integer numberOfDrivers = 0;

    private Integer cars = 0;


    @Override
    public void createNewDriver(String name,
                                String location,
                                String team) {
//checking if i have taken that driver before
        Boolean state = true;

        for (Formula1Driver drive : PerformFunctions.drives) {

            if (drive.getName().equalsIgnoreCase(name)) {
                state = false;
                System.out.println("Drive Already Exists");
            }

        }
//creating new driver here
        if (state) {
            Formula1Driver formula1Driver = new Formula1Driver(name, location, team);
            formula1Driver.setNoOfFirstPositions(0);
            formula1Driver.setNoOfSecondPositions(0);
            formula1Driver.setNoOfThirdPositions(0);
            formula1Driver.setPoints(0);
            formula1Driver.setNoOfRaceParticipated(0);
            PerformFunctions.drives.add(formula1Driver);
            System.out.println("Successfully added the driver");
        }

    }

    @Override
    public void deleteDriver(String driver) {

        Boolean state = true;

        Formula1Driver tempDriver = null;
//checking the name is equal to the input name to delete driver
        for (Formula1Driver drive : PerformFunctions.drives) {

            if (drive.getName().equalsIgnoreCase(driver)) {
                tempDriver = drive;
                state = false;
                System.out.println("Successfully Deleted");
            }

        }
//cannot delete drictly cuz of the loop in here a temparaly a formula1driver is created

        if (state)
            System.out.println("Driver Not Found");
        else
            PerformFunctions.drives.remove(tempDriver);
    }

    @Override
    public void changeTheDriver(String name, String team) {

        boolean driveState = false;
        boolean teamState = false;
        Formula1Driver driver = null;
// checking if it equal name
        for (Formula1Driver drive : PerformFunctions.drives) {

            if (drive.getName().equalsIgnoreCase(name)) {
                driver = drive;
                driveState = true;
            }

            if (drive.getTeam().equalsIgnoreCase(team))
                teamState = true;
        }
// if name is not there  or arleady exists
        if (!driveState)
            System.out.println("Driver Not Available");
        else if (teamState)
            System.out.println("Already a driver is assigned to the team");
        else {
            PerformFunctions.drives.remove(driver);
            driver.setTeam(team);
            PerformFunctions.drives.add(driver);
            System.out.println("Success");           //if not can change the driver
        }

    }

    @Override
    public Formula1Driver displayStatistics(String driver) {
// showing statistics after inputing the name of a driver
        for (Formula1Driver drive : PerformFunctions.drives) {
//checking driver exists or not
            if (drive.getName().equalsIgnoreCase(driver)) {

                System.out.println("Name : " + drive.getName());
                System.out.println("Location : " + drive.getLocation());
                System.out.println("Team : " + drive.getTeam());
                System.out.println("noOfFirstPositions :" + drive.getNoOfFirstPositions());
                System.out.println("noOfSecondPositions :" + drive.getNoOfSecondPositions());
                System.out.println("noOfThirdPositions :" + drive.getNoOfThirdPositions());
                System.out.println("points :" + drive.getPoints());
                System.out.println("noOfRaceParticipated :" + drive.getNoOfRaceParticipated());

                return drive;

            }
        }
        return null;

    }

    @Override
    public void showTable() {
//showing all driver detials in a table each by each
        System.out.println("Drivers Statistics");
        System.out.println("----------------------------");

        int x  = 1;

        for (Formula1Driver drive : PerformFunctions.drives) {

            System.out.println("Driver No "+x+"");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Name : " + drive.getName());
            System.out.println("Location : " + drive.getLocation());
            System.out.println("Team : " + drive.getTeam());
            System.out.println("noOfFirstPositions :" + drive.getNoOfFirstPositions());
            System.out.println("noOfSecondPositions :" + drive.getNoOfSecondPositions());
            System.out.println("noOfThirdPositions :" + drive.getNoOfThirdPositions());
            System.out.println("points :" + drive.getPoints());
            System.out.println("noOfRaceParticipated :" + drive.getNoOfRaceParticipated());
            System.out.println("-----------------------------------------------------------");

            x++;

        }

        System.out.println("\n\n");
    }

    @Override
    public List<Formula1Driver> displayAllDrivers() {

        return PerformFunctions.drives;

    }

    @Override
    public List<Race> displayAllRaces() {

        return PerformFunctions.races;

    }


}
