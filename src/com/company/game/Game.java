package com.company.game;

import com.company.Contents;

import javax.swing.*;

public class Game extends JFrame {

    public Game(){
        super.setTitle("Game Demo");
        super.setSize(900, 600);
        super.setLocation(100, 100);
        super.setResizable(false);
        super.add(new Contents());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

    }
}
