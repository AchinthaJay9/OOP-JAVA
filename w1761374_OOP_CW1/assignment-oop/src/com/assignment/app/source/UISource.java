package com.assignment.app.source;


import java.util.*;

public class UISource {


    public Object[][] showTable() {

        List<Formula1Driver> driverList = new ArrayList<>();

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        driverList = formula1ChampionshipManager.displayAllDrivers();

        Collections.sort(driverList, Comparator.comparingInt(Formula1Driver::getPoints).reversed());

        Object[][] data = new Object[driverList.size()][7];

        for (int x = 0; x < driverList.size(); x++) {
// created a loop to get data from driver list
            data[x][0] = driverList.get(x).getName();
            data[x][1] = driverList.get(x).getTeam();
            data[x][2] = driverList.get(x).getLocation();
            data[x][3] = driverList.get(x).getNoOfFirstPositions();
            data[x][4] = driverList.get(x).getNoOfSecondPositions();
            data[x][5] = driverList.get(x).getPoints();
            data[x][6] = driverList.get(x).getNoOfRaceParticipated();
        }

        return data;

    }

    public Object[][] showTableWithAscendingOrderByPoints() {

        List<Formula1Driver> driverList = new ArrayList<>();

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        driverList = formula1ChampionshipManager.displayAllDrivers();

        Collections.sort(driverList, Comparator.comparingInt(Formula1Driver::getPoints));

        Object[][] data = new Object[driverList.size()][7];

        for (int x = 0; x < driverList.size(); x++) {

            data[x][0] = driverList.get(x).getName();
            data[x][1] = driverList.get(x).getTeam();
            data[x][2] = driverList.get(x).getLocation();
            data[x][3] = driverList.get(x).getNoOfFirstPositions();
            data[x][4] = driverList.get(x).getNoOfSecondPositions();
            data[x][5] = driverList.get(x).getPoints();
            data[x][6] = driverList.get(x).getNoOfRaceParticipated();
        }

        return data;
    }

    public Object[][] showTableWithDescendingOrderByPosition() {

        List<Formula1Driver> driverList = new ArrayList<>();

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        driverList = formula1ChampionshipManager.displayAllDrivers();

        Collections.sort(driverList, Comparator.comparingInt(Formula1Driver::getNoOfFirstPositions).reversed());

        Object[][] data = new Object[driverList.size()][7];

        for (int x = 0; x < driverList.size(); x++) {

            data[x][0] = driverList.get(x).getName();
            data[x][1] = driverList.get(x).getTeam();
            data[x][2] = driverList.get(x).getLocation();
            data[x][3] = driverList.get(x).getNoOfFirstPositions();
            data[x][4] = driverList.get(x).getNoOfSecondPositions();
            data[x][5] = driverList.get(x).getPoints();
            data[x][6] = driverList.get(x).getNoOfRaceParticipated();
        }

        return data;

    }

    public Object[][] showRacesInfo() {

        List<Race> raceInfo = new ArrayList<>();

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        raceInfo = formula1ChampionshipManager.displayAllRaces();

        Collections.sort(raceInfo, Comparator.comparing(Race::getDate).reversed());

        Object[][] data = new Object[raceInfo.size()][6];

        for (int x = 0; x < raceInfo.size(); x++) {

            String first = "";
            String second = "";
            String third = "";
            String fourth = "";
            String fifth = "";

            for (Positions val : raceInfo.get(x).getPositionsList()){

                if (val.getPosition() == 1)
                    first = val.getName();
                if (val.getPosition() == 2)
                    second = val.getName();
                if (val.getPosition() == 3)
                    third = val.getName();
                if (val.getPosition() == 4)
                    fourth = val.getName();
                if (val.getPosition() == 5)
                    fifth = val.getName();

            }

            data[x][0] = raceInfo.get(x).getDate();
            data[x][1] = first;
            data[x][2] = second;
            data[x][3] = third;
            data[x][4] = fourth;
            data[x][5] = fifth;
        }

        return data;

    }


    public Object[][] showRacesInfoForSelectedDriver(String driver) {

        List<Race> list = PerformFunctions.races;

        HashMap<String, Integer> objList = new HashMap<>();

        for (Race obj : list){

            for (Positions position : obj.getPositionsList()){

                if (position.getName().equalsIgnoreCase(driver)){
                    objList.put(obj.getDate().toString(), position.getPosition());
                }
            }
        }

        Object[][] data = new Object[objList.size()][2];

        int x = 0;

        for (String val : objList.keySet()){

            data[x][0] = val;
            data[x][1] = objList.get(val);

            x++;

        }
        return data;
    }

    public Object[][] showTableForRace() {

        Object[][] data = new Object[0][3];

        return data;

    }

    public String[] getColumn() {

//adding topics for the gui table
        String[] columnNames = {"Name", "Team", "Location", "Fist Positions",
                "Second Positions", "Points", "No Of Races"};

        return columnNames;

    }

    public String[] getColumnForRace() {


        String[] columnNames = {"Driver", "Position", "Points"};

        return columnNames;

    }

    public String[] getColumnForRaceInfo() {


        String[] columnNames = {"Date", "1", "2", "3", "4", "5"};

        return columnNames;

    }

    public String[] getColumnForDriverRace() {


        String[] columnNames = {"Date", "Position"};

        return columnNames;

    }

    public Object[][] addRace() {
// when pressing add race will clear all races and rewrite as saves driver detiels
        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        List<Formula1Driver> driverList = formula1ChampionshipManager.displayAllDrivers();

        Collections.shuffle(driverList);

        Object[][] data = new Object[driverList.size()][3];

        List<Integer> position = new ArrayList<>();

        Race race = new Race();
        List<Positions> positionsList = new ArrayList<>();

        for (int x = 0; x < driverList.size(); x++) {


            Boolean state = true;

            Integer answer = 0;


            while (state) {

                Random rn = new Random();
                answer = rn.nextInt(driverList.size()) + 1;
//                System.out.println(answer);
                if (!position.contains(answer)) {
                    position.add(answer);
                    state = false;
                }
            }

            Positions positions = new Positions(driverList.get(x).getName(), answer, getPoints(answer));

            positionsList.add(positions);

            data[x][0] = driverList.get(x).getName();
            data[x][1] = answer;
            data[x][2] = getPoints(answer);
            updateDriverStat(driverList.get(x).getName(),getPoints(answer),answer);

        }

        race.setDate(new Date());
        race.setPositionsList(positionsList);

        PerformFunctions.races.add(race);

        return data;

    }

    public Integer getPoints(Integer position) {

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

    public void updateDriverStat(String name, Integer points, Integer position){

        for (int x = 0; x < PerformFunctions.drives.size(); x++){

            if (PerformFunctions.drives.get(x).getName().equalsIgnoreCase(name)){

                if (position == 1) {
                    int tempFirst = PerformFunctions.drives.get(x).getNoOfFirstPositions();
                    PerformFunctions.drives.get(x).setNoOfFirstPositions(tempFirst + 1);
                }else if (position == 2) {
                    int tempSecond = PerformFunctions.drives.get(x).getNoOfSecondPositions();
                    PerformFunctions.drives.get(x).setNoOfSecondPositions(tempSecond+1);
                }else if (position == 3) {
                    int tempThird = PerformFunctions.drives.get(x).getNoOfThirdPositions();
                    PerformFunctions.drives.get(x).setNoOfThirdPositions(tempThird + 1);
                }
                int tempPoints = PerformFunctions.drives.get(x).getPoints();
                PerformFunctions.drives.get(x).setPoints(tempPoints + points);
                int tempRace = PerformFunctions.drives.get(x).getNoOfRaceParticipated();
                PerformFunctions.drives.get(x).setNoOfRaceParticipated(tempRace + 1);

            }
        }
    }

    public Object[][] addRaceWithProbability() {

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        List<Formula1Driver> driverList = formula1ChampionshipManager.displayAllDrivers();

        Collections.shuffle(driverList);

        Object[][] data = new Object[driverList.size()][3];

        List<Integer> position = new ArrayList<>();

        Race race = new Race();
        List<Positions> positionsList = new ArrayList<>();

        for (int x = 0; x < driverList.size(); x++) {

            Boolean state = true;

            Integer answer = 0;

            while (state) {

                Random rn = new Random();
                int val = rn.nextInt(100);

                if (val < 2) {
                    answer = rn.nextInt(6) + 5;
                }
                else if (val < 20) {
                    answer = rn.nextInt(2) + 3;
                }
                else if (val < 50) {
                    answer = 2;
                }
                else {
                    answer = 1;
                }

                if (!position.contains(answer) && answer <= driverList.size()) {
                    position.add(answer);
                    state = false;
                }
            }

            Positions positions = new Positions(driverList.get(x).getName(), answer, getPoints(answer));

            positionsList.add(positions);

            data[x][0] = driverList.get(x).getName();
            data[x][1] = answer;
            data[x][2] = getPoints(answer);
            updateDriverStat(driverList.get(x).getName(),getPoints(answer),answer);

        }

        race.setDate(new Date());
        race.setPositionsList(positionsList);

        PerformFunctions.races.add(race);

        return data;

    }
}
