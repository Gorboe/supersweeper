package core;

import controllers.ClassicController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Stage primaryStage;
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        changeScene("titleview.fxml");
    }

    public static void changeScene(String sceneName) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/views/" + sceneName));
        GridPane root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        primaryStage.setTitle("SuperSweeper");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnMouseClicked(Main::mouseClickedEvent);
    }

    public static void mouseClickedEvent(MouseEvent e){
        Cell[][] cells = ClassicController.getMap().getCells();
        for(int i = 0; i < ClassicController.getCellWidth(); i++){
            for(int j = 0; j < ClassicController.getCellHeight(); j++){
                if(e.getX() > cells[j][i].getPosX() && e.getX() < cells[j][i].getPosX() + cells[j][i].getWidth()
                        && e.getY() > cells[j][i].getPosY() && e.getY() < cells[j][i].getPosY() + cells[j][i].getHeight()){
                    if(cells[j][i].isBomb()){
                        ClassicController.getMap().handleGameOver();
                    }
                    cells[j][i].setRevealed(true);
                    if(cells[j][i].getNeighbors() == 0){
                        ClassicController.getMap().flowEmptyTiles(j, i);
                    }
                    ClassicController.draw();
                }
            }
        }
    }
}
