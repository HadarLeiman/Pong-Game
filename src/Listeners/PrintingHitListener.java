package Listeners;

import Basic.HitListener;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;

/**
 * The type Printing hit listener.
 *
 * @author Hadar Leiman.
 */
public class PrintingHitListener implements HitListener {

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Game.GameObjects.Block was hit.");
    }
}
