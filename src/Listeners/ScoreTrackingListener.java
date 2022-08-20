package Listeners;

import Basic.Counter;
import Basic.HitListener;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;

/**
 * The type Score tracking listener.
 *
 * @author Hadar Leiman
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}