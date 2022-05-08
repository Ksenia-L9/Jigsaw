package lainex.jigsaw.view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Cell extends StackPane {
    private final int x;
    private final int y;
    private final Rectangle cell;

    public Cell(int x, int y, int cellSize, Paint background, Paint stroke) {
        this.x = x;
        this.y = y;

        setTranslateX(x * cellSize);
        setTranslateY(y * cellSize);

        cell = new Rectangle(cellSize, cellSize, background);
        cell.setStroke(stroke);

        getChildren().add(cell);
    }
}
