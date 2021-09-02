package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    private Image dvd_logo;
    private Timer t;
    private int x = 0, y = 0;
    private int xV = 1;
    private int yV = 1;
    private Point p = new Point(x, y);

    public Contents(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("game/DVD_logo_small.png"));
        dvd_logo = ii.getImage();

        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.setBackground(Color.BLACK);
        super.paintComponent(g);


        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(dvd_logo, x, y, this);
    }

    public void move(){
        x += xV;
        y += yV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();

        if(x <= 0)
            xV = 1;
        else if(x >= 885 - 100)
            xV = -1;

        if(y <= 0)
            yV = 1;
        else if(y >= 560 - 52)
            yV = -1;

        repaint();
    }
}
