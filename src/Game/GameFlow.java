package Game;

import Animation.AnimationRunner;
import Animation.GameOverScreen;
import Animation.KeyPressStoppableAnimation;
import Animation.YouWinScreen;
import Basic.Counter;
import Levels.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;

    public GameFlow(GUI gui, AnimationRunner ar, KeyboardSensor ks) {
        this.gui = gui;
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    public void runLevels(List<LevelInformation> levels) {
        boolean winOrLose = true;
        Counter score = new Counter();
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(this.gui, levelInfo, this.keyboardSensor, this.animationRunner, score);

            level.initialize();

            while ((level.getNumOfBalls().getValue() != 0) && (level.getNumOfBlocks().getValue() != 0)) {
                level.run();
            }

            if (level.getNumOfBalls().getValue() == 0) {
                winOrLose = false;
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, " ", new GameOverScreen(score.getValue())));
                break;
            }

        }
        if (winOrLose) {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, " ", new YouWinScreen(score.getValue())));
        }
        gui.close();
    }
}