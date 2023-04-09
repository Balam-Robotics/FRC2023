//First row represents the distance from the grid, 
//and the second row represents the angle to which the 
//intake should be set in order to score the cube in 
//whathever row you want.

package frc.robot.actions.autoActions.scoreCubes;

public class CubeScoringTable {
    public enum CubeScoringTableRow {
        MIDDLE_ROW,
        TOP_ROW
    }

    private final double[][] m_MiddleRow = {
            { 0, 0 },
            { 5, 2 },
            { 10, 4 },
            { 15, 6 },
            { 20, 8 },
            { 25, 10 },
            { 30, 12 },
            { 35, 14 },
            { 40, 16 }
    };

    private final double[][] m_TopRow = {
            { 0, 0 },
            { 5, 2 },
            { 10, 4 },
            { 15, 6 },
            { 20, 8 },
            { 25, 10 },
            { 30, 12 },
            { 35, 14 },
            { 40, 16 }
    };

    public double[][] getScoringTable(CubeScoringTableRow row) {
        switch (row) {
            case MIDDLE_ROW:
                return m_MiddleRow;
            case TOP_ROW:
                return m_TopRow;
            default:
                return null;
        }
    }
}
