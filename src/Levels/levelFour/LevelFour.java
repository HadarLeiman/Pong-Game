package Levels.levelFour;

import Basic.Sprite;
import Basic.Velocity;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;
import Geometry.Point;
import Levels.LevelInformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            vList.add(new Velocity(i, -3));
        }
        return vList;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return "Especto Patronus";
    }

    @Override
    public Sprite getBackground() {
        return new EspectoPatronusBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        bList.add(new Block(new Geometry.Point(100, 70), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(327, 70), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(100, 95), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(327, 95), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(129, 120), 58, 25, Color.WHITE));
        bList.add(new Block(new Point(298, 120), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(158, 145), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(269, 145), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(187, 170), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(245, 170), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(129, 195), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(187, 195), 58, 25, Color.WHITE));
        for (int i= 0; i<3 ; i++){
            double x = 100 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 220), 58, 25, Color.WHITE));
        }
        for (int i= 0; i<4 ; i++){
            double x = 71 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 245), 58, 25, Color.WHITE));
        }
        for (int i= 0; i<7 ; i++){
            double x = 187 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 270), 58, 25, Color.WHITE));
        }
        for (int i= 0; i<7 ; i++){
            double x = 216 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 295), 58, 25, Color.WHITE));
        }
        for (int i= 0; i<8 ; i++){
            double x = 187 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 320), 58, 25, Color.WHITE));
            bList.add(new Block(new Geometry.Point(x, 345), 58, 25, Color.WHITE));
        }
        for (int i= 0; i<3 ; i++){
            double x = 216 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 370), 58, 25, Color.WHITE));
        }
        for (int i= 0; i<4 ; i++){
            double x = 419 + (58 * i);
            bList.add(new Block(new Geometry.Point(x, 370), 58, 25, Color.WHITE));
        }
        bList.add(new Block(new Geometry.Point(187, 395), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(332, 395), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(448, 395), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(593, 395), 58, 25, Color.WHITE));

        bList.add(new Block(new Geometry.Point(216, 420), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(317, 420), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(477, 420), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(578, 420), 58, 25, Color.WHITE));

        bList.add(new Block(new Geometry.Point(245, 445), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(346, 445), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(506, 445), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(608, 445), 58, 25, Color.WHITE));

        bList.add(new Block(new Geometry.Point(375, 470), 58, 25, Color.WHITE));
        bList.add(new Block(new Geometry.Point(637, 470), 58, 25, Color.WHITE));

        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 70;
    }

    @Override
    public List<Ball> balls() {
        List<Ball> bList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            bList.add(new Ball(new Geometry.Point(((390+(i*10))), 500), 5,
                    Color.yellow, this.initialBallVelocities().get(i)));
        }
        return bList;
    }
}

