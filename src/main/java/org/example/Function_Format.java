package org.example;

import java.awt.Font;

public class Function_Format {

    GUI gui;
    Font arial, comicSansMs, timesNewRoman;
    String selectedFont;
    public Function_Format(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {

        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("World Wrap: On");
        } else if (gui.wordWrapOn == true) {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("World Wrap: Off");
        }
    }

    public void createFont(int fontSize) {

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMs = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {

        selectedFont = font;

        switch (selectedFont) {
            case "Arial" -> gui.textArea.setFont(arial);
            case "Comic Sans MS" -> gui.textArea.setFont(comicSansMs);
            case "Times New Roman" -> gui.textArea.setFont(timesNewRoman);
        }
    }
}
