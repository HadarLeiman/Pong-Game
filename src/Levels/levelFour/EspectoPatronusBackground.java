package Levels.levelFour;

import Basic.Sprite;
import biuoop.DrawSurface;
import java.util.Random;
import java.awt.Color;

public class EspectoPatronusBackground implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Random rand = new Random();

        d.setColor(new Color(0,0, 64));
        d.fillRectangle(0,0,800,600);

        d.setColor(Color.yellow);
        for (int i=0; i<2; i++){
            int x=rand.nextInt(800);
            int y=rand.nextInt(600);
            d.fillCircle(x,y,4);
            d.drawLine(x-8,y,x+8,y);
            d.drawLine(x,y-8,x,y+8);

        }

        d.setColor(Color.yellow);
        d.fillCircle(710,120,55);
        d.setColor(new Color(0,0, 64));
        d.fillCircle(680,125,45);


        d.setColor(new Color(152,148,88));
        d.fillCircle(610,130,35);
        d.fillCircle(570,155,40);
        d.setColor(new Color(120,116,69));
        d.fillCircle(612,165,30);
        d.fillCircle(640,135,30);
        d.setColor(new Color(101,98,58));
        d.fillCircle(662,162,30);
    }

    @Override
    public void timePassed() {

    }
}
