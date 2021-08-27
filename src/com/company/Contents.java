package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Contents extends JPanel implements ActionListener {

    private Image dvd_logo;
    private int width;
    private int height;
    private Timer t;
    private int x = 0, y = 0;
    private int xV = 1;
    private int yV = 1;

    public Contents(){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("game/DVD_logo_small.png"));
        dvd_logo = ii.getImage();
        getImageSize(dvd_logo);
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

    private void getImageSize(Image image){
        try {
            BufferedImage bimg = ImageIO.read(new File("game/DVD_logo_small.png"));
            width = bimg.getWidth();
            height = bimg.getHeight();
            System.out.println(width);
            System.out.println(height);
        }
        catch(IOException ignored){
        }
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
