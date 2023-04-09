package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.actions.AimArmAction;
import frc.robot.actions.DrivetrainAction;
import frc.robot.actions.ExtendForearmAction;
import frc.robot.actions.HandleClawAction;
import frc.robot.subsystem.ArmSubsystem;
import frc.robot.subsystem.ClawSubsystem;
import frc.robot.subsystem.DrivetrainSubsystem;
import frc.robot.subsystem.GlobalSubsystemHardware;

public class Robot extends TimedRobot {
  // Actions
  private final ExtendForearmAction m_ExtendForearmAction = new ExtendForearmAction(new ArmSubsystem());
  private final AimArmAction m_AimArmAction = new AimArmAction(new ArmSubsystem());
  private final HandleClawAction m_HandleClawAction = new HandleClawAction(new ClawSubsystem());
  private final DrivetrainAction m_DrivetrainAction = new DrivetrainAction(new DrivetrainSubsystem());

  @Override
  public void robotInit() {
    GlobalSubsystemHardware.setXboxController(new XboxController(Constants.OperatorConstants.kDriverControllerPort));
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
