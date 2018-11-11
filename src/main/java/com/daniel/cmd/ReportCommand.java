package com.daniel.cmd;

import com.daniel.robot.Robot;

/**
 * Report Command to report the position and facing direction information of robot
 */
public class ReportCommand extends Command {
    /**
     * regex to match report command
     */
    public static final String CMD_REGEX = "REPORT";

    /**
     * constructor for report command to initialize report command with robot object
     * @param robot the robot on the table
     */
    public ReportCommand(Robot robot) {
        super(robot);
    }

    /**
     * instruct the robot to report its position and facing direction information
     */
    @Override
    public void execute() {
        this.robot.report();
    }
}
