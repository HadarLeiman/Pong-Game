import Animation.AnimationRunner;
import Game.GameFlow;
import Levels.LevelInformation;
import Levels.levelFour.LevelFour;
import Levels.levelThree.LevelThree;
import Levels.levelTwo.LevelTwo;
import Levels.levelOne.LevelOne;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hadar Leiman
 * <p>
 * This class contains main that create a game object, initializes and runs it.
 */

public class Main {
    /**
     * The entry point of application.
     * main create a game object, initializes and runs it.
     *
     * @param args user argument should be empty.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 1.5);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        List<LevelInformation> levelInformations = new ArrayList<>();
        if (args.length != 0) {
            for (String s : args) {
                if (s.equals("1")) {
                    levelInformations.add(new LevelOne());
                } else if (s.equals("2")) {
                    levelInformations.add(new LevelTwo());
                } else if (s.equals("3")) {
                    levelInformations.add(new LevelThree());
                } else if (s.equals("4")) {
                    levelInformations.add(new LevelFour());
                }
            }
        }
        if (levelInformations.isEmpty()) {
            levelInformations.add(new LevelOne());
            levelInformations.add(new LevelTwo());
            levelInformations.add(new LevelThree());
            levelInformations.add(new LevelFour());
        }
        GameFlow gameFlow = new GameFlow(gui, runner, keyboard);
        gameFlow.runLevels(levelInformations);
    }
}
