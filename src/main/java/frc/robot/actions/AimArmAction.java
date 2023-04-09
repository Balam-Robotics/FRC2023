package frc.robot.actions;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystem.ArmSubsystem;
import frc.robot.subsystem.GlobalSubsystemHardware;
import frc.robot.subsystem.ArmSubsystem.ArmHardware;

public class AimArmAction {
    XboxController m_XboxController;
    ArmSubsystem m_ArmSubsystem;

    public AimArmAction(ArmSubsystem armSubsystem) {
        m_XboxController = GlobalSubsystemHardware.getXboxController();
        m_ArmSubsystem = armSubsystem;
    }

    public void execute() {
        m_ArmSubsystem.getMotorController(ArmHardware.ARM_MOTOR).set(-m_XboxController.getLeftTriggerAxis());
        m_ArmSubsystem.getMotorController(ArmHardware.ARM_MOTOR).set(m_XboxController.getRightTriggerAxis());
    }
}
