package com.pcbuilder.main;

import com.pcbuilder.view.MainGUI;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });

    }
}