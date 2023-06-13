package com.bamlakKangjinQuan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JFrame frame;
    private JButton buttonA;
    private JButton buttonB;
    private Tetris game;
    //********************************************************************************************************************//
    public Menu() {
        frame = new JFrame("Menu");
        buttonA = new JButton("Start Application");
        buttonB = new JButton("Close Application");

        // Set the action listener for buttonA
        buttonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startApplication();
            }
        });

        // Set the action listener for buttonB
        buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeApplication();
            }
        });
        //********************************************************************************************************************//

        // Add buttons to the frame
        frame.getContentPane().setLayout(new java.awt.FlowLayout());
        frame.getContentPane().add(buttonA);
        frame.getContentPane().add(buttonB);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    //********************************************************************************************************************//
    public void startApplication() {
        // Add your code here to start the application
        EventQueue.invokeLater(() -> {
            game = new Tetris();
            game.setVisible(true);
        });
    }
    //********************************************************************************************************************//
    private void closeApplication() {
        // Add your code here to close the application
        game.setVisible(false);

    }
    //********************************************************************************************************************//
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
    //********************************************************************************************************************//

}
