package com.bamlakKangjinQuan;

import javax.swing.*;
import java.awt.*;


public class Tetris extends JFrame {
    private JLabel statusbar;
    private JLabel timerBar;
    //********************************************************************************************************************//
    public Tetris() {
        initUI();
    }
    //********************************************************************************************************************//
    public void initUI() {
        statusbar = new JLabel("Score: 0");
        timerBar = new JLabel("Time: 0, Timer does not work yet");
        add(statusbar, BorderLayout.SOUTH);
        add(timerBar, BorderLayout.NORTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    //********************************************************************************************************************//
    JLabel getStatusBar() {
        return statusbar;
    }
    //********************************************************************************************************************//
    JLabel getTimerBar(){
        return timerBar;
    }
    //********************************************************************************************************************//
}
