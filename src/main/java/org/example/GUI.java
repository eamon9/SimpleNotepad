package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    // TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // FILE MENU
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    // FORMAT MENU
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR,
            iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;
    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);

    public static void main(String[] args) {

        new GUI();
    }

    public GUI() {

        createWindow();
        createTextArea();
        createMenyBar();
        createFileMenu();
        createFormatMenu();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();

        window.setVisible(true);
    }

    public void createWindow() {

        window = new JFrame("NOTEPAD");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {

        textArea = new JTextArea();

        scrollPane = new JScrollPane(
                textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
    }

    public void createMenyBar() {

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

    public void createFormatMenu() {

        iWrap = new JMenuItem("World wrap: Off");
        iFontArial = new JMenuItem("Arial");
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontTNR = new JMenuItem("Times New Roman");
        iFontSize8 = new JMenuItem("8");
        iFontSize12 = new JMenuItem("12");
        iFontSize16 = new JMenuItem("16");
        iFontSize20 = new JMenuItem("20");
        iFontSize24 = new JMenuItem("24");
        iFontSize28 = new JMenuItem("28");

        menuFont = new JMenu("Font");
        menuFontSize = new JMenu("Font Size");

        iWrap.addActionListener(this);
        iFontArial.addActionListener(this);
        iFontCSMS.addActionListener(this);
        iFontTNR.addActionListener(this);
        iFontSize8.addActionListener(this);
        iFontSize12.addActionListener(this);
        iFontSize16.addActionListener(this);
        iFontSize20.addActionListener(this);
        iFontSize24.addActionListener(this);
        iFontSize28.addActionListener(this);

        iWrap.setActionCommand("Word Wrap");
        iFontArial.setActionCommand("Arial");
        iFontCSMS.setActionCommand("Comic Sans MS");
        iFontTNR.setActionCommand("Times New Roman");
        iFontSize8.setActionCommand("size8");
        iFontSize12.setActionCommand("size12");
        iFontSize16.setActionCommand("size16");
        iFontSize20.setActionCommand("size20");
        iFontSize24.setActionCommand("size24");
        iFontSize28.setActionCommand("size28");

        menuFont.add(iFontArial);
        menuFont.add(iFontCSMS);
        menuFont.add(iFontTNR);
        menuFontSize.add(iFontSize8);
        menuFontSize.add(iFontSize12);
        menuFontSize.add(iFontSize16);
        menuFontSize.add(iFontSize20);
        menuFontSize.add(iFontSize24);
        menuFontSize.add(iFontSize28);

        menuFormat.add(iWrap);
        menuFormat.add(menuFont);
        menuFormat.add(menuFontSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "New" -> file.newFile();
            case "Open" -> file.openFile();
            case "SaveAs" -> file.saveAsFile();
            case "Save" -> file.saveFile();
            case "Exit" -> file.exit();
            case "Word Wrap" -> format.wordWrap();
            case "Arial" -> format.setFont(command);
            case "Comic Sans MS" -> format.setFont(command);
            case "Times New Roman" -> format.setFont(command);
            case "size8" -> format.createFont(8);
            case "size12" -> format.createFont(12);
            case "size16" -> format.createFont(16);
            case "size20" -> format.createFont(20);
            case "size24" -> format.createFont(24);
            case "size28" -> format.createFont(28);
        }
    }
}
