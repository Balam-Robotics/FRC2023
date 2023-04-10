package frc.robot.shuffleboard;

public class GridScoringArray {
    private int[][] fieldArray = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // In Which colum is the robot in front of the grid
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // TOP ROW
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // MIDDLE ROW
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 } // BOTTOM ROW
    };

    // Private constructor to prevent instantiation outside of the class
    private GridScoringArray() {
    }

    // Static instance variable
    private static GridScoringArray instance;

    // Getter method for the static instance variable
    public static GridScoringArray getInstance() {
        if (instance == null) {
            instance = new GridScoringArray();
        }
        return instance;
    }

    public int[][] getFieldArray() {
        return fieldArray;
    }

    public void setFieldArray(int[][] fieldArray) {
        this.fieldArray = fieldArray;
    }
}