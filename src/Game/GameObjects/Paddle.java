package Game.GameObjects;

import Basic.Collidable;
import Basic.Sprite;
import Basic.Velocity;
import Game.GameLevel;
import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a paddle.
 *
 * @author Hadar Leiman 209170372
 */
public class Paddle implements Sprite, Collidable {
    private Rectangle paddle;
    private biuoop.KeyboardSensor keyboard;
    private Color color;
    private int speed;


    /**
     * Instantiates a new Game.GameObjects.Paddle.
     *
     * @param upperLeft the upper left point of the paddle
     * @param width     the width of the paddle
     * @param height    the height of the paddle
     * @param keyboard  the biuoop.KeyboardSensor
     * @param color     the color of the paddle
     */
    public Paddle(Point upperLeft, double width, double height, biuoop.KeyboardSensor keyboard, java.awt.Color color
    ,int speed) {

        this.paddle = new Rectangle(upperLeft, width, height);
        this.keyboard = keyboard;
        this.color = color;
        this.speed = speed;
    }

    /**
     * Instantiates a new Game.GameObjects.Paddle.
     *
     * @param paddle   the paddle
     * @param keyboard the biuoop.KeyboardSensor
     * @param color    the color of the paddle
     */
    public Paddle(Rectangle paddle, biuoop.KeyboardSensor keyboard, java.awt.Color color) {

        this.paddle = paddle;
        this.keyboard = keyboard;
        this.color = color;
    }

    /**
     * Move left - move the paddle to the left unless it hits the age of the screen.
     */
    public void moveLeft() {
        if (!this.paddle.getUpperLine().isIntersecting(new Line(2, 2, 2, 598))) {
            double upperLeftX = this.paddle.getUpperLeft().getX() - this.speed;
            double upperLeftY = this.paddle.getUpperLeft().getY();
            double width = this.paddle.getWidth();
            double height = this.paddle.getHeight();

            this.paddle = new Rectangle(new Point(upperLeftX, upperLeftY), width, height);
        }
    }

    /**
     * Move right - move the paddle to the right unless it hits the age of the screen.
     */
    public void moveRight() {
        if (!this.paddle.getUpperLine().isIntersecting(new Line(798, 2, 798, 598))) {
            double upperLeftX = this.paddle.getUpperLeft().getX() + this.speed;
            double upperLeftY = this.paddle.getUpperLeft().getY();
            double width = this.paddle.getWidth();
            double height = this.paddle.getHeight();

            this.paddle = new Rectangle(new Point(upperLeftX, upperLeftY), width, height);
        }
    }

    /**
     * notify the paddle that time has passed.
     * The paddle will move to the right or left depending on the key that the player presses
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }

        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the paddle on the given surface.
     *
     * @param d - the DrawSurface
     */
    public void drawOn(DrawSurface d) {
        int x = (int) this.paddle.getUpperLeft().getX();
        int y = (int) this.paddle.getUpperLeft().getY();
        int width = (int) this.paddle.getWidth();
        int height = (int) this.paddle.getHeight();

        d.setColor(this.color);
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.WHITE);
        d.drawRectangle(x, y, width, height);
    }

    /**
     * Return the "collision shape" of the paddle.
     *
     * @return this paddle (a rectangle)
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //We will create an array of lines and insert the upper line of the pedal divided into five parts
        double fifthPaddleSize = this.paddle.getUpperLine().length() / 5;
        List<Line> paddleParts = new ArrayList<>();
        Point tempStart = this.paddle.getUpperLeft();
        for (int i = 0; i < 5; i++) {
            Point tempEnd = new Point(tempStart.getX() + fifthPaddleSize, tempStart.getY());
            Line temp = new Line(tempStart, tempEnd);
            paddleParts.add(temp);
            tempStart = tempEnd;
        }
        //if the hit occurs in left-most region (1) the hitting object bounce back with an angle of 300 degrees
        //keeping the same speed
        if (paddleParts.get(0).isIntersecting(collisionPoint)) {
            double speed = currentVelocity.getSpeed();
            double angle = (Math.PI * 5) / 3;
            return Velocity.fromAngleAndSpeed(angle, speed);
        }
        //if the hit occurs in mid-left region (2) the hitting object bounce back with an angle of 330 degrees
        if (paddleParts.get(1).isIntersecting(collisionPoint)) {
            double speed = currentVelocity.getSpeed();
            double angle = (Math.PI * 11) / 6;
            return Velocity.fromAngleAndSpeed(angle, speed);
        }
        //if the hit occurs in middle region (3) the hitting object change its vertical direction
        //and keep its horizontal one
        if (paddleParts.get(2).isIntersecting(collisionPoint)) {
            double dx = currentVelocity.getDx();
            double dy = -1 * currentVelocity.getDy();
            return new Velocity(dx, dy);
        }

        //if the hit occurs in mid-right region (4) the hitting object bounce back with an angle of 30 degrees
        if (paddleParts.get(3).isIntersecting(collisionPoint)) {
            double speed = currentVelocity.getSpeed();
            double angle = Math.PI / 6;
            return Velocity.fromAngleAndSpeed(angle, speed);
        }
        //if the hit occurs in right-most region (5) the hitting object bounce back with an angle of 60 degrees
        if (paddleParts.get(4).isIntersecting(collisionPoint)) {
            double speed = currentVelocity.getSpeed();
            double angle = Math.PI / 3;
            return Velocity.fromAngleAndSpeed(angle, speed);
        }

        //if the hit occurs elsewhere, meaning the paddle sides,
        //the hitting object change its horizontal direction and keep its vertical one
        double dx = -1 * currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        return new Velocity(dx, dy);
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}