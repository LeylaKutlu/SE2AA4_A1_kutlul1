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

    public void readInputFile(String inputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                List<Character> row = new ArrayList<>(getWidth());

                if (line.isEmpty()) {
                    for (int i=0; i <getWidth(); i++) {
                        row.add(' ');
                    }
                } else {
                    for (char c: line.toCharArray()) {
                        row.add(c);
                    }
                }
                maze.add(row);
            }
            reader.close();
        } catch (IOException e) {
            logger.error("Error: " + e.getMessage());
        }
    }

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

    public boolean isClear(int row, int col) {
        if (row < 0 || row >= maze.size()) {
            return false;
        } else if (col < 0 || col >= maze.get(row).size()) {
            return false;
        }
        return maze.get(row).get(col) == ' ';
    }

    public int[] findEntry(Maze maze) { //include exception
        for (int row = 0; row < maze.getHeight(); row++) {
            if (maze.isClear(row, 0)) {
                return new int[]{row, 0};
            }
        }
        return null;
    } 
}