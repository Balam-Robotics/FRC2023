package frc.robot.actions.teleopActions;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.subsystem.ArmSubsystem;

public class ExtendForearmAction {
  private final XboxController m_XboxController;
  private final ArmSubsystem m_ArmSubsystem;
  private double m_desiredPosition;

  public ExtendForearmAction(ArmSubsystem armSubsystem) {
    m_XboxController = GlobalSubsystemDevices.getXboxController();
    m_ArmSubsystem = armSubsystem;
    m_desiredPosition = 0;
  }

  public void execute() {
    // TODO: Agregar valor a las constantes
    if (m_XboxController.getRightBumper()) {
      if (m_desiredPosition < 60) {
        m_desiredPosition += 0.6;
      }
    } else if (m_XboxController.getLeftBumper()) {
      if (m_desiredPosition > 0) {
        m_desiredPosition -= 0.6;
      }
    }

    m_ArmSubsystem.setForearmMotorPosition(m_desiredPosition);
  }
}