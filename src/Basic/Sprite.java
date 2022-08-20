package Basic;

import biuoop.DrawSurface;

/**
 * The interface Basic.Sprite.
 * @author Hadar Leiman 209170372
 */

public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the draw surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
