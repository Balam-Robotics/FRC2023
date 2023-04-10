package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
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

        // NOTE!! the button must be held down to keep the intake at the desired angle
        // and shoot when it is ready
        if (reachableRows == ReachableRows.TOP_ROW) {
            if (m_XboxController.getAButton() && !m_XboxController.getXButton() && !m_XboxController.getYButton()) {
                double targetAngle = m_IntakeSubsystem.getAngleForScoring(CubeScoringTableRow.TOP_ROW);
                double currentAngle = m_IntakeSubsystem.getIntakeDegrees();
                if (Math.abs(targetAngle - currentAngle) <= 2) {
                    m_IntakeSubsystem.shootCube();
                } else {
                    m_IntakeSubsystem.setIntakeDegrees(targetAngle);
                }
            } else {
                m_IntakeSubsystem.setIntakeDegrees(0.0);
                m_IntakeSubsystem.StopShootingMotors();
            }
        } else if (reachableRows == ReachableRows.MIDDLE_ROW) {
            if (m_XboxController.getXButton() && !m_XboxController.getAButton() && !m_XboxController.getYButton()) {
                double targetAngle = m_IntakeSubsystem.getAngleForScoring(CubeScoringTableRow.MIDDLE_ROW);
                double currentAngle = m_IntakeSubsystem.getIntakeDegrees();
                if (Math.abs(targetAngle - currentAngle) <= 2) {
                    m_IntakeSubsystem.shootCube();
                } else {
                    m_IntakeSubsystem.setIntakeDegrees(targetAngle);
                }
            } else {
                m_IntakeSubsystem.setIntakeDegrees(0.0);
                m_IntakeSubsystem.StopShootingMotors();
            }
        } else {
            if (m_XboxController.getAButton() && !m_XboxController.getXButton() && !m_XboxController.getYButton()) {
                m_IntakeSubsystem.setIntakeDegrees(0.0);
                m_IntakeSubsystem.shootCube();
            } else {
                m_IntakeSubsystem.setIntakeDegrees(0.0);
                m_IntakeSubsystem.StopShootingMotors();
            }
        }

        if (!m_XboxController.getAButton() && !m_XboxController.getXButton() && !m_XboxController.getYButton()) {
            m_IntakeSubsystem.setIntakeDegrees(0.0);
            m_IntakeSubsystem.StopShootingMotors();
        }
    }
}