package org.example;

import javax.swing.*;

public class GUI {

    JFrame window;
    JTextArea textArea;

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
        window.add(textArea);
    }




}
