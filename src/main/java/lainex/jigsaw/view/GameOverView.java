package lainex.jigsaw.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lainex.jigsaw.controller.GameController;
import lainex.jigsaw.controller.MenuButtonController;

public class GameOverView extends GridPane {
    public GameOverView(Stage stage) {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(25));
        setStyle("-fx-background-color: #2a2a2d");

        var columnConstraints = getColumnConstraints();
        for (int i = 0; i < 3; ++i) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);
            col.setPercentWidth(33.3);
            columnConstraints.add(col);
        }

        var rowConstraints = getRowConstraints();
        for (int i = 0; i < 4; ++i) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);
            row.setPercentHeight(25);
            rowConstraints.add(row);
        }

        Glow glow = new Glow();
        glow.setLevel(0.8);

        Label gameOver = new Label("GAME OVER");
        gameOver.setFont(Font.loadFont(getClass().getResourceAsStream("/Games.ttf"), 35));
        gameOver.setEffect(glow);
        gameOver.setStyle("-fx-text-fill: #ff0062");
        add(gameOver, 1, 0);
        setHalignment(gameOver, HPos.CENTER);

        Label moves = new Label("MOVES" + "  " + GameController.getMovesCount());
        moves.setFont(Font.loadFont(getClass().getResourceAsStream("/Games.ttf"), 30));
        moves.setStyle("-fx-text-fill: #002aff");
        add(moves, 0, 1);

        Label timePassed = new Label("TIME" + "  " + GameController.getTimePassed());
        timePassed.setFont(Font.loadFont(getClass().getResourceAsStream("/Games.ttf"), 30));
        timePassed.setStyle("-fx-text-fill: #002aff");
        add(timePassed, 0, 2);

        Button menu = new Button("MENU");
        menu.setSkin(new NeonButtonSkin(menu, 30, Color.DARKSLATEBLUE));
        menu.setStyle("-fx-background-color: #2a2a2d; " +
                "-fx-text-fill: #0015ff; " +
                "-fx-skin: \"lainex.jigsaw.view.NeonButtonSkin\";" +
                "-fx-shape: \"../src/main/resources/menuButtonShape.svg\"");
        add(menu, 2, 3);
        setHalignment(menu, HPos.RIGHT);

        menu.setOnAction(event -> stage.setScene(MenuButtonController.menu(stage)));
    }
}
