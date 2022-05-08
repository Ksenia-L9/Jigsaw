package lainex.jigsaw.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

import static lainex.jigsaw.view.GameView.CELL_SIZE;
import static lainex.jigsaw.view.GameView.FIELD_SIZE;

public class Field extends GridPane {
    public Field () {
        setPrefSize(FIELD_SIZE * CELL_SIZE, FIELD_SIZE * CELL_SIZE);
    }

    public void fillField(boolean[][] f) {
        for (int i = 0; i < FIELD_SIZE; ++i) {
            for (int j = 0; j < FIELD_SIZE; ++j) {
                Cell cell;

                if (i == 0 || j == 0 || i == 10 || j == 10) {
                    cell = new Cell(i, j, CELL_SIZE, Paint.valueOf("2A2A2D00"), Paint.valueOf("2A2A2D00"));
                } else {
                    if (f[i][j]) {
                        cell = new Cell(i, j, CELL_SIZE, Paint.valueOf("#ff0062"), Paint.valueOf("#51515d"));
                    } else {
                        cell = new Cell(i, j, CELL_SIZE, Paint.valueOf("#2a2a2d"), Paint.valueOf("#51515d"));
                    }
                }

                getChildren().add(cell);
            }
        }
    }
}
