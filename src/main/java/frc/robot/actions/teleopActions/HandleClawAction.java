package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ClawConstants;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.ClawSubsystem;
import frc.robot.subsystem.ClawSubsystem.ClawHardware;

public class HandleClawAction {
    private final XboxController m_XboxController;
    private final ClawSubsystem m_ClawSubsystem;

    public HandleClawAction(ClawSubsystem clawSubsystem) {
        m_XboxController = GlobalSubsystemDevices.getXboxController();
        m_ClawSubsystem = clawSubsystem;
    }

    public void execute() {
        if (m_XboxController.getYButton()) {
            m_ClawSubsystem.getMotorController(ClawHardware.CLAW_LEFT_MOTOR).set(-ClawConstants.kClawSpeed);
            m_ClawSubsystem.getMotorController(ClawHardware.CLAW_RIGHT_MOTOR).set(ClawConstants.kClawSpeed);
        } else if (m_XboxController.getXButton()) {
            m_ClawSubsystem.getMotorController(ClawHardware.CLAW_LEFT_MOTOR).set(ClawConstants.kClawSpeed);
            m_ClawSubsystem.getMotorController(ClawHardware.CLAW_RIGHT_MOTOR).set(-ClawConstants.kClawSpeed);
        } else {
            m_ClawSubsystem.getMotorController(ClawHardware.CLAW_LEFT_MOTOR).set(0);
            m_ClawSubsystem.getMotorController(ClawHardware.CLAW_RIGHT_MOTOR).set(0);
        }
    }
}
