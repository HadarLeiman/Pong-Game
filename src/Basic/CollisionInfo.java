package Basic;

import Geometry.Point;

/**
 * Represents a Collision Info.
 *
 * @author Hadar Leiman 209170372
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * get the collision point.
     * the point at which the collision occurs.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * get the collision object.
     * the collidable object involved in the collision.
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
