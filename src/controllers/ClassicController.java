package controllers;

import core.CellMap;
import core.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassicController implements Initializable {
    @FXML Canvas canvas;
    private static GraphicsContext gc;
    private static CellMap map;
    private static final int cellWidth = 10;
    private static final int cellHeight = 10;

    public static CellMap getMap() {
        return map;
    }

    public static int getCellHeight() {
        return cellHeight;
    }

    public static int getCellWidth() {
        return cellWidth;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initializing stuff in classic controller");
        gc = canvas.getGraphicsContext2D();
        map = new CellMap(cellWidth, cellHeight, "square");
        draw();
    }

    public static void draw(){
        map.draw(gc);
    }
}
