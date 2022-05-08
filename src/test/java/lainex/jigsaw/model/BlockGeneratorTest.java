package lainex.jigsaw.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BlockGeneratorTest {
    @Test
    public void generateDoesNotThrowExceptions() {
        assertDoesNotThrow(() -> {
            BlockGenerator.generateBlock();
        });
    }
}
