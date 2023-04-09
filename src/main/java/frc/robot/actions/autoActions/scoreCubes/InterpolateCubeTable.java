package frc.robot.actions.autoActions.scoreCubes;

import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;

public class InterpolateCubeTable {

    public static double interpolate(double distance, CubeScoringTableRow row) {
        double[][] table = new CubeScoringTable().getScoringTable(row);

        // Find the two rows of the table that surround the distance we want to
        // interpolate for
        int i = 0;
        while (i < table.length && table[i][0] < distance) {
            i++;
        }
        if (i == 0) {
            // Distance is smaller than the smallest distance in the table, interpolate with
            // the first two values
            return interpolateLinear(distance, table[0][0], table[1][0], table[0][1], table[1][1]);
        } else if (i == table.length) {
            // Distance is larger than the largest distance in the table, interpolate with
            // the last two values
            return interpolateLinear(distance, table[i - 2][0], table[i - 1][0], table[i - 2][1], table[i - 1][1]);
        } else {
            // Distance is between two values in the table, interpolate with those values
            return interpolateLinear(distance, table[i - 1][0], table[i][0], table[i - 1][1], table[i][1]);
        }
    }

    private static double interpolateLinear(double x, double x1, double x2, double y1, double y2) {
        return y1 + (x - x1) * (y2 - y1) / (x2 - x1);
    }
}
