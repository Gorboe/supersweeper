package controllers;

import core.CellMap;
import core.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TrioController implements Initializable {
    @FXML Canvas canvas;
    private static GraphicsContext gc;
    private static CellMap map;
    private static final int cellWidth = 20;
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
        System.out.println("initializing stuff in trio controller");
        gc = canvas.getGraphicsContext2D();
        map = new CellMap(cellWidth, cellHeight, "triangle");
        draw();
    }

    public static void draw(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0, Main.getPrimaryStage().getWidth(), Main.getPrimaryStage().getHeight());
        map.draw(gc);
    }

    public void handleRestart(){
        map = new CellMap(cellWidth, cellHeight, "triangle");
        draw();
    }

    public void handleMainMenu(){
        try{
            Main.changeScene("titleview.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleExitGame(){
        System.exit(0);
    }
}
