package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.VisionConstant.LimelightNames;
import frc.robot.actions.autoActions.scoreCubes.InterpolateCubeTable;
import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;
import frc.robot.devices.GlobalSubsystemDevices;
import frc.robot.devices.limelight.LimelightDevice;

public class IntakeSubsystem {
    private final CANSparkMax m_IntakeAimingMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_LeftFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_LeftRearMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_RightFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_RightRearMotor = new CANSparkMax(0, MotorType.kBrushless);

    private RelativeEncoder m_IntakeAimingEncoder;
    private PIDController m_IntakeAimingPID;

    private LimelightDevice m_LimelightDevice;
    private double m_IntakeDisiredAngle;

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

        m_IntakeAimingEncoder = m_IntakeAimingMotor.getEncoder();
        m_IntakeAimingPID.reset();

        m_LimelightDevice = GlobalSubsystemDevices.getLimelightDevice()[LimelightNames.LIMELIGHT_INTAKE.ordinal()];
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

    private Double getDistanceToTarget() {
        return m_LimelightDevice.getAprilTagDistance();
    }

    public RelativeEncoder getEncoder() {
        return m_IntakeAimingEncoder;
    }

    public void resetEncoder(RelativeEncoder encoder, Double position) {
        encoder.setPosition(position);
    }

    public void setPID(Double kP, Double kI, Double kD) {
        m_IntakeAimingPID.setP(kP);
        m_IntakeAimingPID.setI(kI);
        m_IntakeAimingPID.setD(kD);
    }

    public void resetPID() {
        m_IntakeAimingPID.reset();
    }

    public void setIntakeMotorDegrees(Double degrees) {
        // TODO: Interpolate the degrees from the encoder position
        m_IntakeAimingMotor.set(m_IntakeAimingPID.calculate(m_IntakeAimingEncoder.getPosition(), degrees));
    }

    public double getAngleForScoring(CubeScoringTableRow row) {
        return InterpolateCubeTable.interpolate(getDistanceToTarget(), row);
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
}
