package com.daniel.cmd;

import com.daniel.robot.Robot;

/**
 * Move Command class to move robot one step forward
 */
public class MoveCommand extends Command {
    /**
     * Regex to match move command
     */
    public static final String CMD_REGEX = "MOVE";

    /**
     * Constructor for move command to initialize this command with robot object
     * @param robot
     */
    public MoveCommand(Robot robot) {
        super(robot);
    }

    /**
     * instruct robot to move one step forward
     */
    @Override
    public void execute() {
        this.robot.move();
    }
}
