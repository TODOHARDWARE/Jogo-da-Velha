package ticTacToe.component;
import ticTacToe.gui.Paintable;

import java.awt.*;

public class Button implements Paintable {
    private Point position = null;
    private Dimension dimension = null;

    public Button(){
        this.position = new Point(0, 0);
        this.dimension = new Dimension(20, 20);
    }
    
    public Button(int x, int y){
        this();
        setPosition(x, y);
    }

    public Button(int x, int y, int width, int height){
        this(x, y);
        setSize(width, height);
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }

    public Point getPosition() {
        return (Point) this.position.clone();
    }

    public void setSize(int width, int height) {
        this.dimension = new Dimension(width, height);
    }

    public Dimension getSize() {
        return (Dimension) this.dimension.clone();
    }

    public int width() {
        return this.dimension.width;
    }

    public int height() {
        return this.dimension.height;
    }

    //--interface Paintable
    @Override
    public void paint(Graphics g) {
        g.drawRect(position.x, position.y,
                dimension.width, dimension.height);
    }
}
