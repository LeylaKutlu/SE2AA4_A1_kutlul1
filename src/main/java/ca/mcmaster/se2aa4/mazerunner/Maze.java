package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    protected List<List<Character>> maze = new ArrayList<>();

    //

    public void outputMaze() throws Exception {
        for (List<Character> row: maze) {
            for (char c: row) {
                if (c == ' ') {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    public List<List<Character>> getMaze() {
        return maze;
    }

    public int getHeight() {
        return maze.size();
    }

    public int getWidth() {
        if (maze.isEmpty()) {
            return 0;
        } else {
            List<Character> firstRow = maze.get(0);
            int width = firstRow.size();
            return width;
        }
    }

    //
}