package appTest;

import ticTacToe.gui.MainWindow;
import ticTacToe.gui.TableView;
import ticTacToe.model.Mark;
import ticTacToe.model.table.SimpleTableModel;
import ticTacToe.model.table.TableModel;

import javax.swing.*;
import java.net.URL;

public class AppTableModelTableViewTest {
    //Model
    TableModel tableModel = new SimpleTableModel();

    //View
    MainWindow window = new MainWindow();
    TableView tableView = createTableView();

    private ImageIcon loadImage(String filename){
        String path = "../ticTacToe/images/";
        URL url = getClass().getResource(path + filename);
        return new ImageIcon(url);
    }

    private TableView createTableView(){

        ImageIcon icon = loadImage("tic-tac-toe.png");
        TableView table = new TableView(50, 50, 200, 200, icon);

        icon = loadImage("markX.png");
        table.setIconX(icon);

        icon = loadImage("markO.png");
        table.setIconO(icon);

        return table;
    }

    public AppTableModelTableViewTest(){

        tableView.setTableModel(tableModel);

        ImageIcon icon = loadImage("background.jpg");
        window.setBackground(icon);

        window.add(tableView);
    }

    private void play() throws Exception{
        Thread.sleep(1000);
        tableModel.setMark(1,1, Mark.X);
        Thread.sleep(1000);
        tableModel.setMark(0,0, Mark.O);
        Thread.sleep(1000);
        tableModel.setMark(0,1, Mark.X);
        Thread.sleep(1000);
        tableModel.setMark(2,1, Mark.O);
        Thread.sleep(1000);
        tableModel.setMark(2,0, Mark.X);
        Thread.sleep(1000);
        tableModel.setMark(0,2, Mark.O);
        Thread.sleep(1000);
        tableModel.setMark(1,0, Mark.X);
        Thread.sleep(1000);
        tableModel.setMark(1,2, Mark.O);
        Thread.sleep(1000);
        tableModel.setMark(2,2, Mark.X);
    }

    public static void main(String[] args) throws Exception{

        AppTableModelTableViewTest app = new AppTableModelTableViewTest();
        app.play();
    }
}
