package appTest;

import ticTacToe.component.button.Button;
import ticTacToe.component.button.ImageButton;
import ticTacToe.gui.MainWindow;

import javax.swing.*;
import java.net.URL;

public class AppImageButtonTest {

    static ImageIcon loadImage(String pathWithFileName) {
        URL url = AppBackgroundTest.class.getResource(pathWithFileName);
        return new ImageIcon(url);
    }

    public static void main(String[] args) {
        final String path = "../ticTacToe/images/";
        ImageIcon icon = loadImage(path + "markX.png");

        MainWindow window = new MainWindow();
        Button button = new Button(250, 100, 50, 50);
        window.add(button);
        window.addMouseMotionListener(button.mouseMotionListener());
        window.addMouseListener(button.mouseListener());

        button.addButtonClickListener((event) -> {
            ImageButton imgbutton = new ImageButton(250, 100, 50, 50, icon);
            window.add(imgbutton);
        });
    }
}