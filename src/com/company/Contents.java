package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    private Image penguin;
    private int x = 100, y = 100;
    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        ImageIcon ii = new ImageIcon(this.getClass().getResource("game/penguin.jpeg"));
        penguin = ii.getImage();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(penguin, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++x;
        ++y;
        repaint();
    }
}
