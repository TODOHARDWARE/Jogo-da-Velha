package ticTacToe.component.button;

import javax.swing.*;
import java.awt.*;

public class ImageButton extends Button {
    private ImageIcon icon;

    public ImageButton() {
        super();
        this.icon = null;
    }

    public ImageButton(ImageIcon icon) {
        super();
        this.icon = icon;
    }

    public ImageButton(int x, int y, int width, int height, ImageIcon icon) {
        super(x, y, width, height);
        this.icon = icon;
    }


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
