package lainex.jigsaw.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FieldTest {
    @Test
    public void ifFitsReturnsTrueOnValidBlock() {
        Field field = new Field();

        boolean[][] block = new boolean[3][3];
        block[0][1] = true;
        block[1][1] = true;
        block[2][1] = true;

        int x = 3;
        int y = 3;

        assertTrue(() -> field.ifFits(block, x, y));
    }

    @Test
    public void ifFitsReturnsFalseOnInvalidCoordinates() {
        Field field = new Field();

        boolean[][] block = new boolean[3][3];
        block[0][1] = true;
        block[1][1] = true;
        block[2][1] = true;
        block[2][2] = true;

        int x = 1;
        int y = 10;

        assertFalse(() -> field.ifFits(block, x, y));
    }
}
