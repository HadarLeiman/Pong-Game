package Levels.levelOne;

import Basic.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

public class AvadaKedavraBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0,147, 0));
        d.fillRectangle(0,0,800,600);
        d.setColor(new Color(0, 125, 0));
        d.fillCircle(400,210,330);
        d.setColor(new Color(0, 117, 0));
        d.fillCircle(400,210,240);
        d.setColor(new Color(0, 100, 0));
        d.fillCircle(400,210,180);
        d.setColor(new Color(0, 85, 0));
        d.fillCircle(400,210,130);
        d.setColor(new Color(0, 68, 0));
        d.fillCircle(400,210,90);
        d.setColor(new Color(0, 39, 0));
        d.fillCircle(400,210,60);
        d.setColor(new Color(0, 16, 0));
        d.fillCircle(400,210,40);
    }

    @Override
    public void timePassed() {

    }
}
