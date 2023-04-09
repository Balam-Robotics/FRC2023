package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.actions.teleopActions.AimArmAction;
import frc.robot.actions.teleopActions.DrivetrainAction;
import frc.robot.actions.teleopActions.ExtendForearmAction;
import frc.robot.actions.teleopActions.HandleClawAction;
import frc.robot.hardware.GlobalSubsystemHardware;
import frc.robot.hardware.LimelightHardware;
import frc.robot.subsystem.ArmSubsystem;
import frc.robot.subsystem.ClawSubsystem;
import frc.robot.subsystem.DrivetrainSubsystem;

public class Robot extends TimedRobot {
  // Actions
  private final ExtendForearmAction m_ExtendForearmAction = new ExtendForearmAction(new ArmSubsystem());
  private final AimArmAction m_AimArmAction = new AimArmAction(new ArmSubsystem());
  private final HandleClawAction m_HandleClawAction = new HandleClawAction(new ClawSubsystem());
  private final DrivetrainAction m_DrivetrainAction = new DrivetrainAction(new DrivetrainSubsystem());

  @Override
  public void robotInit() {
    GlobalSubsystemHardware.setXboxController(new XboxController(Constants.OperatorConstants.kDriverControllerPort));
    GlobalSubsystemHardware.setLimelightHardware(new LimelightHardware[] {
        new LimelightHardware("limelight-intake"),
        new LimelightHardware("limelight-arm")
    });
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    m_AimArmAction.execute();
    m_ExtendForearmAction.execute();
    m_HandleClawAction.execute();
    m_DrivetrainAction.execute();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
