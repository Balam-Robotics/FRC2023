package frc.robot.actions;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystem.DrivetrainSubsystem;
import frc.robot.subsystem.GlobalSubsystemHardware;

public class DrivetrainAction {
    private final XboxController m_XboxController;
    private final DrivetrainSubsystem m_DrivetrainSubsystem;
    private final DifferentialDrive m_DifferentialDrive;

    public DrivetrainAction(DrivetrainSubsystem drivetrainSubsystem) {
        m_XboxController = GlobalSubsystemHardware.getXboxController();
        m_DrivetrainSubsystem = drivetrainSubsystem;
        m_DifferentialDrive = m_DrivetrainSubsystem.getDifferentialDrive();
    }

    public void execute() {
        m_DifferentialDrive.arcadeDrive(m_XboxController.getLeftY(), m_XboxController.getRightX());
    }
}
