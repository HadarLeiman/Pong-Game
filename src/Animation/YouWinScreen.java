package Animation;

import biuoop.DrawSurface;

import java.awt.*;

public class YouWinScreen implements Animation {
    private Integer score;

    public YouWinScreen(Integer score){
        this.score=score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.PINK);
        d.fillRectangle(0,0,d.getWidth(),d.getWidth());
        d.setColor(Color.BLACK);
        d.drawText(240,200,"You Win!",90);
        d.drawText(240, d.getHeight() / 2, "press space to continue", 32);
        d.drawText(240, 400, "your score is:" + score.toString(), 32);
    }
    @Override
    public boolean shouldStop() { return false; }
}
