package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.VisionConstant.LimelightNames;
import frc.robot.actions.autoActions.scoreCubes.InterpolateCubeTable;
import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.devices.limelight.LimelightDevice;
import frc.robot.utilities.Balamath;

public class IntakeSubsystem {
    private final CANSparkMax m_IntakeAimingMotor = new CANSparkMax(IntakeConstants.kIntakeAimingMotorCANId,
            MotorType.kBrushless);
    private final CANSparkMax m_LeftFrontMotor = new CANSparkMax(IntakeConstants.kLeftFrontMotorCANId,
            MotorType.kBrushless);
    private final CANSparkMax m_LeftRearMotor = new CANSparkMax(IntakeConstants.kLeftRearMotorCANId,
            MotorType.kBrushless);
    private final CANSparkMax m_RightFrontMotor = new CANSparkMax(IntakeConstants.kRightFrontMotorCANId,
            MotorType.kBrushless);
    private final CANSparkMax m_RightRearMotor = new CANSparkMax(IntakeConstants.kRightRearMotorCANId,
            MotorType.kBrushless);

    private RelativeEncoder m_IntakeAimingEncoder = m_IntakeAimingMotor.getEncoder();
    private PIDController m_IntakeAimingPID = new PIDController(IntakeConstants.kIntakePIDkP,
            IntakeConstants.kIntakePIDkD, IntakeConstants.kIntakePIDkI);;

    private LimelightDevice m_LimelightDevice = GlobalSubsystemDevices
            .getLimelightDevice()[LimelightNames.LIMELIGHT_INTAKE.ordinal()];
    private double m_IntakeDisiredAngle = 0;

    public enum IntakeHardware {
        INTAKE_AIMING_MOTOR,
        LEFT_FRONT_MOTOR,
        LEFT_REAR_MOTOR,
        RIGHT_FRONT_MOTOR,
        RIGHT_REAR_MOTOR,
    }

    public enum ReachableRows {
        TOP_ROW,
        MIDDLE_ROW,
        NONE
    }

    public IntakeSubsystem() {
        m_IntakeAimingMotor.restoreFactoryDefaults();
        m_LeftFrontMotor.restoreFactoryDefaults();
        m_LeftRearMotor.restoreFactoryDefaults();
        m_RightFrontMotor.restoreFactoryDefaults();
        m_RightRearMotor.restoreFactoryDefaults();
    }

    public MotorController getMotorController(IntakeHardware hardware) {
        switch (hardware) {
            case INTAKE_AIMING_MOTOR:
                return m_IntakeAimingMotor;
            case LEFT_FRONT_MOTOR:
                return m_LeftFrontMotor;
            case LEFT_REAR_MOTOR:
                return m_LeftRearMotor;
            case RIGHT_FRONT_MOTOR:
                return m_RightFrontMotor;
            case RIGHT_REAR_MOTOR:
                return m_RightRearMotor;
            default:
                return null;
        }
    }

    public RelativeEncoder getIntakeEncoder() {
        return m_IntakeAimingEncoder;
    }

    public double getIntakeDegrees() {
        return Balamath.lerpEncoderPositionToDesiredUnit(m_IntakeAimingEncoder.getPosition(),
                IntakeConstants.kIntakeEncoderMinPosition, IntakeConstants.kIntakeEncoderMaxPosition,
                IntakeConstants.kIntakeEncoderMinAngle, IntakeConstants.kIntakeEncoderMaxAngle);
    }

    public void setIntakeDegrees(Double degrees) {
        m_IntakeAimingMotor.set(m_IntakeAimingPID.calculate(getIntakeDegrees(), degrees));
    }

    public double getAngleForScoring(CubeScoringTableRow row) {
        return InterpolateCubeTable.interpolate(m_LimelightDevice.getAprilTagDistance(), row);
    }

    // TODO: Improve range of angles and add them to constants
    public ReachableRows getReachableRows() {
        if (m_LimelightDevice.isTargetFound() && (m_IntakeDisiredAngle < 40 && m_IntakeDisiredAngle > 10)) {
            return ReachableRows.MIDDLE_ROW;
        } else if (m_LimelightDevice.isTargetFound() && (m_IntakeDisiredAngle < 70 && m_IntakeDisiredAngle > 40)) {
            return ReachableRows.TOP_ROW;
        } else {
            return ReachableRows.NONE;
        }
    }

    public void shootCube() {
        m_LeftFrontMotor.set(0.8);
        m_RightFrontMotor.set(0.8);
        m_LeftRearMotor.set(0.1);
        m_RightRearMotor.set(0.1);
    }

    public void StopShootingMotors() {
        m_LeftFrontMotor.set(0);
        m_RightFrontMotor.set(0);
        m_LeftRearMotor.set(0);
        m_RightRearMotor.set(0);
    }
}
