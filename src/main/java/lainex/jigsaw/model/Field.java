package lainex.jigsaw.model;

/**
 * Jigsaw playing field.
 */
public class Field {
    private final boolean[][] field;

    public Field() {
        field = new boolean[11][11];
    }

    /**
     * Sets the block to the field.
     *
     * @param block block to be set.
     * @param x     X coordinate, where to place.
     * @param y     Y coordinate, where to place.
     */
    public void setBlock(boolean[][] block, int x, int y) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (block[i][j]) {
                    field[x + i][y + j] = block[i][j];
                }
            }
        }
    }

    /**
     * Checks if block fits to place it was dragged.
     *
     * @param block block to be placed
     * @param x     X coordinate, where the block was dragged.
     * @param y     Y coordinate, where the block was dragged.
     * @return true if fits, else false.
     */
    public boolean ifFits(boolean[][] block, int x, int y) {
        if (x == 0 || y == 0 || x == 10 || y == 10) {
            return false;
        }

        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (block[i][j] && field[x + i][y + j])
                    return false;
            }
        }

        return true;
    }

    public boolean[][] getField() {
        return field;
    }
}
