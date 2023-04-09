package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.actions.autoActions.AutoAimIntakeAction;
import frc.robot.actions.teleopActions.AimArmAction;
import frc.robot.actions.teleopActions.DrivetrainAction;
import frc.robot.actions.teleopActions.ExtendForearmAction;
import frc.robot.actions.teleopActions.HandleClawAction;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.devices.limelight.LimelightDevice;
import frc.robot.devices.limelight.LimelightPhysicalProperties;
import frc.robot.subsystem.ArmSubsystem;
import frc.robot.subsystem.ClawSubsystem;
import frc.robot.subsystem.DrivetrainSubsystem;
import frc.robot.subsystem.IntakeSubsystem;

public class Robot extends TimedRobot {
  // Actions
  private final ExtendForearmAction m_ExtendForearmAction = new ExtendForearmAction(new ArmSubsystem());
  private final AimArmAction m_AimArmAction = new AimArmAction(new ArmSubsystem());
  private final HandleClawAction m_HandleClawAction = new HandleClawAction(new ClawSubsystem());
  private final DrivetrainAction m_DrivetrainAction = new DrivetrainAction(new DrivetrainSubsystem());
  private final AutoAimIntakeAction m_AimIntakeAction = new AutoAimIntakeAction(new IntakeSubsystem());

  @Override
  public void robotInit() {
    GlobalSubsystemDevices.setXboxController(new XboxController(OperatorConstants.kDriverControllerPort));
    GlobalSubsystemDevices.setLimelightDevice(new LimelightDevice[] {
        new LimelightDevice("limelight-intake", new LimelightPhysicalProperties(0, 0, 0)),
        new LimelightDevice("limelight-arm", new LimelightPhysicalProperties(0, 0, 0))
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
    m_AimIntakeAction.execute();
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
    m_AimIntakeAction.execute();
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
