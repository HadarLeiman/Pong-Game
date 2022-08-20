package Animation;

import Basic.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.*;

// The Animation.CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private Double numOfSeconds;
    private Integer countFrom;
    private SpriteCollection gameScreen;
    private String levelName;

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, String levelName) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.levelName=levelName;
    }
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(552, 23, "Level Name: "+this.levelName, 20);
        d.setColor(Color.BLACK);
        d.drawText(370,380,countFrom.toString(),100);
        this.countFrom--;
    }
    public boolean shouldStop() {
        if (this.countFrom==0){
            return true;
        }
        return false;
    }
}