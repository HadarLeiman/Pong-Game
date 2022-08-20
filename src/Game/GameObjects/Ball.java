package Game.GameObjects;

import Basic.*;
import Game.GameEnvironment;
import Game.GameLevel;
import Geometry.Line;
import Geometry.Point;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Game.GameObjects.Ball.
 *
 * @author Hadar Leiman 209170372
 */
public class Ball implements Sprite, HitNotifier {

    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity = null;
    private GameEnvironment gameEnvironment = null;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Game.GameObjects.Ball.
     *
     * @param center the center
     * @param r      the radius
     * @param color  the color
     */
    public Ball(Point center, int r, java.awt.Color color) {

        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * Instantiates a new Game.GameObjects.Ball.
     *
     * @param x     the x value of the center
     * @param y     the y value of the center
     * @param r     the radius
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }

    /**
     * Instantiates a new Game.GameObjects.Ball.
     *
     * @param center   the center
     * @param r        the radius
     * @param color    the color
     * @param velocity the velocity
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity velocity) {
        this(center, r, color);
        this.velocity = velocity;
    }

    /**
     * Instantiates a new Game.GameObjects.Ball.
     *
     * @param x           the x value of the center
     * @param y           the y value of the center
     * @param r           the radius
     * @param color       the color
     * @param velocity    the velocity
     * @param environment the game environment
     */
    public Ball(double x, double y, int r, java.awt.Color color, Velocity velocity, GameEnvironment environment) {
        this(x, y, r, color);
        this.velocity = velocity;
        this.gameEnvironment = environment;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the radius
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw on - draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        int x = (int) this.center.getX();
        int y = (int) this.center.getY();

        surface.setColor(this.color);
        surface.fillCircle(x, y, this.radius);
    }

    /**
     * Sets velocity.
     *
     * @param v the velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity by radius size.
     * Receives an angle
     * determines the speed according to the radius of the ball
     * (the smaller the radius the faster the ball  - up to 50)
     * and then updates the velocity accordingly.
     *
     * @param angle the angle of the velocity
     */
    public void setVelocityByRadiusSize(double angle) {
        this.velocity = Velocity.fromAngleAndSpeed(angle, ((this.radius < 50) ? 50 - this.radius : 1));
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Move one step - Moves the center of the ball one step according to the ball velocity
     * and collisions that occurs.
     */
    public void moveOneStep() {
        if (velocity != null) {
            //compute the ball trajectory
            Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
            //Check (using the game environment) if moving on this trajectory will hit anything
            CollisionInfo cInf = this.gameEnvironment.getClosestCollision(trajectory);
            //if no hit will occur move the ball to the end of the trajectory and return.
            if (cInf == null) {
                this.center = this.velocity.applyToPoint(this.center);
                return;
            }

            //otherwise - updating the center according to location on the object the ball hit
            //if the hit occurs on the top of the object
            if (((CollisionInfo) cInf).collisionObject().getCollisionRectangle().getUpperLine().isIntersecting(cInf.collisionPoint())) {
                this.center = new Point(cInf.collisionPoint().getX(), cInf.collisionPoint().getY() - this.radius);
            }
            //if the hit occurs on the bottom of the object
            if (cInf.collisionObject().getCollisionRectangle().getBottomLine().isIntersecting(cInf.collisionPoint())) {
                this.center = new Point(cInf.collisionPoint().getX(), cInf.collisionPoint().getY() + this.radius);
            }
            //if the hit occurs on the left side of the object
            if (cInf.collisionObject().getCollisionRectangle().getLeftLine().isIntersecting(cInf.collisionPoint())) {
                this.center = new Point(cInf.collisionPoint().getX() - this.radius, cInf.collisionPoint().getY());
            }
            //if the hit occurs on the right side of the object
            if (cInf.collisionObject().getCollisionRectangle().getRightLine().isIntersecting(cInf.collisionPoint())) {
                this.center = new Point(cInf.collisionPoint().getX() + this.radius, cInf.collisionPoint().getY());
            }

            //notify the hit object (using its hit() method) that a collision occurred.
            //update the velocity to the new velocity returned by the hit() method.
            this.velocity = cInf.collisionObject().hit(this, cInf.collisionPoint(), this.velocity);

        }
    }

    /**
     * Sets game environment.
     *
     * @param ge the game environment
     */
    public void setGameEnvironment(GameEnvironment ge) {
        this.gameEnvironment = ge;
    }


    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * notify the ball that time has passed.
     * the ball will move one step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Add this ball to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }


    /**
     * Remove from game.
     *
     * @param g the g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
