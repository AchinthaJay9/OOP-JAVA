package com.assignment.app.source;

import java.util.List;

public interface ChampionshipManager {

    void createNewDriver(String name,
                         String location,
                         String team);

    void deleteDriver(String driver);

    void changeTheDriver(String name, String team);

    Formula1Driver displayStatistics(String driver);

    void showTable();

    List<Formula1Driver> displayAllDrivers();

    List<Race> displayAllRaces();

}
