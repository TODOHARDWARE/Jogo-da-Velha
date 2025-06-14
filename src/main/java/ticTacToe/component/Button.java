package ticTacToe.component;
import ticTacToe.gui.util.MouseListenerAdapter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends AbstractComponent{

    public Button(){
        super.position = new Point(0, 0);
        super.dimension = new Dimension(20, 20);
    }
    
    public Button(int x, int y){
        super();
        setPosition(x, y);
    }

    public Button(int x, int y, int width, int height){
        super(x, y);
        setSize(width, height);
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

    private void doMouseOverDecoration(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(position.x + 2, position.y + 2,
                dimension.width - 4 , dimension.height - 4);
        g.setColor(color);
    }

    //--interface Paintable
    @Override
    public void paint(Graphics g) {
        if(mouseOver){
            doMouseOverDecoration(g);
        }
        else {
            g.drawRect(position.x, position.y,
                    dimension.width, dimension.height);
        }
    }

}
