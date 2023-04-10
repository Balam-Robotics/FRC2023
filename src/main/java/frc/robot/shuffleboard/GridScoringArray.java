package frc.robot.shuffleboard;

public class GridScoringArray {
    private int[][] fieldArray = {
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //In Which colum is the robot in front of the grid
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //TOP ROW
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //MIDDLE ROW
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }  //BOTTOM ROW
    };

    public int[][] getFieldArray() {
        return fieldArray;
    }

    public void setFieldArray(int[][] fieldArray) {
        this.fieldArray = fieldArray;
    }
}
