package frc.robot.actions;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystem.ArmSubsystem;
import frc.robot.subsystem.GlobalSubsystemHardware;
import frc.robot.subsystem.ArmSubsystem.ArmHardware;

public class ExtendForearmAction {
  private final XboxController m_XboxController;
  private final ArmSubsystem m_ArmSubsystem;

  public ExtendForearmAction(ArmSubsystem armSubsystem) {
    m_XboxController = GlobalSubsystemHardware.getXboxController();
    m_ArmSubsystem = armSubsystem;
  }

  public void execute() {
    if (m_XboxController.getRightBumper()) {
      m_ArmSubsystem.getMotorController(ArmHardware.FOREARM_MOTOR).set(-ArmConstants.kForearmExtensionSpeed);
    } else if (m_XboxController.getLeftBumper()) {
      m_ArmSubsystem.getMotorController(ArmHardware.FOREARM_MOTOR).set(ArmConstants.kForearmExtensionSpeed);
    } else {
      m_ArmSubsystem.getMotorController(ArmHardware.FOREARM_MOTOR).set(0);
    }

    GlobalSubsystemHardware.getXboxController();
  }
}