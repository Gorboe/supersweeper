package controllers;

import core.CellMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassicController implements Initializable {
    @FXML Canvas canvas;
    private static GraphicsContext gc;
    private static CellMap map;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initializing stuff in classic controller");
        gc = canvas.getGraphicsContext2D();
        map = new CellMap(10, 10, "square");
        draw();
    }

    public static void draw(){
        map.draw(gc);
    }
}
