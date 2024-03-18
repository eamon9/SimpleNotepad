package org.example;

import javax.swing.*;

public class GUI {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;

    public static void main(String[] args) {

        new GUI();
    }

    public GUI() {
        createWindow();
        crateTextArea();

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("NOTEPAD");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void crateTextArea() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(
                textArea, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        window.add(scrollPane);
    }




}
