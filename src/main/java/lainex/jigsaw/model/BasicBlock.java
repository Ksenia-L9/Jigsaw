package lainex.jigsaw.model;

/**
 * Basic types of blocks.
 */
public enum BasicBlock {
    DOT(0),
    I_BLOCK(1),
    Z_BLOCK(3),
    S_BLOCK(5),
    J_BLOCK(7),
    L_BLOCK(11),
    T_BLOCK(15),
    SMALL_J_BLOCK(19),
    SMALL_T_BLOCK(23),
    ANGLE_BLOCK(27);

    private final int value;

    BasicBlock(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }
}
