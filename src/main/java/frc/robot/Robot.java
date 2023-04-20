package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.actions.teleopActions.AimArmAction;
import frc.robot.actions.teleopActions.AimIntakeAction;
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
  private ArmSubsystem m_ArmSubsystem;
  private ClawSubsystem m_ClawSubsystem;
  private DrivetrainSubsystem m_DrivetrainSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;

  // Actions
  private ExtendForearmAction m_ExtendForearmAction;
  private HandleClawAction m_HandleClawAction;
  private DrivetrainAction m_DrivetrainAction;
  private AimIntakeAction m_AimIntakeAction;
  private AimArmAction m_AimArmAction;


  @Override
  public void robotInit() {
    GlobalSubsystemDevices.setXboxController(new XboxController(OperatorConstants.kDriverControllerPort));
    GlobalSubsystemDevices.setLimelightDevice(new LimelightDevice[] {
        new LimelightDevice("limelight-intake", new LimelightPhysicalProperties(0, 0, 0)),
        new LimelightDevice("limelight-arm", new LimelightPhysicalProperties(0, 0, 0))
    });

    m_ArmSubsystem = new ArmSubsystem();
    m_ClawSubsystem = new ClawSubsystem();
    m_DrivetrainSubsystem = new DrivetrainSubsystem();
    m_IntakeSubsystem = new IntakeSubsystem();

    m_ExtendForearmAction = new ExtendForearmAction(m_ArmSubsystem);
    m_HandleClawAction = new HandleClawAction(m_ClawSubsystem);
    m_DrivetrainAction = new DrivetrainAction(m_DrivetrainSubsystem);
    m_AimIntakeAction = new AimIntakeAction(m_IntakeSubsystem);
    m_AimArmAction = new AimArmAction(m_ArmSubsystem);
  }

  @Override
  public void robotPeriodic() {
    // UpdateBoards.update();
  }

  @Override
  public void autonomousInit() {
    // GridScoringArray.getInstance().setFieldArray(new int[][] {
    // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // In Which colum is the robot in front of the
    // grid
    // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // TOP ROW
    // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // MIDDLE ROW
    // { 0, 0, 0, 0, 0, 0, 0, 0, 0 } // BOTTOM ROW
    // });
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
