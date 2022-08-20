package Game.GameObjects;

import Basic.*;
import Game.GameLevel;
import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a BLock.
 *
 * @author Hadar Leiman 209170372
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle block;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Game.GameObjects.Block.
     *
     * @param upperLeft the upper left point of the block
     * @param width     the width of the block
     * @param height    the height of the block
     * @param color     the color of the block
     */
    public Block(Point upperLeft, double width, double height, java.awt.Color color) {

        this.block = new Rectangle(upperLeft, width, height);
        this.color = color;
    }

    /**
     * Instantiates a new Game.GameObjects.Block.
     *
     * @param block the block - a rectangle
     * @param color the color of the block
     */
    public Block(Rectangle block, java.awt.Color color) {

        this.block = block;
        this.color = color;
    }

    /**
     * Gets the "collision shape" of the block.
     *
     * @return the "collision shape" - a rectangle
     */
    public Rectangle getCollisionRectangle() {

        return block;
    }

    /**
     * draw the block on the given surface.
     *
     * @param surface - the DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        int x = (int) this.block.getUpperLeft().getX();
        int y = (int) this.block.getUpperLeft().getY();
        int width = (int) this.block.getWidth();
        int height = (int) this.block.getHeight();

        surface.setColor(this.color);
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, width, height);
    }

    // Notify the block that we collided with it at collisionPoint with a given velocity.
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double newDX = currentVelocity.getDx();
        double newDY = currentVelocity.getDy();
        //if the hit occurs on the top or bottom of the paddle
        //the hitting object change its vertical direction and keep its horizontal one
        if (this.block.getUpperLine().isIntersecting(collisionPoint)
                || this.block.getBottomLine().isIntersecting(collisionPoint)) {
            newDY = newDY * (-1);
        }
        //if the hit occurs on the left or right of the paddle
        //the hitting object change its horizontal direction and keep its vertical one
        if (this.block.getLeftLine().isIntersecting(collisionPoint)
                || this.block.getRightLine().isIntersecting(collisionPoint)) {
            newDX = newDX * (-1);
        }

        this.notifyHit(hitter);
        return new Velocity(newDX, newDY);

    }

    /**
     * Add the block to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * notify the block that time has passed.
     */
    public void timePassed() {
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notify a hit occurred.
     *
     * @param hitter - the ball that hit the block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
