package Basic;

import Geometry.Point;

/**
 * Represents a Basic.Velocity.
 *
 * @author Hadar Leiman 209170372
 */
public class Velocity {

    private double dx;
    private double dy;

    /**
     * Instantiates a new Basic.Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Instantiates a new velocity From angle and speed.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(angle) * speed;
        double dy = -1 * Math.cos(angle) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Get dx double.
     *
     * @return the dx value of this velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Get dy double.
     *
     * @return the dy value of this velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Get speed double.
     *
     * @return the speed of this velocity.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

    /**
     * Apply to point point.
     * <p>
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     *
     * @param p the point
     * @return the updated point
     */

    public Point applyToPoint(Point p) {
        double x = p.getX() + this.dx;
        double y = p.getY() + this.dy;

        return new Point(x, y);
    }
}