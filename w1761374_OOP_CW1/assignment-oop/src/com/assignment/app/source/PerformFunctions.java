package com.assignment.app.source;

import com.assignment.app.ui.MainUI;

import java.io.*;
import java.util.*;

public class PerformFunctions {
// creating public static to access the methods in this file without creating objects inside main
    public static List<Formula1Driver> drives;
    public static List<Race> races;
    public static MainUI mainUI;

    public static void main(String[] args) {

        PerformFunctions.drives = readDrives();
//saved data will be loaded here
        PerformFunctions.races = readRace();
// taking inputs
        Scanner myObj = new Scanner(System.in);

        Integer val = -1;

        while (true) {
//created a loop here
            System.out.println("Select the number :");
            System.out.println("1 - Add Driver");
            System.out.println("2 - Delete Driver");
            System.out.println("3 - Change Driver");
            System.out.println("4 - Display Stat");
            System.out.println("5 - Add Race");
            System.out.println("6 - Save Data");
            System.out.println("7 - Show Table");
            System.out.println("8 - Open GUI");

            val = myObj.nextInt();
            myObj.nextLine();

            if (val > 0 && val < 9) {

                Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

                switch (val) {

                    case 1:
                        String name = "";
                        String location = "";
                        String team = "";
                        System.out.print("Add Name :");
                        name = myObj.nextLine();
                        System.out.print("Add Location :");
                        location = myObj.nextLine();
                        System.out.print("Add Team :");
                        team = myObj.nextLine();
                        formula1ChampionshipManager.createNewDriver(name, location, team);
                        break;
                    case 2:
                        String name2 = "";
                        System.out.print("Add Name :");
                        name2 = myObj.nextLine();
                        formula1ChampionshipManager.deleteDriver(name2);
                        break;
                    case 3:
                        String name3 = "";
                        String team3 = "";
                        System.out.print("Enter Team Name :");
                        team3 = myObj.nextLine();
                        System.out.print("Enter Driver Name :");
                        name3 = myObj.nextLine();
                        formula1ChampionshipManager.changeTheDriver(name3, team3);
                        break;
                    case 4:
                        String name4 = "";
                        System.out.print("Name :");
                        name4 = myObj.nextLine();
                        formula1ChampionshipManager.displayStatistics(name4);
                        break;
                    case 5:
                        addRace();
                        System.out.println("Successfully Added The Race");
                        break;
                    case 6:

                        saveDrivers();
                        saveRaces();

                        if (mainUI != null) {
                            mainUI.setVisible(false);
                            PerformFunctions performFunctions2 = new PerformFunctions();

                            PerformFunctions.drives = performFunctions2.readDrives();

                            PerformFunctions.races = performFunctions2.readRace();

                            mainUI = new MainUI("Formula1 - Admin Panel");

                            mainUI.setVisible(true);
                        }

                        break;
                    case 7:

                            formula1ChampionshipManager.showTable();

                            break;

                        case 8:

                        PerformFunctions performFunctions = new PerformFunctions();

                        PerformFunctions.drives = performFunctions.readDrives();

                        PerformFunctions.races = performFunctions.readRace();

                        mainUI = new MainUI("Formula1 - Admin Panel");

                        mainUI.setVisible(true);
                        break;

                    default:

                        System.out.println("Wrong Input");

                }

            }

        }

    }

    public static ArrayList<Formula1Driver> readDrives() {
// Creating a text file for drivers from readDrives method
        FileInputStream readData = null;
        ArrayList<Formula1Driver> drives = new ArrayList();
        try {
            readData = new FileInputStream("drivers.txt");

            ObjectInputStream readStream = new ObjectInputStream(readData);
// Stream used in here is when closing and opening to load the driver data and created a object class- formula1driver class is casted here and assigend the data to that class
            ArrayList<Formula1DriverObj> savedData = (ArrayList<Formula1DriverObj>) readStream.readObject();

            for (Formula1DriverObj obj : savedData) {

                Formula1Driver formula1Driver = new Formula1Driver(obj.getName()
                        , obj.getLocation(), obj.getTeam(),
                        obj.getNoOfFirstPositions(), obj.getNoOfSecondPositions(),
                        obj.getNoOfThirdPositions(), obj.getPoints(),
                        obj.getNoOfRaceParticipated());

                drives.add(formula1Driver);
            }

            readStream.close();

        } catch (FileNotFoundException e) {

            System.out.println("Error In file");

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

        return drives;

    }


    public static ArrayList<Race> readRace() {

        FileInputStream readData = null;
        ArrayList races = new ArrayList();
        try {
            readData = new FileInputStream("races.txt");

            ObjectInputStream readStream = new ObjectInputStream(readData);

            races = (ArrayList<Race>) readStream.readObject();
            readStream.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

        return races;

    }

    public static void addRace() {
//giving positions to the drivers and adding to the race
        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        List<Formula1Driver> driverList = formula1ChampionshipManager.displayAllDrivers();

        Race race = new Race();
        List<Positions> positionsList = new ArrayList<>();

        List<Integer> position = new ArrayList<>();

        System.out.println("Date :" + new Date() + "\n");

        System.out.println("Position\tPoints\tName");
//driver is one by one looped to give random positions
        for (int x = 0; x < driverList.size(); x++) {

            Positions p1 = new Positions();

            Boolean state = true;

            Integer answer = 0;

            while (state) {

                Random rn = new Random();
                answer = rn.nextInt(driverList.size()) + 1;
                if (!position.contains(answer)) {
                    position.add(answer);
                    state = false;
                }
            }

            p1.setName(driverList.get(x).getName());
            p1.setPosition(answer);
            p1.setPoints(getPoints(answer));
//updating driver stats & passing points value
            updateDriverStat(driverList.get(x).getName(), getPoints(answer), answer);

            System.out.println(answer + "\t\t\t" + getPoints(answer) + "\t\t" + driverList.get(x).getName());

            positionsList.add(p1);
        }

        race.setDate(new Date());
        race.setPositionsList(positionsList);

        PerformFunctions.races.add(race);
    }
// created the flow of data of getting point in the race
    public static Integer getPoints(Integer position) {

        Integer num = 0;

        switch (position) {

            case 1:
                num = 25;
                break;
            case 2:
                num = 18;
                break;
            case 3:
                num = 15;
                break;
            case 4:
                num = 12;
                break;
            case 5:
                num = 10;
                break;
            case 6:
                num = 8;
                break;
            case 7:
                num = 6;
                break;
            case 8:
                num = 4;
                break;
            case 9:
                num = 2;
                break;
            case 10:
                num = 1;
                break;
            default:
                num = 0;

        }
        return num;
    }

    public static void updateDriverStat(String name, Integer points, Integer position) {

        Formula1Driver tempDriver = null;

        for (Formula1Driver driver : PerformFunctions.drives) {

            if (driver.getName().equalsIgnoreCase(name)) {

                tempDriver = driver;
            }
        }

        PerformFunctions.drives.remove(tempDriver);
//add Stats one by one creating a loop adding +1
        if (tempDriver != null) {
            if (position == 1)
                tempDriver.setNoOfFirstPositions(tempDriver.getNoOfFirstPositions() + 1);
            else if (position == 2)
                tempDriver.setNoOfSecondPositions(tempDriver.getNoOfSecondPositions() + 1);
            else if (position == 3)
                tempDriver.setNoOfThirdPositions(tempDriver.getNoOfThirdPositions() + 1);

// continuing the process of add +1 & to get ponts here getpoints class is created
            tempDriver.setPoints(tempDriver.getPoints() + points);
            tempDriver.setNoOfRaceParticipated(tempDriver.getNoOfRaceParticipated() + 1);
            PerformFunctions.drives.add(tempDriver);
        }

    }

    public static void saveDrivers() {
//creating drivers.txt file and saving
        try {
            FileOutputStream writeData = new FileOutputStream("drivers.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            List<Formula1DriverObj> objList = new ArrayList<>();

            for (Formula1Driver obj : PerformFunctions.drives) {

                Formula1DriverObj formula1DriverObj = new Formula1DriverObj(obj.getName(),
                        obj.getLocation(), obj.getTeam(),
                        obj.getNoOfFirstPositions(),
                        obj.getNoOfSecondPositions(),
                        obj.getNoOfThirdPositions(), obj.getPoints(),
                        obj.getNoOfRaceParticipated());

                objList.add(formula1DriverObj);

            }

            writeStream.writeObject(objList);
            writeStream.flush();
            writeStream.close();

            System.out.println("Successfully Saved The Drivers");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRaces() {
// creating race txt file and saving
        try {
            FileOutputStream writeData = new FileOutputStream("races.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(PerformFunctions.races);
            writeStream.flush();
            writeStream.close();

            System.out.println("Successfully Saved The Races");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
