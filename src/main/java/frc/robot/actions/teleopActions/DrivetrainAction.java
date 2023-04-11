package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.DrivetrainSubsystem;

public class DrivetrainAction {
    private final XboxController m_XboxController;
    private final DrivetrainSubsystem m_DrivetrainSubsystem;
    private final DifferentialDrive m_DifferentialDrive;

    public DrivetrainAction(DrivetrainSubsystem drivetrainSubsystem) {
        m_XboxController = GlobalSubsystemDevices.getXboxController();
        m_DrivetrainSubsystem = drivetrainSubsystem;
        m_DifferentialDrive = m_DrivetrainSubsystem.getDifferentialDrive();
    }

    public void execute() {
        m_DifferentialDrive.arcadeDrive(m_XboxController.getRightX(), m_XboxController.getLeftY());
    }
}
