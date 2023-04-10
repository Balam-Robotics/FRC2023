package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.IntakeSubsystem;
import frc.robot.subsystem.IntakeSubsystem.ReachableRows;

public class AimIntakeAction {
    private final XboxController m_XboxController;
    private final IntakeSubsystem m_IntakeSubsystem;

    public AimIntakeAction(IntakeSubsystem intakeSubsystem) {
        m_XboxController = GlobalSubsystemDevices.getXboxController();
        m_IntakeSubsystem = intakeSubsystem;
    }

    // TODO: Check xbox controller buttons mapping
    public void execute() {
        ReachableRows reachableRows = m_IntakeSubsystem.getReachableRows();
        if (m_XboxController.getAButton() && reachableRows == ReachableRows.TOP_ROW) {
            m_IntakeSubsystem.setIntakeMotorDegrees(m_IntakeSubsystem.getAngleForScoring(CubeScoringTableRow.TOP_ROW));
            // TODO: Add feedback to shuffleboard
        } else if (m_XboxController.getXButton() && reachableRows == ReachableRows.MIDDLE_ROW) {
            m_IntakeSubsystem
                    .setIntakeMotorDegrees(m_IntakeSubsystem.getAngleForScoring(CubeScoringTableRow.MIDDLE_ROW));
            // TODO: Add feedback to shuffleboard
        } else {
            m_IntakeSubsystem.setIntakeMotorDegrees(0.0);
            // TODO: Add feedback to shuffleboard
        }

        SmartDashboard.putNumber("Limelight", m_IntakeSubsystem.getAngleForScoring(CubeScoringTableRow.TOP_ROW));
    }
}