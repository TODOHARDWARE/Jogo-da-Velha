package ticTacToe.gui.score;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.TextButton;
import ticTacToe.model.score.ReadOnlyScoreModel;
import ticTacToe.gui.MainWindow.*;

import javax.swing.*;
import java.awt.*;

public class ScoreView extends AbstractComponent {
    private ReadOnlyScoreModel scoreModel = null;
    private TextButton scoreX = new TextButton(250, 100, 50, 50);
    private TextButton scoreO = new TextButton(250, 100, 50, 50);

    private ImageIcon background = null;

    public ScoreView(int x, int y, int width, int height, ReadOnlyScoreModel scoreModel){
        super(x, y, width, height);
        this.scoreModel = scoreModel;
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

    private void drawImage(Graphics2D g2D) {
        g2D.drawImage(background.getImage(),
                position.x, position.y,
                width(), height(), null);
    }


    @Override
    public void paint(Graphics g) {
        if(background != null)
            drawImage((Graphics2D)g);
    }
}
