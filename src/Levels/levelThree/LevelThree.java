package Levels.levelThree;

import Basic.Sprite;
import Basic.Velocity;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;
import Geometry.Point;
import Levels.LevelInformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new ArrayList<>();
        vList.add(new Velocity(1, -4));
        vList.add(new Velocity(-1, -4));
        vList.add(new Velocity(-1, -4));
        return vList;
    }

    @Override
    public int paddleSpeed() {
        return 9;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Quidditch";
    }

    @Override
    public Sprite getBackground() {
        return new QuidditchBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();

        bList.add(new Block(new Geometry.Point(530, 120), 58, 25, Color.white));
        for (int i=0;i<5;i++){
            bList.add(new Block(new Geometry.Point(500, 145+(25*i)), 58, 25, Color.white));
            bList.add(new Block(new Geometry.Point(558, 145+(25*i)), 58, 25, Color.white));
        }
        bList.add(new Block(new Geometry.Point(530, 270), 58, 25, Color.white));

        bList.add(new Block(new Geometry.Point(395, 185), 58, 25, Color.white));
        bList.add(new Block(new Geometry.Point(655, 185), 58, 25, Color.white));
        for (int i=0;i<4;i++){
            bList.add(new Block(new Geometry.Point(365, 210+(25*i)), 58, 25, Color.white));
            bList.add(new Block(new Geometry.Point(625, 210+(25*i)), 58, 25, Color.white));
            bList.add(new Block(new Geometry.Point(423, 210+(25*i)), 58, 25, Color.white));
            bList.add(new Block(new Geometry.Point(683, 210+(25*i)), 58, 25, Color.white));
        }
        bList.add(new Block(new Point(395, 310), 58, 25, Color.white));
        bList.add(new Block(new Geometry.Point(655, 310), 58, 25, Color.white));

        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 32;
    }

    @Override
    public List<Ball> balls() {
        List<Ball> bList = new ArrayList<>();
        bList.add(new Ball(new Geometry.Point(( 800/this.numberOfBalls() + 1), 500), 5,
                Color.BLACK, this.initialBallVelocities().get(0)));
        bList.add(new Ball(new Geometry.Point(1600 / (this.numberOfBalls() + 1), 500), 8,
                Color.red, this.initialBallVelocities().get(1)));
        bList.add(new Ball(new Geometry.Point(2400 / (this.numberOfBalls() + 1), 500), 5,
                Color.BLACK, this.initialBallVelocities().get(2)));
        return bList;
    }
}
