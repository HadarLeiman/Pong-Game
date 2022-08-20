package Levels.levelOne;

import Basic.Sprite;
import Basic.Velocity;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;
import Geometry.Point;
import Levels.LevelInformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelOne implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vList = new ArrayList<>();
        vList.add(new Velocity(0, 4));
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
        return "Avada Kedavra";
    }

    @Override
    public Sprite getBackground() {
        return new AvadaKedavraBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> bList = new ArrayList<>();
        bList.add(new Block(new Point(371, 200), 58, 25, Color.BLACK));
        return bList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public List<Ball> balls() {
        List<Ball> bList = new ArrayList<>();

        bList.add(new Ball(new Geometry.Point((800 / (this.numberOfBalls() + 1)), 500), 5,
                Color.GREEN, this.initialBallVelocities().get(0)));
        return bList;
    }
}
