package com.assignment.app.ui;

import com.assignment.app.source.Formula1Driver;
import com.assignment.app.source.Formula1DriverObj;
import com.assignment.app.source.PerformFunctions;
import com.assignment.app.source.UISource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainUI extends Frame implements WindowListener {
    JTable table;
    JTable table2;
    JTable table3;
    JTable table4;
    JScrollPane scrollPane2;
    JScrollPane scrollPane;
    JScrollPane scrollPane3;
    JScrollPane scrollPane4;
    GridBagConstraints gcon;
    Button sort1;
    Button sort2;
    Button btn7;
    Button btn10;
    Button btn8;
    JComboBox c1;
    GridBagLayout gbl;
    public MainUI(String FrameTitle) {
        //Display the Frame Window
        super(FrameTitle);
        setSize(5000, 5000);
        setLocation(600, 100);
        addWindowListener(this);


        UISource label1 = new UISource();
        UISource label2 = new UISource();

        addTables(label1, label2);

        addButtons();

        String[] drivesList = getDriverList();

        c1 = new JComboBox(drivesList);

        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UISource dd = new UISource();
                remove(scrollPane2);
                remove(scrollPane);
                table2 = new JTable(dd.addRace(), label2.getColumnForRace());
                table2.setPreferredScrollableViewportSize(new Dimension(100,100));

                table = new JTable(label1.showTable(), label1.getColumn());
                table.setPreferredScrollableViewportSize(new Dimension(100,100));

                scrollPane2 = new JScrollPane(table2);
                gcon.gridx = 3;
                gcon.gridy = 2;
                gcon.gridwidth = 2;
                gcon.gridheight = 2;
                gbl.setConstraints(scrollPane2, gcon);
                add(scrollPane2);

                scrollPane = new JScrollPane(table);
                gcon.gridy = 0;
                gcon.gridx = 0;
                gcon.gridwidth = 5;
                gcon.gridheight = 1;
                gbl.setConstraints(scrollPane, gcon);
                add(scrollPane);

                revalidate();
                repaint();

                saveDrivers();
                saveRaces();
            }
        });

        btn10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UISource dd = new UISource();
                remove(scrollPane2);
                remove(scrollPane);
                table2 = new JTable(dd.addRaceWithProbability(), label2.getColumnForRace());
                table2.setPreferredScrollableViewportSize(new Dimension(100,100));

                table = new JTable(label1.showTable(), label1.getColumn());
                table.setPreferredScrollableViewportSize(new Dimension(100,100));

                scrollPane2 = new JScrollPane(table2);
                gcon.gridx = 3;
                gcon.gridy = 2;
                gcon.gridwidth = 2;
                gcon.gridheight = 2;
                gbl.setConstraints(scrollPane2, gcon);
                add(scrollPane2);

                scrollPane = new JScrollPane(table);
                gcon.gridy = 0;
                gcon.gridx = 0;
                gcon.gridwidth = 5;
                gcon.gridheight = 1;
                gbl.setConstraints(scrollPane, gcon);
                add(scrollPane);

                revalidate();
                repaint();

                saveDrivers();
                saveRaces();
            }
        });

        sort1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                remove(scrollPane);

                table = new JTable(label1.showTableWithAscendingOrderByPoints(), label1.getColumn());
                table.setPreferredScrollableViewportSize(new Dimension(100,100));

                scrollPane = new JScrollPane(table);
                gcon.gridy = 0;
                gcon.gridx = 0;
                gcon.gridwidth = 5;
                gcon.gridheight = 1;
                gbl.setConstraints(scrollPane, gcon);
                add(scrollPane);

                revalidate();
                repaint();
            }
        });

        sort2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                remove(scrollPane);

                table = new JTable(label1.showTableWithDescendingOrderByPosition(), label1.getColumn());
                table.setPreferredScrollableViewportSize(new Dimension(100,100));

                scrollPane = new JScrollPane(table);
                gcon.gridy = 0;
                gcon.gridx = 0;
                gcon.gridwidth = 5;
                gcon.gridheight = 1;
                gbl.setConstraints(scrollPane, gcon);
                add(scrollPane);

                revalidate();
                repaint();
            }
        });

        btn8 = new Button("Show Races");
        gbl = new GridBagLayout();
        setLayout(gbl);

        btn8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                remove(scrollPane3);

                table3 = new JTable(label1.showRacesInfo(), label1.getColumnForRaceInfo());
                table3.setPreferredScrollableViewportSize(new Dimension(100,100));

                scrollPane3 = new JScrollPane(table3);
                gcon.gridx = 3;
                gcon.gridy = 4;
                gcon.gridwidth = 2;
                gcon.gridheight = 1;
                gbl.setConstraints(scrollPane3, gcon);
                add(scrollPane3);

                revalidate();
                repaint();
            }
        });

        c1.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                remove(scrollPane4);

                table4 = new JTable(label1.showRacesInfoForSelectedDriver(c1.getSelectedItem().toString()),
                        label1.getColumnForDriverRace());
                table4.setPreferredScrollableViewportSize(new Dimension(100,100));

                scrollPane4 = new JScrollPane(table4);
                gcon.gridx = 3;
                gcon.gridy = 5;
                gcon.gridwidth = 2;
                gcon.gridheight = 1;
                gbl.setConstraints(scrollPane4, gcon);
                add(scrollPane4);

                revalidate();
                repaint();

            }
        });
//diving all in to boxes and rediving to 2 boxes big box is divded into 6 rows, 2nd row divided into 2, 3rd row is dived into 2 and redivided the left side of the row into 2
        gcon = new GridBagConstraints();
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.fill = GridBagConstraints.BOTH;
// x and y use to rows and colums
        gcon.gridy = 0;
        gcon.gridx = 0;
        gcon.gridwidth = 5;
        gcon.gridheight = 1;

        gbl.setConstraints(scrollPane, gcon);
        add(scrollPane);

        gcon.gridy = 1;
        gcon.gridwidth = 1;

        gcon.gridx = 0;
        gbl.setConstraints(sort1, gcon);
        add(sort1);

        gcon.gridx = 4;
        gbl.setConstraints(sort2, gcon);
        add(sort2);

        gcon.gridx = 0;
        gcon.gridy = 2;
        gcon.gridwidth = 1;
        gbl.setConstraints(btn7, gcon);
        add(btn7);

        gcon.gridx = 0;
        gcon.gridy = 3;
        gcon.gridwidth = 1;
        gbl.setConstraints(btn10, gcon);
        add(btn10);

        gcon.gridx = 0;
        gcon.gridy = 4;
        gcon.gridwidth = 3;
        gbl.setConstraints(btn8, gcon);
        add(btn8);

        gcon.gridx = 0;
        gcon.gridy = 5;
        gcon.gridwidth = 1;
        gbl.setConstraints(c1, gcon);
        add(c1);

        gcon.gridx = 3;
        gcon.gridy = 2;
        gcon.gridwidth = 2;
        gcon.gridheight = 2;
        gbl.setConstraints(scrollPane2, gcon);
        add(scrollPane2);

        gcon.gridx = 3;
        gcon.gridy = 4;
        gcon.gridwidth = 2;
        gcon.gridheight = 1;
        gbl.setConstraints(scrollPane3, gcon);
        add(scrollPane3);

        gcon.gridx = 3;
        gcon.gridy = 5;
        gcon.gridwidth = 2;
        gcon.gridheight = 1;
        gbl.setConstraints(scrollPane4, gcon);
        add(scrollPane4);

    }

    private String[] getDriverList() {
        List<Formula1Driver> drives = PerformFunctions.drives;

        String drivesList[] = new String[drives.size()];

        for (int x = 0; x < drives.size(); x++){

            drivesList[x] = drives.get(x).getName();

        }
        return drivesList;
    }

    private void addButtons() {
        sort1 = new Button("Sort by Points in Ascending Order");
        sort2 = new Button("Sort By Position in Descending Order");

        btn7 = new Button("Add Race");
        btn10 = new Button("Add Race With Probability");
    }

    private void addTables(UISource label1, UISource label2) {
        table = new JTable(label1.showTable(), label1.getColumn());
        table.setPreferredScrollableViewportSize(new Dimension(100,100));
        scrollPane = new JScrollPane(table);
        table2 = new JTable(label2.showTableForRace(), label2.getColumnForRace());
        table2.setPreferredScrollableViewportSize(new Dimension(100,100));
        scrollPane2 = new JScrollPane(table2);
        table3 = new JTable(label2.showTableForRace(), label2.getColumnForRaceInfo());
        table3.setPreferredScrollableViewportSize(new Dimension(100,100));
        scrollPane3 = new JScrollPane(table3);
        table4 = new JTable(label2.showTableForRace(), label2.getColumnForDriverRace());
        table4.setPreferredScrollableViewportSize(new Dimension(100,100));
        scrollPane4 = new JScrollPane(table4);
    }

    public static void saveDrivers() {

        try {
            FileOutputStream writeData = new FileOutputStream("drivers.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            List<Formula1DriverObj> objList = new ArrayList<>();

            for (Formula1Driver obj : PerformFunctions.drives){

                Formula1DriverObj formula1DriverObj = new Formula1DriverObj(obj.getName(),
                        obj.getLocation(),obj.getTeam(),
                        obj.getNoOfFirstPositions(),
                        obj.getNoOfSecondPositions(),
                        obj.getNoOfThirdPositions(),obj.getPoints(),
                        obj.getNoOfRaceParticipated());

                objList.add(formula1DriverObj);

            }

            writeStream.writeObject(objList);
            writeStream.flush();
            writeStream.close();

//            System.out.println("Successfully Saved The Drivers");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRaces() {

        try {
            FileOutputStream writeData = new FileOutputStream("races.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(PerformFunctions.races);
            writeStream.flush();
            writeStream.close();

//            System.out.println("Successfully Saved The Races");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

}