package com.daniel;

import com.daniel.cmd.CommandHandler;
import com.daniel.reader.CmdFileReader;
import com.daniel.reader.Reader;
import com.daniel.robot.Robot;
import com.daniel.table.Table;

public class App {
    //main method to run toy robot program
    public static void main(String[] args) {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);
        CommandHandler cmdHandler = new CommandHandler(robot);
        Reader reader = new CmdFileReader(cmdHandler);
        reader.read();
        cmdHandler.executeCommands();
    }
}
