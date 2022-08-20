package Levels.levelTwo;

import Basic.Sprite;
import Basic.Velocity;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;
import Geometry.Point;
import Levels.LevelInformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            vList.add(new Velocity(0, 6));
        }
        return vList;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Sorting Hat";
    }

    @Override
    public Sprite getBackground() {
        return new SortingHatBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        bList.add(new Block(new Point(479, 85), 53, 25, new Color(79,39,0)));
        for (int i= 0; i<2 ; i++){
            double x = 346 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 185), 53, 25, new Color(79,39,0)));
            x = 373 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 160), 53, 25, new Color(79,39,0)));
            x = 399 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 135), 53, 25, new Color(79,39,0)));
            x = 426 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 110), 53, 25, new Color(79,39,0)));
        }
        for (int i= 0; i<3 ; i++){
            double x = 320 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 210), 53, 25, new Color(79,39,0)));
            bList.add(new Block(new Geometry.Point(x, 235), 53, 25, new Color(79,39,0)));
        }
        for (int i= 0; i<4 ; i++){
            double x = 293 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 260), 53, 25, new Color(79,39,0)));
        }
        for (int i= 0; i<5 ; i++){
            double x = 267 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 285), 53, 25, new Color(79,39,0)));
        }
        for (int i= 0; i<6 ; i++){
            double x = 240 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 310), 53, 25, new Color(79,39,0)));
            bList.add(new Block(new Geometry.Point(x, 335), 53, 25, new Color(79,39,0)));
        }
        for (int i= 0; i<9 ; i++){
            double x = 161 + (53 * i);
            bList.add(new Block(new Geometry.Point(x, 360), 53, 25, new Color(79,39,0)));
        }

        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 45;
    }
    @Override
    public List<Ball> balls() {
        List<Ball> bList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            bList.add(new Ball(new Geometry.Point((((i+1)*800) / (this.numberOfBalls() + 1)), 500), 8,
                    Color.BLACK, this.initialBallVelocities().get(i)));
        }
        return bList;
    }
}
