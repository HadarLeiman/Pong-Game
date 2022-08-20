package Animation;

import Animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation){
        this.sensor=sensor;
        this.key=key;
        this.animation=animation;
        this.isAlreadyPressed = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        if (key == " "){
            if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) { return true; }
        }
        return false;
    }
}