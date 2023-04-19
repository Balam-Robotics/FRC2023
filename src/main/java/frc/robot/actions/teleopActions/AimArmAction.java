package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.ArmSubsystem;

public class AimArmAction {
    private final XboxController m_XboxController;
    private final ArmSubsystem m_ArmSubsystem;
    private double m_DesiredAngle = 0;

    public AimArmAction(ArmSubsystem armSubsystem) {
        m_XboxController = GlobalSubsystemDevices.getXboxController();
        m_ArmSubsystem = armSubsystem;
    }

    public void execute() {
        // m_ArmSubsystem.getMotorController(ArmHardware.ARM_MOTOR).set(-m_XboxController.getLeftTriggerAxis());
        // m_ArmSubsystem.getMotorController(ArmHardware.ARM_MOTOR).set(-m_XboxController.getRightTriggerAxis());

        double maxAngle = 120;
        double minAngle = 0.0;
        double triggerSensitivity = 0.4;

        if (m_XboxController.getRightTriggerAxis() >= 0.05 && m_DesiredAngle < maxAngle) {
            double triggerValue = m_XboxController.getRightTriggerAxis();
            double newPosition = m_DesiredAngle + (triggerSensitivity * triggerValue);
            m_DesiredAngle = Math.min(newPosition, maxAngle);
        } else if (m_XboxController.getLeftTriggerAxis() >= 0.05 && m_DesiredAngle > minAngle) {
            double triggerValue = m_XboxController.getLeftTriggerAxis();
            double newPosition = m_DesiredAngle - (triggerSensitivity * triggerValue);
            m_DesiredAngle = Math.max(newPosition, minAngle);
        }

        m_ArmSubsystem.setArmMotorAngle(m_DesiredAngle);

        System.out.println("Valor control: " + m_DesiredAngle + " | Valor encoder grados: "
                + m_ArmSubsystem.getArmEncoderPosition());
    }
}
