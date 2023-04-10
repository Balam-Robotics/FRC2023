package frc.robot.shuffleboard;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants.ShuffleboardConstants;

public class ScoringBoardTab {
    private ShuffleboardTab m_ScoringBoardTab = Shuffleboard.getTab(ShuffleboardConstants.kScoringBoardTab);
    private static ScoringBoardTab instance = null;

    private GenericEntry[][] m_ScoringBoardEntries = new GenericEntry[9][4];
    private ShuffleboardLayout[] m_ScoringBoardColumnLayouts = new ShuffleboardLayout[9];

    private GridScoringArray m_GridScoringArray = GridScoringArray.getInstance();

    private ScoringBoardTab() {
        initShuffleboardTab();
    }

    public static ScoringBoardTab getInstance() {
        if (instance == null) {
            instance = new ScoringBoardTab();
        }
        return instance;
    }

    private void initShuffleboardTab() {
        for (int i = 0; i < 9; i++) {
            // create column header
            m_ScoringBoardEntries[i][0] = m_ScoringBoardTab
                    .add("" + (i + 1), false)
                    .withSize(1, 1)
                    .withPosition(i, 0)
                    .getEntry();

            // create column layout
            m_ScoringBoardColumnLayouts[i] = m_ScoringBoardTab.getLayout("Column " + (i + 1), BuiltInLayouts.kList)
                    .withSize(1, 3)
                    .withPosition(i, 1);

            // create entries for each row in the column
            for (int j = 1; j < 4; j++) {
                m_ScoringBoardEntries[i][j] = m_ScoringBoardColumnLayouts[i]
                        .add((j + "," + (i + 1)), false)
                        .withSize(1, 1)
                        .getEntry();
            }
        }
    }

    public void update() {
        // TODO: Update the widgets on the tab
        int[][] fieldArray = m_GridScoringArray.getFieldArray();

        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 4; j++) {
                m_ScoringBoardEntries[i][j].setBoolean(fieldArray[j][i] == 1);
            }
            m_ScoringBoardEntries[i][0].setBoolean(fieldArray[0][i] == 1);
        }
    }
}
