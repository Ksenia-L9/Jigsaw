package lainex.jigsaw.model;

public class Game {
    private Integer moves = 0;
    private String time;
    private final Field field;

    public Game() {
        field = new Field();

    }

    /**
     * Tries to set a block to the field.
     *
     * @param block block to be set.
     * @param x     X coordinate, where to set.
     * @param y     Y coordinate, where to set.
     * @return true if set successfully, else false.
     */
    public boolean trySet(boolean[][] block, int x, int y) {
        if (field.ifFits(block, x, y)) {
            field.setBlock(block, x, y);
            ++moves;

            return true;
        }

        return false;
    }

    public boolean[][] getField() {
        return field.getField();
    }

    public Integer getMoves() {
        return moves;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
