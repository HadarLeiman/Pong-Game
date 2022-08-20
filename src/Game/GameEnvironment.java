package Game;

import Basic.Collidable;
import Basic.CollisionInfo;
import Geometry.Line;
import Geometry.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game environment.
 *
 * @author Hadar Leiman 209170372
 */
public class GameEnvironment {
    private List<Collidable> enviroment = new ArrayList<>();

    /**
     * Add the given collidable to the environment.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {

        enviroment.add(c);
    }

    /**
     * remove the given collidable to the environment.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {

        enviroment.remove(c);
    }

    /**
     * Gets closest collision.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory
     * @return the closest collision info (collision point and collision object)
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //Create a list of collision info which will contain all points of collision
        //that are closest to the start of the trajectory with all collidables in this collection
        //and respectively the collidable
        List<Collidable> enviromentCopy = new ArrayList<>(this.enviroment);
        List<CollisionInfo> collisionInfos = new ArrayList<>();
        for (int i = 0; i < enviromentCopy.size(); i++) {
            Point temp = trajectory.closestIntersectionToStartOfLine(enviromentCopy.get(i).getCollisionRectangle());
            if (temp != null) {
                collisionInfos.add(new CollisionInfo(temp, enviromentCopy.get(i)));
            }
        }

        // Find the point closest to the start of the trajectory from the list
        if (!collisionInfos.isEmpty()) {
            int closestCollisionIndex = 0;

            for (int i = 1; i < collisionInfos.size(); i++) {
                if (collisionInfos.get(i).collisionPoint().distance(trajectory.start())
                        < collisionInfos.get(closestCollisionIndex).collisionPoint().distance(trajectory.start())) {
                    closestCollisionIndex = i;
                }
            }

            return collisionInfos.get(closestCollisionIndex);
        }

        //if the list of collision info is empty
        //meaning the trajectory do not intersect with any of the collidables in this collection
        return null;
    }
}
