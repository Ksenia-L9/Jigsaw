package lainex.jigsaw.model;

/**
 * Angle values for rotation (in degrees).
 */
public enum RotationAngle {
    ANGLE_90(1),
    ANGLE_180(2),
    ANGLE_270(3);

    private final int value;

    RotationAngle(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }
}
