package Animation;

import biuoop.DrawSurface;
import biuoop.GUI;

public class AnimationRunner {
    private GUI gui;
    private double framesPerSecond;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();

    public AnimationRunner(GUI gui, double framesPerSecond){
        this.gui= gui;
        this.framesPerSecond = framesPerSecond;
    }

    public void setFramesPerSecond(int framesPerSecond){
        this.framesPerSecond = framesPerSecond;
    }

    public void run(Animation animation) {
        double millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = (long)millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}