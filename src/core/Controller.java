package core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initializing stuff in controller");
    }
}
