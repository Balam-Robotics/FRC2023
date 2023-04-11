package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.ArmSubsystem;
import frc.robot.subsystem.ArmSubsystem.ArmHardware;

public class AimArmAction {
    private final XboxController m_XboxController;
    private final ArmSubsystem m_ArmSubsystem;

    public AimArmAction(ArmSubsystem armSubsystem) {
        m_XboxController = GlobalSubsystemDevices.getXboxController();
        m_ArmSubsystem = armSubsystem;
    }

    public void execute() {
        // m_ArmSubsystem.getMotorController(ArmHardware.ARM_MOTOR).set(-m_XboxController.getLeftTriggerAxis());
        m_ArmSubsystem.getMotorController(ArmHardware.ARM_MOTOR).set(-m_XboxController.getRightTriggerAxis());
    }
}
