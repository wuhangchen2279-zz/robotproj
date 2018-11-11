package com.daniel.reader;

import com.daniel.cmd.CommandHandler;

/**
 * Abstract reader class to read commands from user input
 */
public abstract class Reader {
    /**
     * reference to command handler to use manage commands while reading the user input
     */
    protected CommandHandler cmdHandler;

    /**
     * constructor for reader to initialize reader with command handler object
     * @param cmdHandler reference to the command handler
     */
    public Reader(CommandHandler cmdHandler) {
        this.cmdHandler = cmdHandler;
    }

    /**
     * abstract function to read user input
     */
    public abstract void read();
}
