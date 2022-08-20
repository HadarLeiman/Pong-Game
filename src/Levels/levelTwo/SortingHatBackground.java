package Levels.levelTwo;

import Basic.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

public class SortingHatBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(213,0, 0));
        d.fillRectangle(0,0,400,300);
        d.setColor(new Color(0,128, 0));
        d.fillRectangle(400,0,400,300);
        d.setColor(new Color(249,249, 0));
        d.fillRectangle(0,300,400,300);
        d.setColor(new Color(0,128, 192));
        d.fillRectangle(400,300,400,300);
    }

    @Override
    public void timePassed() {

    }
}
