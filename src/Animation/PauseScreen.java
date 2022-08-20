package Animation;

import biuoop.DrawSurface;

import java.awt.*;

public class PauseScreen implements Animation {
    /*private KeyboardSensor keyboard;
    private boolean stop;

    public Animation.PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }*/
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.PINK);
        d.fillRectangle(0,0,d.getWidth(),d.getWidth());
        d.setColor(Color.BLACK);
        d.drawText(240,200,"Stupefy!",100);
        d.drawText(240, d.getHeight() / 2, "press space to continue", 32);
       // if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }
    @Override
    public boolean shouldStop() { return false; }
}