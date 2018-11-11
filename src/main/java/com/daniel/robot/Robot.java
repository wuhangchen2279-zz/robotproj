package com.daniel.robot;

import com.daniel.table.Table;

/**
 * Robot class to store robot information and its behaviour
 */
public class Robot implements RobotAction {

    /**
     * robot x position on table
     */
    private int x;
    /**
     * robot y position on table
     */
    private int y;
    /**
     * robot facing direction
     */
    private Direction direction;
    /**
     * the table where robot stay
     */
    private Table table;

    /**
     * constructor for robot
     * @param table robot stays on this table
     */
    public Robot(Table table) {
        this.table = table;
    }

    /**
     * place a robot in x,y position facing to specific direction
     * @param x robot x position
     * @param y robot y position
     * @param direction robot facing direction
     */
    @Override
    public void place(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * rotate robot to right
     */
    @Override
    public void right() {
        //ignore this behaviour if robot is not on table.
        if(!this.isRobotOnTable()) return;
        this.direction = this.direction.turnRight();
    }

    /**
     * rotate robot to left
     */
    @Override
    public void left() {
        //ignore this behaviour if robot is not on table
        if(!this.isRobotOnTable()) return;
        this.direction = this.direction.turnLeft();
    }

    /**
     * move robot one step forward
     */
    @Override
    public void move() {
        //ignore this behaviour if robot is not on table
        if(!this.isRobotOnTable()) return;
        //move robot horizontally if direction is horizontal
        if(this.direction.isHorizontal()) {
            int tempX = this.x + this.direction.getDx();
            if(tempX >=0 && tempX < this.table.getWidth()) {
                this.x = tempX;
            }
        } else {
            //move robot vertically if direction is vertical
            int tempY = this.y + this.direction.getDy();
            if(tempY >=0 && tempY < this.table.getHeight()) {
                this.y = tempY;
            }
        }
    }

    /**
     * report the postion of robot and its facing direction.
     */
    @Override
    public void report() {
        //ignore this behaviour if robot is not on the table
        if(!this.isRobotOnTable()) return;
        System.out.println("Output: " + this.x + "," + this.y + "," + this.direction.name());
    }

    /**
     * check robot is on the table or not
     * @return flag to indicate if robot is on table
     */
    private boolean isRobotOnTable() {
        return this.x < this.table.getWidth() && this.x >=0 &&
                this.y < this.table.getHeight() && this.y >= 0;
    }

    /**
     * getter function to return robot x position
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * setter function to set robot x position
     * @param x x position of robot
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter function to return robot y position
     * @return robot y position
     */
    public int getY() {
        return y;
    }

    /**
     * setter function to set robot y position
     * @param y robot y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter function to return robot facing direction
     * @return robot facing direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * setter function to set robot facing direction
     * @param direction robot facing direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * get function to return the table where robot stays
     * @return the table where robot stays
     */
    public Table getTable() {
        return table;
    }

    /**
     * setter function to set the table where robot stays
     * @param table the table where robot stays
     */
    public void setTable(Table table) {
        this.table = table;
    }
}
