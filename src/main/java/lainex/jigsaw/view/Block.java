package lainex.jigsaw.view;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class Block extends GridPane {
    private final boolean[][] container;

    public Block(boolean[][] block) {
        container = block;
        var cells = new Cell[block.length][block.length];

        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (block[i][j]) {
                    cells[i][j] = new Cell(i, j, GameView.CELL_SIZE,
                            Paint.valueOf("#00fff7"), Paint.valueOf("white"));
                } else {
                    cells[i][j] = new Cell(i, j, GameView.CELL_SIZE,
                            Paint.valueOf("2A2A2D00"), Paint.valueOf("2A2A2D00"));
                }

                getChildren().add(cells[i][j]);
            }
        }
    }

    public boolean[][] getContainer() {
        return container;
    }
}
