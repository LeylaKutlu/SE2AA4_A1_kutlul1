package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", "input", true, "Maze file to read");
        //options.addOption("p", "compare", true, "Path to compare");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);
            String inputFile = cmd.getOptionValue("i");
            //String comparePath = cmd.getOptionValue("p");

            if (inputFile == null) {
                logger.error("Please enter valid input file");
                return;
            }

            logger.debug("**** Reading the maze from file " + inputFile);
            Maze maze = new Maze();
            maze.readInputFile(inputFile);
            maze.outputMaze();

            //

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e.getMessage());
        }
    
        logger.info("** End of MazeRunner");

        //trace < debug < info < warn < error < fatal
    }
}
