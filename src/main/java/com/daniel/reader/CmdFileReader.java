package com.daniel.reader;

import com.daniel.cmd.CommandHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Command File reader class which read user command input from file
 */
public class CmdFileReader extends Reader {

    /**
     * the location for input file
     */
    private static final String FILENAME = "input.txt";

    /**
     * Constructor for Command Handler to initialize Command file Reader
     * @param cmdHandler command handler object to manage command list.
     */
    public CmdFileReader(CommandHandler cmdHandler) {
        super(cmdHandler);
    }

    /**
     * read the commands in string format from file, and add them to command list
     */
    @Override
    public void read() {
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                cmdHandler.addCommand(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
