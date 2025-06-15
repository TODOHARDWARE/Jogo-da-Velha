package ticTacToe.component.button;
import ticTacToe.component.AbstractComponent;
import ticTacToe.gui.util.MouseListenerAdapter;
import ticTacToe.component.button.ButtonClickEvent.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

public class Button extends AbstractComponent {

    public Button(){
        super();
    }

    public Button(int x, int y){
        super(x, y);
    }

    public Button(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    @Override
    protected void onMouseClick(MouseEvent me) {
        dispatchButtonClickEvent(me);
    }

    //--Observer Pattern-------------------------------------------------------
    Set<ButtonClickListener> buttonClickListeners = new HashSet<>();

    public void addButtonClickListener(ButtonClickListener listener) {
        buttonClickListeners.add(listener);
    }

    public void removeButtonClickListener(ButtonClickListener listener) {
        buttonClickListeners.remove(listener);
    }

    private void dispatchButtonClickEvent(MouseEvent me) {
        MouseButton button = ((me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT :
                (me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDDLE :
                        MouseButton.RIGHT);

        ButtonClickEvent event = new ButtonClickEvent(this, button);
        buttonClickListeners.forEach(listener->listener.onClick(event));
    }


    //--interface Paintable
    public void doMouseOverDecoration(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(position.x + 2, position.y + 2,
                dimension.width - 4 , dimension.height - 4);
        g.setColor(color);
    }

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
