package Geometry;

/**
 * Represents a Geometry.Line.
 *
 * @author Hadar Leiman 209170372
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * Instantiates a new Geometry.Line.
     *
     * @param start the start
     * @param end   the end
     */
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Instantiates a new Geometry.Line.
     *
     * @param x1 the x of the start point
     * @param y1 the y of the start point
     * @param x2 the x of the end point
     * @param y2 the y of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Length double - return the length of the line.
     *
     * @return the length
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Middle point - returns the middle point of the line.
     *
     * @return the middle point
     */
    public Point middle() {
        double x3 = (this.start.getX() + this.end.getX()) / 2;
        double y3 = (this.start.getY() + this.end.getY()) / 2;
        Point mid = new Point(x3, y3);

        return mid;
    }

    /**
     * Start point - returns the start point of the line.
     *
     * @return the point
     */
    public Point start() {
        return this.start;
    }

    /**
     * End point - returns the end point of the line.
     *
     * @return the point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Slope double - returns the slope of the line (if exist).
     *
     * @return the slope (or NaN if slope do not exist - the line is parallel to the Y axis
     */
    public double slope() {
        if ((this.start().getX() - this.end().getX()) == 0) {
            return Double.NaN;
        }
        double slope = (this.start().getY() - this.end.getY()) / (this.start().getX() - this.end().getX());
        return slope;
    }

    /**
     * Y axis cut double - Returns the Y value of the point where the line cuts the Y axis (if exist).
     *
     * @return the y value
     */
    public double yAxisCut() {

        if (Double.isNaN(this.slope())) {
            return Double.NaN;
        }
        double y = this.start().getY() - (this.slope() * this.start().getX());
        return y;
    }

    /**
     * Is point boolean - returns true if line is point, false otherwise.
     *
     * @return true or false
     */
    public boolean isPoint() {
        if (this.start.equals(this.end)) {
            return true;
        }
        return false;
    }

    /**
     * Intersection with, point - returns the intersection point if the lines intersect and null otherwise.
     *
     * @param other the other line
     * @return the intersection point / null
     */
    public Point intersectionWith(Line other) {

        //case A: Both lines have no slope
        //(We will compare according to the values of Y)
        if (Double.isNaN(this.slope()) && Double.isNaN(other.slope())) {
            // this line starting point is equal to other line starting or ending point
            // Plus it's the only launch point (meaning they don't overlap)
            if ((this.start.equals(other.start)
                    && Double.max(this.end.getY(), other.end.getY()) >= this.start.getY()
                    && Double.min(this.end.getY(), other.end.getY()) <= this.start.getY())
                    || (this.start.equals(other.end)
                    && Double.max(this.end.getY(), other.start.getY()) >= this.start.getY()
                    && Double.min(this.end.getY(), other.start.getY()) <= this.start.getY())) {
                return this.start;
            }
            // this line ending point is equal to other line starting or ending point
            // Plus it's the only launch point (meaning they don't overlap)
            if ((this.end.equals(other.start)
                    && Double.max(this.start.getY(), other.end.getY()) >= this.end.getY()
                    && Double.min(this.start.getY(), other.end.getY()) <= this.end.getY())
                    || (this.end.equals(other.end)
                    && Double.max(this.start.getY(), other.start.getY()) >= this.end.getY()
                    && Double.min(this.start.getY(), other.start.getY()) <= this.end.getY())) {
                return this.end;
            }
            // this line is actually a point. We'll check if it's on the other line
            if (this.isPoint()
                    && this.start.getY() <= Double.max(other.start.getY(), other.end.getY())
                    && this.start.getY() >= Double.min(other.start.getY(), other.end.getY())) {
                return this.start;
            }
            // the other line is actually a point. We'll check if it's on the this line
            if (other.isPoint()
                    && other.start.getY() <= Double.max(this.start.getY(), this.end.getY())
                    && other.start.getY() >= Double.min(this.start.getY(), this.end.getY())) {
                return other.start;
            }
            // If none of the above cases existed there is no intersection point in case A and we will return NULL
            return null;
        }

        //case B: When the slope of the lines is equal
        //(We will compare according to the values of X)
        if (this.slope() == other.slope()) {
            // this line starting point is equal to other line starting or ending point
            // Plus it's the only launch point (meaning they don't overlap)
            if ((this.start.equals(other.start)
                    && Double.max(this.end.getX(), other.end.getX()) > this.start.getX()
                    && Double.min(this.end.getX(), other.end.getX()) < this.start.getX())
                    || (this.start.equals(other.end)
                    && Double.max(this.end.getX(), other.start.getX()) > this.start.getX()
                    && Double.min(this.end.getX(), other.start.getX()) < this.start.getX())) {
                return this.start;
            }
            // this line ending point is equal to other line starting or ending point
            // Plus it's the only launch point (meaning they don't overlap)
            if ((this.end.equals(other.start)
                    && Double.max(this.start.getX(), other.end.getX()) > this.end.getX()
                    && Double.min(this.start.getX(), other.end.getX()) < this.end.getX())
                    || (this.end.equals(other.end)
                    && Double.max(this.start.getX(), other.start.getX()) > this.end.getX()
                    && Double.min(this.start.getX(), other.start.getX()) < this.end.getX())) {
                return this.end;
            }
            // If none of the above cases existed there is no intersection point in case B and we will return NULL
            return null;
        }

        double x3;
        double y3;

        //case C: This line has no slope and the other line has
        //We will find the potential points of intersection between the lines
        if (Double.isNaN(this.slope())) {
            x3 = this.start.getX();
            y3 = other.slope() * this.start.getX() + other.yAxisCut();

            //case D: The other line has no slope and this line has
            //We will find the potential points of intersection between the lines
        } else if (Double.isNaN(other.slope())) {
            x3 = other.start.getX();
            y3 = this.slope() * other.start.getX() + this.yAxisCut();

            //case E: Both lines have slope
            //We will find the potential points of intersection between the lines
        } else {
            x3 = (other.yAxisCut() - this.yAxisCut()) / (this.slope() - other.slope());
            y3 = (this.slope() * x3) + this.yAxisCut();
        }

        //Check that the potential intersection point really is in the realm of the lines
        //(Relevant to case C, D and E)
        if ((Double.min(this.start.getX(), this.end.getX()) <= x3)
                && (Double.max(this.start.getX(), this.end.getX()) >= x3)
                && (Double.min(this.start.getY(), this.end.getY()) <= y3)
                && (Double.max(this.start.getY(), this.end.getY()) >= y3)
                && (Double.min(other.start.getX(), other.end.getX()) <= x3)
                && (Double.max(other.start.getX(), other.end.getX()) >= x3)
                && (Double.min(other.start.getY(), other.end.getY()) <= y3)
                && (Double.max(other.start.getY(), other.end.getY()) >= y3)) {

            Point intersection = new Point(x3, y3);
            return intersection;
        }
        //Otherwise, there is no point of intersection
        return null;
    }

    /**
     * Is intersecting, boolean- returns true if the lines intersect, false otherwise.
     *
     * @param other the other line
     * @return true or false
     */
    public boolean isIntersecting(Line other) {

        //Both lines have no slope
        if (Double.isNaN(this.slope()) && Double.isNaN(other.slope())) {
            //check if there is an overlap between the lines (comparing according to the values of Y)
            if ((((this.start.getY() <= Double.max(other.start.getY(), other.end.getY()))
                    && this.start.getY() >= Double.min(other.start.getY(), other.end.getY()))
                    || ((this.end.getY() <= Double.max(other.start.getY(), other.end.getY()))
                    && this.end.getY() >= Double.min(other.start.getY(), other.end.getY()))
                    || ((other.start.getY() <= Double.max(this.start.getY(), this.end.getY()))
                    && other.start.getY() >= Double.min(this.start.getY(), this.end.getY()))
                    || ((other.end.getY() <= Double.max(this.start.getY(), this.end.getY()))
                    && other.end.getY() >= Double.min(this.start.getY(), this.end.getY())))
                    && this.start.getX() == other.start.getX()) {
                return true;
            }
            //If there is no overlap we return NULL
            return false;
        }

        //When the slope of the lines is equal
        if (this.slope() == other.slope()) {
            //check if there is an overlap between the lines (comparing according to the values of X)
            if ((((this.start.getX() <= Double.max(other.start.getX(), other.end.getX()))
                    && this.start.getX() >= Double.min(other.start.getX(), other.end.getX()))
                    || ((this.end.getX() <= Double.max(other.start.getX(), other.end.getX()))
                    && this.end.getX() >= Double.min(other.start.getX(), other.end.getX()))
                    || ((other.start.getX() <= Double.max(this.start.getX(), this.end.getX()))
                    && other.start.getX() >= Double.min(this.start.getX(), this.end.getX()))
                    || ((other.end.getX() <= Double.max(this.start.getX(), this.end.getX()))
                    && other.end.getX() >= Double.min(this.start.getX(), this.end.getX())))
                    && this.yAxisCut() == other.yAxisCut()) {
                return true;
            }
            //If there is no overlap we return NULL
            return false;
        }

        //Checks if there is a value to the intersection point
        if (this.intersectionWith(other) != null) {
            return true;
        }

        //Otherwise, there is no point of intersection
        return false;
    }

    /**
     * Is intersecting, boolean- returns true if this line and the point intersect, false otherwise.
     *
     * @param other the other point
     * @return true or false
     */
    public boolean isIntersecting(Point other) {
        Line pointToLine = new Line(other, other);
        return isIntersecting(pointToLine);
    }

    /**
     * equals - return true if the lines are equal, false otherwise.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Line other) {

        if (this.start.equals(other.start) && this.end.equals(other.end)
                || this.start.equals(other.end) && this.end.equals(other.start)) {

            return true;
        }

        return false;
    }

    /**
     * Closest intersection to start of line - point.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect the rectangle
     * @return the closest intersection point (or null)
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //get the list of intersection points with the rectangle
        java.util.List<Point> list = rect.intersectionPoints(this);
        int numOfIntersectionPoints = list.size();
        //if there is no intersection points.
        if (numOfIntersectionPoints == 0) {
            return null;
        }
        //if theres only one intersection point
        if (numOfIntersectionPoints == 1) {
            return list.get(0);
        }

        //if theres two intersection points (max num of points)
        Point one = list.get(0);
        Point two = list.get(1);

        if (one.distance(this.start) < two.distance(this.start)) {
            return one;
        }
        return two;
    }
}