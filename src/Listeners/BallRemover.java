package Listeners;

import Basic.Counter;
import Basic.HitListener;
import Game.GameLevel;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;

/**
 * The type Game.GameObjects.Ball remover.
 *
 * @author Hadar Leiman
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new Game.GameObjects.Ball remover.
     *
     * @param gameLevel           the game
     * @param remainingBalls the removed balls
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    //balls that hit should be remove from the game
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        remainingBalls.decrease(1);
        hitter.removeHitListener(this);
    }
}
