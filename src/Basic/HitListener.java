package Basic;

import Game.GameObjects.Ball;
import Game.GameObjects.Block;

/**
 * The interface Hit listener.
 *
 * @author Hadar Leiman.
 */
public interface HitListener {
    /**
     * Hit event.
     *
     * @param beingHit the object that being hit
     * @param hitter   the Game.GameObjects.Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}
