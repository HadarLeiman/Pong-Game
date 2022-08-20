package Geometry;

import java.util.List;

/**
 * Represents a Geometry.Rectangle.
 *
 * @author Hadar Leiman 209170372
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Instantiates a new Geometry.Rectangle.
     *
     * @param upperLeft the upper left point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
// Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
    }

    /**
     * Intersection points between the rectangle and a line - list.
     *
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     * @param line the line
     * @return the list of intersection points
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> list = new java.util.ArrayList<>();
        Point intersection;

        //intersection point with the upper line of the rectangle
        intersection = getUpperLine().intersectionWith(line);
        if (intersection != null) {
            list.add(intersection);
        }

        //intersection point with the bottom line of the rectangle
        intersection = getBottomLine().intersectionWith(line);
        if (intersection != null) {
            list.add(intersection);
        }

        //intersection point with the left line of the rectangle
        intersection = getLeftLine().intersectionWith(line);
        if (intersection != null) {
            list.add(intersection);
        }

        //intersection point with the right line of the rectangle
        intersection = getRightLine().intersectionWith(line);
        if (intersection != null) {
            list.add(intersection);
        }

        return list;
    }

    /**
     * Gets width.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left point of the rectangle
     */
// Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets upper right.
     *
     * @return the upper right point of the rectangle
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
    }

    /**
     * Gets bottom left.
     *
     * @return the bottom left point of the rectangle
     */
    public Point getBottomLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
    }

    /**
     * Gets bottom right.
     *
     * @return the bottom right point of the rectangle
     */
    public Point getBottomRight() {
        return new Point(getBottomLeft().getX() + width, getBottomLeft().getY());
    }

    /**
     * Gets upper line.
     *
     * @return the upper line of the rectangle
     */
    public Line getUpperLine() {
        return new Line(this.upperLeft, getUpperRight());
    }

    /**
     * Gets bottom line.
     *
     * @return the bottom line of the rectangle
     */
    public Line getBottomLine() {
        return new Line(getBottomLeft(), getBottomRight());
    }

    /**
     * Gets left line.
     *
     * @return the left line of the rectangle
     */
    public Line getLeftLine() {
        return new Line(this.upperLeft, getBottomLeft());
    }

    /**
     * Gets right line.
     *
     * @return the right line of the rectangle
     */
    public Line getRightLine() {
        return new Line(getUpperRight(), getBottomRight());
    }
}