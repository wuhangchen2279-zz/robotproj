package com.daniel.cmd;

import com.daniel.robot.Direction;
import com.daniel.robot.Robot;

/**
 * Place command to place robot on a table.
 */
public class PlaceCommand extends Command {
    /**
     * x positon on the table
     */
    private int x;
    /**
     * y position on the table
     */
    private int y;
    /**
     * the direction where the robot face
     */
    private Direction direction;
    /**
     * regex to match place command
     */
    public static final String CMD_REGEX = "^PLACE\\s(([1-9]\\d*)|0),(([1-9]\\d*)|0),(WEST|NORTH|EAST|SOUTH)$";

    /**
     * Constructor for place command
     * @param robot robot to set its position on table
     * @param x x position on the table
     * @param y y position on the table
     * @param direction direction which the robot face to
     */
    public PlaceCommand(Robot robot, int x, int y, Direction direction) {
        super(robot);
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * place robot on a position of table.
     */
    @Override
    public void execute() {
        this.robot.place(this.x, this.y, this.direction);
    }

    /**
     * getter for x position
     * @return x position
     */
    public int getX() {
        return x;
    }

    /**
     * setter for x position
     * @param x x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter for y position
     * @return y position
     */
    public int getY() {
        return y;
    }

    /**
     * setter for y position
     * @param y y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter for robot facing direction
     * @return robot facing direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * setter for robot facing direction
     * @param direction robot facing direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
