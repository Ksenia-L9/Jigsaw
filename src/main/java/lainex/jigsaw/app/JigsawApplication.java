package lainex.jigsaw.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lainex.jigsaw.view.MenuView;

import java.io.IOException;

public class JigsawApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("JigsawApp");
        stage.setResizable(false);
        Scene scene = new Scene(new MenuView(stage), 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}