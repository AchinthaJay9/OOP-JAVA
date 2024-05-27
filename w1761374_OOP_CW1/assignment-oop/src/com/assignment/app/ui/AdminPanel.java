package com.assignment.app.ui;

import com.assignment.app.source.PerformFunctions;

public class AdminPanel {

    public static void main(String[] args) {

        PerformFunctions performFunctions = new PerformFunctions();

        PerformFunctions.drives = performFunctions.readDrives();

        PerformFunctions.races = performFunctions.readRace();

        MainUI mm = new MainUI("Formula1 - Admin Panel");
        mm.setVisible(true);
    }

}
