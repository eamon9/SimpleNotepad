package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    Function_File file = new Function_File(this);

    public static void main(String[] args) {

        new GUI();
    }

    public GUI() {

        createWindow();
        crateTextArea();
        crateMenyBar();
        createFileMenu();

        window.setVisible(true);
    }

    public void createWindow() {

        window = new JFrame("NOTEPAD");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void crateTextArea() {

        textArea = new JTextArea();

        scrollPane = new JScrollPane(
                textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    public void crateMenyBar() {

        menuBar = new JMenuBar();

        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");
        menuColor = new JMenu("Color");

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFormat);
        menuBar.add(menuColor);

    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iOpen = new JMenuItem("Open");
        iSave = new JMenuItem("Save");
        iSaveAs = new JMenuItem("Save As");
        iExit = new JMenuItem("Exit");

        menuFile.add(iNew);
        menuFile.add(iOpen);
        menuFile.add(iSave);
        menuFile.add(iSaveAs);
        menuFile.add(iExit);

        iNew.addActionListener(this);
        iOpen.addActionListener(this);
        iSave.addActionListener(this);
        iSaveAs.addActionListener(this);
        iExit.addActionListener(this);

        iNew.setActionCommand("New");
        iOpen.setActionCommand("Open");
        iSave.setActionCommand("Save");
        iSaveAs.setActionCommand("SaveAs");
        iExit.setActionCommand("Exit");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.openFile();
                break;
            case "SaveAs":
                file.saveAsFile();
                break;
            case "Save":
                file.saveFile();
                break;
        }
    }
}
