package com.daniel.robot;

import com.daniel.table.Table;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * unit testing for robot class
 */
public class RobotTest {
    /**
     * initialize a dummy robot that will move on 5*5 table
     */
    private Robot robot = new Robot(new Table(5,5));

    /**
     * test robot place command. A place command will place a robot at a position within
     * the table and specify its facing direction
     */
    @Test
    public void testPlace() {
        robot.place(1, 2, Direction.SOUTH);
        assert robot.getX() == 1;
        assert robot.getY() == 2;
        assert robot.getDirection() == Direction.SOUTH;
    }

    /**
     * test robot move command. A valid move command will move a robot one step forward
     * according to its facing direction
     */
    @Test
    public void testMove() {
        //horizontal move
        robot.place(1, 2, Direction.EAST);
        this.robot.move();
        assert this.robot.getX() == 2
                && this.robot.getY() == 2
                && this.robot.getDirection() == Direction.EAST;

        //vertical move
        robot.place(1, 2, Direction.NORTH);
        this.robot.move();
        assert this.robot.getX() == 1
                && this.robot.getY() == 3
                && this.robot.getDirection() == Direction.NORTH;
    }

    /**
     * test robot rotating left command. A valid left command will rotate a robot 90 degree on its left side.
     */
    @Test
    public void testLeft() {
        robot.place(0, 0, Direction.NORTH);
        this.robot.left();
        assert this.robot.getX() == 0
                && this.robot.getY() == 0
                && this.robot.getDirection() == Direction.WEST;
    }

    /**
     * test robot rotating right left command. A valid right command will rotate a robot 90 degree on its right side
     */
    @Test
    public void testRight() {
        robot.place(0, 0, Direction.NORTH);
        this.robot.right();
        assert this.robot.getX() == 0
                && this.robot.getY() == 0
                && this.robot.getDirection() == Direction.EAST;
    }

    /**
     * test robot report command. A valid report command will print out the robot current position and its
     * facing direction
     */
    @Test
    public void testReport() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        robot.place(0, 0, Direction.NORTH);
        robot.report();

        assert outContent.toString().equals("Output: 0,0,NORTH\n");
    }

    /**
     * if robot is not the table, the robot will ignore move command
     */
    @Test
    public void ignoreMoveIfNotOnTable() {
        this.robot.place(9,9, Direction.NORTH);
        this.robot.move();

        assert this.robot.getY() == 9;
    }

    /**
     * if robot is not the table, the robot will ignore rotate left command
     */
    @Test
    public void ignoreLeftIfNotOnTable() {
        this.robot.place(9,9, Direction.NORTH);
        this.robot.left();

        assert this.robot.getDirection() == Direction.NORTH;
    }

    /**
     * if robot is not the table, the robot will ignore rotate right command
     */
    @Test
    public void ignoreRightIfNotOnTable() {
        this.robot.place(9,9, Direction.NORTH);
        this.robot.right();

        assert this.robot.getDirection() == Direction.NORTH;
    }

    /**
     * if robot is not the table, the robot will ignore report command
     */
    @Test
    public void ignoreReportIfNotOnTable() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        this.robot.place(9,9, Direction.NORTH);
        this.robot.report();

        assert outContent.toString().equals("");
    }

    /**
     * ignore horizontal move which may cause robot move out of the table
     */
    @Test
    public void ignoreHorizontalMoveCmdCausingRobotFall() {
        this.robot.place(4, 0, Direction.EAST);
        this.robot.move();
        assert robot.getX() == 4 && robot.getY() == 0;
    }

    /**
     * ignore vertical move which may cause robot move out of the table
     */
    @Test
    public void ignoreVerticalMoveCmdCausingRobotFall() {
        this.robot.place(0, 4, Direction.NORTH);
        this.robot.move();
        assert robot.getY() == 4 && robot.getX() == 0;
    }
}
