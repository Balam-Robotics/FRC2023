package frc.robot.actions.autoActions;

import frc.robot.Constants.VisionConstant.LimelightNames;
import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.IntakeSubsystem;

public class AimIntakeAction {
    private final IntakeSubsystem m_IntakeSubsystem;
    private double m_DistanceToTarget;
    private double m_IntakeDisiredAngle;

    public AimIntakeAction(IntakeSubsystem intakeSubsystem) {
        m_IntakeSubsystem = intakeSubsystem;
    }

    public void execute() {
        m_DistanceToTarget = GlobalSubsystemDevices.getLimelightDevice()[LimelightNames.LIMELIGHT_INTAKE.ordinal()]
                .getAprilTagDistance();
        m_IntakeDisiredAngle = m_IntakeSubsystem.getAngleForScoring(m_DistanceToTarget, CubeScoringTableRow.TOP_ROW);
        m_IntakeSubsystem.setIntakeMotorDegrees(m_IntakeDisiredAngle);
    }
}
