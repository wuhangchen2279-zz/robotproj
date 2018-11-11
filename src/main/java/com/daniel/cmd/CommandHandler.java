package com.daniel.cmd;

import com.daniel.robot.Direction;
import com.daniel.robot.Robot;

import java.util.ArrayList;
import java.util.List;


/**
 * Command Handler class to manage a list of commands
 */
public class CommandHandler {
    /**
     * a list of commands to manage
     */
    private List<Command> cmdList = new ArrayList<>();
    /**
     * a flag to identify if the first valid command is read
     */
    private boolean startAddCmd = false;
    /**
     * reference to the robot which will receive commands
     */
    private Robot robot;

    /**
     * Constructor for CommandHandler allowing to initialize with robot object
     * @param robot
     */
    public CommandHandler(Robot robot) {
        this.robot = robot;
    }

    /**
     * add new command string into the command list
     * @param cmdStr string format of command received from user input
     */
    public void addCommand(String cmdStr) {
        Command cmd = null;

        //Try to match place command with place command regex(eg: PLACE 1,1,NORTH).
        if(cmdStr.matches(PlaceCommand.CMD_REGEX)) {
            String[] robotInfo = cmdStr.split(" ")[1].split(",");
            //x position for robot decided by place command
            int xPos = Integer.parseInt(robotInfo[0]);
            //y position for robot decided by place command
            int yPos = Integer.parseInt(robotInfo[1]);

            //first valid place command must place robot within the table.
            if(xPos >=0 && yPos >=0
                && xPos < this.robot.getTable().getWidth()
                && yPos < this.robot.getTable().getHeight()) {
                cmd = new PlaceCommand(robot, xPos, yPos, Direction.valueOf(robotInfo[2]));

                //After first valid place command is read successfully, set startAddCmd flag to be true
                if (!startAddCmd) {
                    startAddCmd = true;
                }
            }
        }
        //After first valid place command is found, other commands can be added to command list
        if(startAddCmd) {
            switch(cmdStr) {
                case MoveCommand.CMD_REGEX:
                    cmd = new MoveCommand(robot);
                    break;
                case LeftCommand.CMD_REGEX:
                    cmd = new LeftCommand(robot);
                    break;
                case RightCommand.CMD_REGEX:
                    cmd = new RightCommand(robot);
                    break;
                case ReportCommand.CMD_REGEX:
                    cmd = new ReportCommand(robot);
                    break;
                default:
                    // Invalid Command! Ignored
                    break;
            }
        }
        if(cmd != null) {
            cmdList.add(cmd);
        }
    }

    /**
     * execute all available commands in the command list
     */
    public void executeCommands() {
        for(Command cmd : cmdList) {
            cmd.execute();
        }
        cmdList.clear();
        startAddCmd = false;
    }

    public List<Command> getCmdList() {
        return cmdList;
    }

    public Robot getRobot() {
        return robot;
    }
}
