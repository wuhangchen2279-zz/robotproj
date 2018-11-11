package com.daniel.cmd;

import com.daniel.robot.Robot;

/**
 * Right command to rotate robot to the right side
 */
public class RightCommand extends Command {
    /**
     * regex to match right command
     */
    public static final String CMD_REGEX = "RIGHT";

    /**
     * constructor for right command to initialize command with robot object
     * @param robot
     */
    public RightCommand(Robot robot) {
        super(robot);
    }

    /**
     * instruct robot to rotate to the right side.
     */
    @Override
    public void execute() {
        this.robot.right();
    }
}
