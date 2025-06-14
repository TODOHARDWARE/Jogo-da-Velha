package ticTacToe.gui;

import ticTacToe.component.AbstractComponent;

import javax.swing.*;
import java.awt.*;

public class Table extends AbstractComponent {
    private ImageIcon icon;

    public Table(){
        super.position = new Point (0,0);
        super.dimension = new Dimension (100,100);
        this.icon = null;
    }

    public Table(ImageIcon icon){
        super();
        this.icon = icon;
    }

    public Table(int x, int y, int width, int height, ImageIcon icon) {
        super.position = new Point(x, y);
        super.dimension = new Dimension(width, height);
        this.icon = icon;
    }


    @Override
    public void paint(Graphics g) {
        if (icon == null)
            return;

        int xLeft = position.x;
        int yTop = position.y;
        int width = dimension.width;
        int height = dimension.height;

        g.drawImage(icon.getImage(), xLeft, yTop, width, height, null);
    }
}
