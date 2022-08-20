package Listeners;

import Basic.Counter;
import Basic.HitListener;
import Game.GameLevel;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;

/**
 * @author Hadar Leiman
 * <p>
 * a Listeners.BlockRemover is in charge of removing blocks from the game.
 * as well as keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Game.GameObjects.Block remover.
     *
     * @param gameLevel          the game
     * @param removedBlocks the removed blocks counter
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit should be removed from the game
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
    }
}