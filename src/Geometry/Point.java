package Geometry;

import java.util.Random;

/**
 * Represents a Geometry.Point.
 * @author Hadar Leiman 209170372
 */
public class Point {

    private double x;
    private double y;

    /**
     * Instantiates a new Geometry.Point.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance double - return the distance of this point to the other point.
     *
     * @param other the other point
     * @return the distance
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * Equals boolean.
     *
     * @param other the other point
     * @return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if ((this.x == other.x) && (this.y == other.y)) {
            return true;
        }
        return false;
    }

    /**
     * Rand point point - return random point in range requested.
     *
     * @param xMin the min value of x
     * @param yMin the min value of y
     * @param xMax the max value of x
     * @param yMax the max value of y
     * @return random point
     */
    public static Point randPoint(double xMin, double yMin, double xMax, double yMax) {
        Random rand = new Random(); // create a random-number generator
        double x = rand.nextInt((int) xMax) + rand.nextDouble() + xMin;
        double y = rand.nextInt((int) yMax) + rand.nextDouble() + yMin;
        Point p = new Point(x, y);
        return p;
    }

    /**
     * Gets x.
     *
     * @return the x of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y of this point
     */
    public double getY() {
        return this.y;
    }
}