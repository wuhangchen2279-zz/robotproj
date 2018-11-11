package com.daniel.cmd;

import com.daniel.robot.Robot;

/**
 * Abstract Command Class, extended by all Command Classes
 */
public abstract class Command {
    /**
     * reference to the robot which will receive commands
     */
    protected Robot robot;

    /**
     * Command Constructor to initialize Command with Robot object
     * @param robot robot object passed into the Command Constructor
     */
    public Command(Robot robot) {
        this.robot = robot;
    }

    /**
     * Execute a command for once, which will be implemented by Command Child classes.
     */
    public abstract void execute();
}
