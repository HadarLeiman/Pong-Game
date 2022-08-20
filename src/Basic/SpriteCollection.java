package Basic;

import java.util.ArrayList;
import java.util.List;

import Basic.Sprite;
import biuoop.DrawSurface;


/**
 * Represents a sprite collection.
 *
 * @author Hadar Leiman 209170372
 */
public class SpriteCollection {

    private List<Sprite> collection = new ArrayList<>();

    /**
     * Add sprite to this collection.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        collection.add(s);
    }

    /**
     * remove sprite to this collection.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        collection.remove(s);
    }

    /**
     * call timePassed() on all sprites in this collection.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<>(this.collection);
        for (Sprite i : sprites) {
            i.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites in this collection.
     *
     * @param d the draw surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite i : this.collection) {
            i.drawOn(d);
        }
    }
}
