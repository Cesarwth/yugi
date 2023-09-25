package com.yugi.gui;

import javax.swing.*;

public class YugiApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                YugiGUI gui = new YugiGUI();
                gui.setVisible(true);
            }
        });
    }
}