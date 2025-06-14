package ticTacToe.component;
import ticTacToe.gui.Paintable;
import ticTacToe.gui.util.MouseListenerAdapter;
import ticTacToe.gui.util.MouseMotionAdapter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Button implements Paintable {
    private Point position = null;
    private Dimension dimension = null;
    private boolean mouseOver = false;

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

    public boolean isOver(Point point) {

        int xLeft = this.position.x;
        int yTop = this.position.y;
        int xRight = xLeft + this.width();
        int yBottom = yTop + this.height();

        return ((point.x > xLeft && point.x < xRight) &&
                (point.y > yTop && point.y < yBottom));
    }


    public MouseListener mouseListener() {
        return new MouseListenerAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {

                if(!isOver(me.getPoint())) return;

                System.out.println("Salve!");

            }
        };
    }

    public MouseMotionListener mouseMotionListener() {
        return new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent me) {

                if(!isOver(me.getPoint())){
                    mouseOver = false;
                    return;
                }

                    mouseOver = true;

            }
        };
    }


    //--interface Paintable
    @Override
    public void paint(Graphics g) {

        if (mouseOver){
            Color color = g.getColor();
            g.setColor(Color.RED);
            g.drawRect(position.x + 2, position.y + 2,
                    dimension.width - 4 , dimension.height - 4);
            g.setColor(color);
        }
        else {
        g.drawRect(position.x, position.y,
                    dimension.width, dimension.height);}
    }
}
