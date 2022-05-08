package lainex.jigsaw.model;

import java.util.Random;

/**
 * Generator of blocks.
 */
public class BlockGenerator {
    private static final int SIZE = 3;
    private static final Random RND = new Random();

    /**
     * Generates random block.
     * @return block
     */
    public static boolean[][] generateBlock() {
        boolean[][] block = new boolean[SIZE][SIZE];
        int rnd = RND.nextInt(31);

        if (rnd == BasicBlock.DOT.getValue()) {
            block[1][1] = true;
        } else if (rnd >= BasicBlock.I_BLOCK.getValue() && rnd < BasicBlock.Z_BLOCK.getValue()) {
            getI(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.I_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.Z_BLOCK.getValue() && rnd < BasicBlock.S_BLOCK.getValue()) {
            getZ(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.Z_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.S_BLOCK.getValue() && rnd < BasicBlock.J_BLOCK.getValue()) {
            getS(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.S_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.J_BLOCK.getValue() && rnd < BasicBlock.L_BLOCK.getValue()) {
            getJ(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.J_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.L_BLOCK.getValue() && rnd < BasicBlock.T_BLOCK.getValue()) {
            getL(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.L_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.T_BLOCK.getValue() && rnd < BasicBlock.SMALL_T_BLOCK.getValue()) {
            getT(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.T_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.SMALL_T_BLOCK.getValue() && rnd < BasicBlock.SMALL_J_BLOCK.getValue()) {
            getSmallT(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.SMALL_T_BLOCK, rnd);
            }
        } else if (rnd >= BasicBlock.SMALL_J_BLOCK.getValue()) {
            getSmallJ(block);

            if (rnd % 2 != 0) {
                getRotation(block, BasicBlock.SMALL_J_BLOCK, rnd);
            }
        }

        return block;
    }

    /**
     * Defines the angle of rotation.
     * @param block block to rotate.
     * @param type type of block.
     * @param rnd random number, needed to define the angle.
     */
    private static void getRotation(boolean[][] block, BasicBlock type, int rnd) {
        if (type == BasicBlock.S_BLOCK ||
                type == BasicBlock.Z_BLOCK ||
                type == BasicBlock.I_BLOCK) {
            rotate(block);
        } else {
            if (rnd % 4 == RotationAngle.ANGLE_90.getValue()) {
                rotate(block);
            } else if (rnd % 4 == RotationAngle.ANGLE_180.getValue()) {
                rotate(block);
                rotate(block);
            } else if (rnd % 4 == RotationAngle.ANGLE_270.getValue()) {
                rotate(block);
                rotate(block);
                rotate(block);
            }
        }
    }

    /**
     * Rotates block by 90 degrees anti-clockwise.
     * @param block block to rotate.
     */
    private static void rotate(boolean[][] block) {
        for (int i = 0; i < block.length / 2; ++i) {
            for (int j = 0; j < block.length - i - 1; ++j) {
                boolean curr = block[i][j];
                block[i][j] = block[j][block.length - i - 1];
                block[j][block.length - i - 1] = block[block.length - i - 1][block.length - j - 1];
                block[block.length - i - 1][block.length - j - 1] = block[block.length - j - 1][i];
                block[block.length - j - 1][i] = curr;
            }
        }
    }

    /**
     * Creates block "I".
     * @param block container for new block.
     */
    private static void getI(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (j == 1) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "Z".
     * @param block container for new block.
     */
    private static void getZ(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (i == 1 && j != 2) {
                    block[i][j] = true;
                }

                if (i == 2 && j != 0) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "S".
     * @param block container for new block.
     */
    private static void getS(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (i == 1 && j != 0) {
                    block[i][j] = true;
                }

                if (i == 2 && j != 2) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "J".
     * @param block container for new block.
     */
    private static void getJ(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (j == 1) {
                    block[i][j] = true;
                }

                if (i == 2 && j == 0) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "L".
     * @param block container for new block.
     */
    private static void getL(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (j == 1) {
                    block[i][j] = true;
                }

                if (i == 2 && j == 2) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "T".
     * @param block container for new block.
     */
    private static void getT(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (i == 0 || j == 1) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "small T".
     * @param block container for new block.
     */
    private static void getSmallT(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (i == 0) {
                    block[i][j] = true;
                }

                if (i == 1 && j == 1) {
                    block[i][j] = true;
                }
            }
        }
    }

    /**
     * Creates block "small J".
     * @param block container for new block.
     */
    private static void getSmallJ(boolean[][] block) {
        for (int i = 0; i < block.length; ++i) {
            for (int j = 0; j < block.length; ++j) {
                if (i == 1 && j != 0) {
                    block[i][j] = true;
                }

                if (i == 2 && j == 2) {
                    block[i][j] = true;
                }
            }
        }
    }
}
