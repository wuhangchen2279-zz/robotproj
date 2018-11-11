package com.daniel.cmd;

import com.daniel.robot.Direction;
import com.daniel.robot.Robot;
import com.daniel.table.Table;
import org.junit.Test;

/**
 * Unit testing for command handler
 */
public class CommandHandlerTest {
    /**
     * initialize a dummy command handler, which will work with a robot moving on 5*5 table.
     */
    private CommandHandler cmdHandler =
            new CommandHandler(new Robot(new Table(5,5)));

    /**
     * the first valid command must be place command
     */
    @Test
    public void firstValidCommandIsPlace() {
        this.cmdHandler.addCommand("REPORT");
        this.cmdHandler.addCommand("MOVE");
        this.cmdHandler.addCommand("LEFT");
        this.cmdHandler.addCommand("RIGHT");
        this.cmdHandler.addCommand("PLACE 1,1,NORTH");

        assert this.cmdHandler.getCmdList().size() == 1
                && this.cmdHandler.getCmdList().get(0) instanceof PlaceCommand;
    }

    /**
     * the initial place command must be on the table
     */
    @Test
    public void firstValidPlaceCmdMustBeOnTable() {
        this.cmdHandler.addCommand("PLACE 9,9,NORTH");

        assert this.cmdHandler.getCmdList().size() == 0;
    }

    /**
     * After we have the first valid place command, any other commands can be entered in any sequence.
     */
    @Test
    public void firstValidCmdFollowedByAnySequenceCmd() {
        this.cmdHandler.addCommand("PLACE 1,2,NORTH");
        this.cmdHandler.addCommand("MOVE");
        this.cmdHandler.addCommand("RIGHT");
        this.cmdHandler.addCommand("LEFT");
        this.cmdHandler.addCommand("MOVE");

        assert this.cmdHandler.getCmdList().size() == 5
                && this.cmdHandler.getCmdList().get(0) instanceof PlaceCommand
                && ((PlaceCommand) this.cmdHandler.getCmdList().get(0)).getX() == 1
                && ((PlaceCommand) this.cmdHandler.getCmdList().get(0)).getY() == 2
                && ((PlaceCommand) this.cmdHandler.getCmdList().get(0)).getDirection() == Direction.NORTH
                && this.cmdHandler.getCmdList().get(1) instanceof MoveCommand
                && this.cmdHandler.getCmdList().get(2) instanceof RightCommand
                && this.cmdHandler.getCmdList().get(3) instanceof LeftCommand
                && this.cmdHandler.getCmdList().get(4) instanceof MoveCommand;
    }

    /**
     * multiple place commands can be accepted
     */
    @Test
    public void supportMoreThanOnePlaceCmds() {
        this.cmdHandler.addCommand("PLACE 2,2,NORTH");
        this.cmdHandler.addCommand("PLACE 1,1,NORTH");

        assert this.cmdHandler.getCmdList().size() == 2
                && this.cmdHandler.getCmdList().get(0) instanceof PlaceCommand
                && this.cmdHandler.getCmdList().get(1) instanceof PlaceCommand;


    }
}
