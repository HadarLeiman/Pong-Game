package Basic;

import Game.GameObjects.Ball;
import Geometry.Point;
import Geometry.Rectangle;

/**
 * The interface Basic.Collidable.
 * @author Hadar Leiman 209170372
 */
public interface Collidable {
    /**
     * Gets the "collision shape" of the object.
     *
     * @return the "collision shape" - a rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter thr ball that hit
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
