package lainex.jigsaw.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void trySetReturnsTrueOnValidBlock() {
        Game game = new Game();

        boolean[][] block = new boolean[3][3];
        block[0][1] = true;
        block[1][1] = true;
        block[2][1] = true;
        block[2][2] = true;

        int x = 6;
        int y = 5;

        assertTrue(() -> game.trySet(block, x, y));
    }

    @Test
    public void trySetReturnsFalseOnInvalidCoordinates() {
        Game game = new Game();

        boolean[][] block = new boolean[3][3];
        block[0][1] = true;
        block[1][1] = true;
        block[2][1] = true;
        block[2][2] = true;

        int x = 2;
        int y = 10;

        assertFalse(() -> game.trySet(block, x, y));
    }
}
