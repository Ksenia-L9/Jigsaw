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
import lainex.jigsaw.controller.GameController;

public class GameView extends GridPane {
    public static final int FIELD_SIZE = 11;
    public static final int CELL_SIZE = 40;
    private final Field field;

    private final GameController gameController;

    private final StopWatch stopwatch;

    private Block block;

    private double currX;
    private double currY;
    private double newX;
    private double newY;

    public GameView(Stage stage) {
        gameController = new GameController();

        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));
        setStyle("-fx-background-color: #2a2a2d");

        var columnConstraints = getColumnConstraints();
        for (int i = 0; i < 3; ++i) {
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.ALWAYS);

            if (i == 1) {
                col.setPercentWidth(60);
            } else {
                col.setPercentWidth(20);
            }

            columnConstraints.add(col);
        }

        var rowConstraints = getRowConstraints();
        for (int i = 0; i < 3; ++i) {
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.ALWAYS);

            if (i == 0) {
                row.setPercentHeight(10);
            } else if (i == 1) {
                row.setPercentHeight(65);
            } else {
                row.setPercentHeight(25);
            }

            rowConstraints.add(row);
        }

        stopwatch = new StopWatch();
        add(stopwatch, 0, 0);
        setHalignment(stopwatch, HPos.CENTER);
        stopwatch.start();

        Button end = new Button("END");
        end.setSkin(new NeonButtonSkin(end, 35, Color.MEDIUMAQUAMARINE));
        end.setStyle("-fx-background-color: #2a2a2d; " +
                "-fx-text-fill: #00ffff; " +
                "-fx-skin: \"lainex.jigsaw.view.NeonButtonSkin\";" +
                "-fx-shape: \"../src/main/resources/endButtonShape.svg\"");
        add(end, 2, 0);
        setHalignment(end, HPos.CENTER);

        field = new Field();
        field.fillField(gameController.getField());
        add(field, 1, 1);

        block = new Block(gameController.getRandomBlock());
        add(block, 1, 2);

        dragDropBlock(block);

        end.setOnAction(event -> {
            stopwatch.stop();
            GameController.setTimePassed(stopwatch.getTime().getText());
            stage.setScene(gameController.end(stage));
        });
    }

    private void dragDropBlock(Block b) {
        b.setOnMousePressed(event -> {
            currX = event.getSceneX() - b.getTranslateX();
            currY = event.getSceneY() - b.getTranslateY();
        });

        b.setOnMouseDragged(event -> {
            b.setTranslateX(event.getSceneX() - currX);
            b.setTranslateY(event.getSceneY() - currY);
        });

        b.setOnMouseReleased(event -> {
            newX = event.getSceneX();
            newY = event.getSceneY();

            if (newX < field.getLayoutX() || newX > field.getLayoutX() + field.getWidth()
                    || newY < field.getLayoutY() || newY > getLayoutY() + field.getHeight()) {
                b.setTranslateX(0);
                b.setTranslateY(0);
            } else {
                if (!gameController.trySetBlock(b.getContainer(),
                        (int) ((newX - field.getLayoutX()) / CELL_SIZE - event.getX() / CELL_SIZE),
                        (int) ((newY - field.getLayoutY()) / CELL_SIZE - event.getY() / CELL_SIZE))) {
                    b.setTranslateX(0);
                    b.setTranslateY(0);
                } else {
                    getChildren().remove(block);

                    field.fillField(gameController.getField());

                    block = new Block(gameController.getRandomBlock());
                    add(block, 1, 2);

                    dragDropBlock(block);
                }
            }
        });
    }
}
