package frc.robot.actions.autoActions;

import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;
import frc.robot.subsystem.IntakeSubsystem;
import frc.robot.subsystem.IntakeSubsystem.ReachableRows;

public class AutoAimIntakeAction {
    private final IntakeSubsystem m_IntakeSubsystem;

    public AutoAimIntakeAction(IntakeSubsystem intakeSubsystem) {
        m_IntakeSubsystem = intakeSubsystem;
        // m_IntakeSubsystem.resetEncoder(m_IntakeSubsystem.getEncoder(), 0.0);
    }

    public void execute() {
        ReachableRows reachableRows = m_IntakeSubsystem.getReachableRows();
        if (reachableRows == ReachableRows.TOP_ROW) {
            m_IntakeSubsystem.setIntakeDegrees(m_IntakeSubsystem.getAngleForScoring(CubeScoringTableRow.TOP_ROW));
            // TODO: Add feedback to shuffleboard
        } else {
            m_IntakeSubsystem.setIntakeDegrees(0.0);
            // TODO: Add feedback to shuffleboard
        }
    }
}