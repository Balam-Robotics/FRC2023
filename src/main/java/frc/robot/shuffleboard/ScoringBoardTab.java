package frc.robot.shuffleboard;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants.ShuffleboardConstants;

public class ScoringBoardTab {
    private Shuffleboard m_Shuffleboard;
    private ShuffleboardTab m_ScoringBoardTab;

    private static ScoringBoardTab instance = null;

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
        // Create a new tab
        m_ScoringBoardTab = Shuffleboard.getTab(ShuffleboardConstants.kScoringBoardTab); 

        Shuffleboard.getTab(ShuffleboardConstants.kScoringBoardTab)
            .add("Test", false)
            .withSize(1, 1)
            .withPosition(0, 0)
            .getEntry();
        Shuffleboard.getTab(ShuffleboardConstants.kScoringBoardTab)
            .add("Test 2", false)
            .withSize(1, 1)
            .withPosition(0, 1)
            .getEntry();
    }

    public void update() {
        //TODO: Update the widgets on the tab
    }
}
