package com.daniel.robot;

/**
 * Enumeration Object to store North, East, South, and West direction
 */
public enum Direction {

    // use magic numbers to set the ordinal (used for rotation),
    // and the dx and dy of each direction.
    NORTH(0, 0, 1),
    EAST(1, 1, 0),
    SOUTH(2, 0, -1),
    WEST(3, -1, 0);

    /**
     * index to indicate the direction after rotate robot to right/lft
     */
    private final int rightTurnIndex, leftTurnIndex;
    /**
     * the x, y distance change after moving object to specific direction
     */
    private final int dx, dy;
    /**
     * flag to check if the direction is horizontal or not.
     */
    private final boolean horizontal;

    /**
     * constructor of direction enum
     * @param ordinal ordinal of direction
     * @param dx x distance change of direction
     * @param dy y distance change of direction
     */
    private Direction(int ordinal, int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.horizontal = dx != 0;
        this.rightTurnIndex  = (ordinal + 1) % 4;
        this.leftTurnIndex = (ordinal + 3) % 4;
    }

    /**
     * get object's direction after rotating right
     * @return current direction after rotating right
     */
    public Direction turnRight() {
        return values()[rightTurnIndex];
    }

    /**
     * get object's direction after rotating left
     * @return current direction after rotating left
     */
    public Direction turnLeft() {
        return values()[leftTurnIndex];
    }

    /**
     * check if direction is horizontal or not
     * @return horizontal direction or not
     */
    public Boolean isHorizontal() {
        return horizontal;
    }

    /**
     * getter function for dx
     * @return x distance
     */
    public int getDx() {
        return dx;
    }

    /**
     * get function for dy
     * @return y distance
     */
    public int getDy() {
        return dy;
    }
}
