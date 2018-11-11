package com.daniel.cmd;

import com.daniel.robot.Robot;

/**
 * LeftCommand class to rotate robot to left side
 */
public class LeftCommand extends Command {
    /**
     * Regex to match Left Command
     */
    public static final String CMD_REGEX = "LEFT";

    /**
     * constructor for Left Command to initialize this command with robot
     * @param robot robot on the table
     */
    public LeftCommand(Robot robot) {
        super(robot);
    }

    /**
     * tell robot to rotate left side
     */
    @Override
    public void execute() {
        this.robot.left();
    }
}
