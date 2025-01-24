package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.List;
import java.util.ArrayList;

public class Compass {
    private static final Logger logger = LogManager.getLogger();
    protected int row;
    protected int col;
    protected int direction;
    private static final int[][] DIRECTIONS = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public Compass(int initialRow, int initialCol, int initialDirection) {
        this.row = initialRow;
        this.col = initialCol;
        this.direction = initialDirection;
    }

    public int[] getCoordinates() {
        return new int[]{row, col};
    }

    public int[] getDirection() {
        return DIRECTIONS[direction];
    }

    public void moveForward() {
        row += DIRECTIONS[direction][0];
        col += DIRECTIONS[direction][1];
    }

    public void turnRight() {
    }
}