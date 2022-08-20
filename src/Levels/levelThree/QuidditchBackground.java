package Levels.levelThree;

import Basic.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

public class QuidditchBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(128,255, 255));
        d.fillRectangle(0,0,800,600);
        d.setColor(Color.lightGray);
        d.fillOval(500,100,120,200);
        d.fillOval(370,170,110,180);
        d.fillOval(630,170,110,180);
        d.fillRectangle(680,285,10,315);
        d.fillRectangle(420,285,10,315);
        d.fillRectangle(555,215,13,385);
        d.setColor(Color.black);
        d.drawOval(500,100,120,200);
        d.drawOval(370,170,110,180);
        d.drawOval(630,170,110,180);
        d.setColor(new Color(128,255, 255));
        d.fillOval(515,115,90,170);
        d.fillOval(385,190,80,140);
        d.fillOval(645,187,80,145);
        d.setColor(Color.black);
        d.drawOval(515,115,90,170);
        d.drawOval(385,190,80,140);
        d.drawOval(645,187,80,145);
        d.setColor(Color.white);
        d.fillCircle(110,130,35);
        d.fillCircle(70,155,40);
        d.setColor(new Color(238,238,238));
        d.fillCircle(112,165,30);
        d.fillCircle(140,135,30);
        d.setColor(new Color(230,230,230));
        d.fillCircle(162,162,30);
        d.setColor(new Color(242,242,0));
        d.fillRectangle(152,187,37,5);
        d.setColor(new Color(231,165,12));
        d.drawRectangle(152,187,37,5);
        d.setColor(new Color(242,242,0));
        d.fillCircle(171,190,10);
        d.setColor(new Color(231,165,12));
        d.drawCircle(171,190,10);
    }

    @Override
    public void timePassed() {

    }
}
