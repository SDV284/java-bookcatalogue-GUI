package com.bookcatalogueGUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookGUI gui = new BookGUI();
            gui.setVisible(true);
        });
    }
}