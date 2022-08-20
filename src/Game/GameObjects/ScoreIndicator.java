package Game.GameObjects;

import Basic.Counter;
import Basic.Sprite;
import Game.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 *
 * @author Hadar Leiman
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.gray);
        d.fillRectangle(0, 0, 800, 30);
        String s = "Score: " + this.score.getValue();
        d.setColor(Color.white);
        d.drawText(372, 23, s, 20);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Add to game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
