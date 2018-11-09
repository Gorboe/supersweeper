package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
    }
}
