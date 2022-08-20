package Game;

import Animation.KeyPressStoppableAnimation;
import Animation.Animation;
import Animation.AnimationRunner;
import Animation.CountdownAnimation;
import Animation.PauseScreen;
import Basic.Collidable;
import Basic.Counter;
import Basic.Sprite;
import Basic.SpriteCollection;
import Game.GameObjects.Ball;
import Game.GameObjects.Block;
import Game.GameObjects.Paddle;
import Game.GameObjects.ScoreIndicator;
import Geometry.Point;
import Levels.LevelInformation;
import Listeners.BallRemover;
import Listeners.BlockRemover;
import Listeners.ScoreTrackingListener;
import biuoop.GUI;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Represents a Game.
 *
 * @author Hadar Leiman 209170372
 */
public class GameLevel implements Animation {
    private GUI gui;
    private LevelInformation levelInfo;
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private Counter numOfBlocks = new Counter();
    private Counter numOfBalls = new Counter();
    private Counter score;
    private biuoop.KeyboardSensor keyboard;

    public GameLevel(GUI gui, LevelInformation levelInfo, biuoop.KeyboardSensor keyboard, AnimationRunner runner,
                     Counter score ) {
        this.gui= gui;
        this.levelInfo = levelInfo;
        this.keyboard= keyboard;
        this.runner= runner;
        this.score =score;
    }

    /**
     * Add collidable to this environment.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Add sprite to this collection.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Game.GameObjects.Ball (and Game.GameObjects.Paddle)
     * and add them to the game.
     */
    public void initialize() {
        sprites.addSprite(levelInfo.getBackground());
        //creating tall and wide blocks at the borders of the screen and adding them to the game
        Block upperScreen = new Block(new Point(0, 30), 800, 2, java.awt.Color.BLACK);
        upperScreen.addToGame(this);
        Block leftScreen = new Block(new Point(0, 32), 2, 568, java.awt.Color.BLACK);
        leftScreen.addToGame(this);
        Block rightScreen = new Block(new Point(798, 32), 2, 568, java.awt.Color.BLACK);
        rightScreen.addToGame(this);
        BallRemover ballR = new BallRemover(this, this.numOfBalls);
        Block bottomScreen = new Block(new Point(0, 600), 800, 2, java.awt.Color.BLACK);
        bottomScreen.addHitListener(ballR);
        bottomScreen.addToGame(this);

        //creating two kinds of listeners to add to the blocks
        BlockRemover blockR = new BlockRemover(this, this.numOfBlocks);
        ScoreTrackingListener scoreT = new ScoreTrackingListener(this.score);

        //creating blocks in a nice pattern and adding them to the game
        for (Block i : levelInfo.blocks()) {
            this.numOfBlocks.increase(1);
            i.addHitListener(blockR);
            i.addHitListener(scoreT);
            i.addToGame(this);
        }

        //creating a paddle and adding it to the game
        Paddle paddle = new Paddle(new Point((798- levelInfo.paddleWidth())/2, 593), levelInfo.paddleWidth()
                , 5, keyboard, Color.black,
                levelInfo.paddleSpeed());
        paddle.addToGame(this);

        //creating the balls (associating the balls with the Game.GameEnvironment) and adding them to the game.
        for (Ball b:levelInfo.balls()){
            b.setGameEnvironment(this.environment);
            this.numOfBalls.increase(1);
            b.addToGame(this);
        }

        //creating the score indicator and adding to the game
        ScoreIndicator si = new ScoreIndicator(this.score);
        si.addToGame(this);

    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(552, 23, "Level Name: "+this.levelInfo.levelName(), 20);
        this.sprites.notifyAllTimePassed();
        if (numOfBlocks.getValue() == levelInfo.blocks().size()- levelInfo.numberOfBlocksToRemove()) {
            this.running = false;
            this.score.increase(100);
        }
        if (numOfBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard," ",new PauseScreen()));
        }
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites, this.levelInfo.levelName()));
        this.runner.setFramesPerSecond(60);
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
        //gui.close();
    }

    /**
     * Remove collidable.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    public Counter getNumOfBalls() {
        return numOfBalls;
    }

    public Counter getNumOfBlocks() {
        return numOfBlocks;
    }
}