package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.List;
import java.util.ArrayList;

public class Path {
    private static final Logger logger = LogManager.getLogger();
    protected String outputPath;

    public String pathFinder(Maze maze) throws Exception{
        StringBuilder path = new StringBuilder();
        int[] entry = maze.findEntry(maze);

        if (entry == null) {
            throw new Exception("No entry");
        }

        Compass compass = new Compass(entry[0], entry[1], 1);
        
        while (true) {
            int[] coord = compass.getCoordinates();
            int row = coord[0];
            int col = coord[1];

            if (col == maze.getWidth() - 1 && maze.isClear(row, col)) {
                path.append("F"); //Exit
                break;
            }

            boolean rightWall = maze.isClear(row, col + 1);

            if (!rightWall) {
                compass.turnRight();
                path.append("R");
                compass.moveForward();
                path.append("F");
            } else {
                compass.moveForward();
                path.append("F");
            }
        }

        return path.toString();
    }

}