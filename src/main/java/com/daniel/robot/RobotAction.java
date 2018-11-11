package com.daniel.robot;

/**
 * Interface to manage robot available action
 */
public interface RobotAction {
    /**
     * place command for robot
     * @param x robot x position
     * @param y robot y position
     * @param direction robot facing direction
     */
    void place(int x, int y, Direction direction);

    /**
     * rotate robot to right
     */
    void right();

    /**
     * rotate robot to left
     */
    void left();

    /**
     * move robot one step forward
     */
    void move();

    /**
     * report robot position and its facing direction.
     */
    void report();
}
