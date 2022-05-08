package lainex.jigsaw.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lainex.jigsaw.controller.MenuController;

public class MenuView extends GridPane {
    public MenuView(Stage stage) {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(0));
        setStyle("-fx-background-color: #2a2a2d");

        var columnConstraints = getColumnConstraints();
        for (int i = 0; i < 2; ++i) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            col.setPercentWidth(50);
            columnConstraints.add(col);
        }

        var rowConstraints = getRowConstraints();
        for (int i = 0; i < 1; ++i) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            row.setPercentHeight(100);
            rowConstraints.add(row);
        }

        Button start = new Button("START");
        start.setSkin(new NeonButtonSkin(start, 55, Color.BLUEVIOLET));
        start.setStyle("-fx-background-color: #2a2a2d; " +
                "-fx-text-fill: #9900ff;" +
                "-fx-skin: \"lainex.jigsaw.view.NeonButtonSkin\";" +
                "-fx-shape: \"../src/main/resources/startButtonShape.svg\"");
        add(start, 0, 0);
        setHalignment(start, HPos.CENTER);

        Button quit = new Button("QUIT");
        quit.setSkin(new NeonButtonSkin(quit, 55, Color.YELLOWGREEN));
        quit.setStyle("-fx-background-color: #2a2a2d; " +
                "-fx-text-fill: #eefb00;" +
                "-fx-skin: \"lainex.jigsaw.view.NeonButtonSkin\";" +
                "-fx-shape: \"../src/main/resources/quitButtonShape.svg\"");

        add(quit, 1, 0);
        setHalignment(quit, HPos.CENTER);

        start.setOnAction(event -> stage.setScene(MenuController.start(stage)));
        quit.setOnAction(event -> stage.close());
    }
}
