package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants.DrivetrainConstants;

public class DrivetrainSubsystem {
    private final WPI_TalonSRX m_LeftFrontMotor = new WPI_TalonSRX(DrivetrainConstants.kLeftFrontMotorCANId);
    private final WPI_TalonSRX m_LeftRearMotor = new WPI_TalonSRX(DrivetrainConstants.kLeftRearMotorCANId);
    private final WPI_TalonSRX m_RightFrontMotor = new WPI_TalonSRX(DrivetrainConstants.kRightFrontMotorCANId);
    private final WPI_TalonSRX m_RightRearMotor = new WPI_TalonSRX(DrivetrainConstants.kRightRearMotorCANId);
    private final MotorControllerGroup m_LeftMotors = new MotorControllerGroup(m_LeftFrontMotor, m_LeftRearMotor);
    private final MotorControllerGroup m_RightMotors = new MotorControllerGroup(m_RightFrontMotor, m_RightRearMotor);
    private final DifferentialDrive m_DifferentialDrive = new DifferentialDrive(m_LeftMotors, m_RightMotors);

    public enum DrivetrainHardware {
        LEFT_FRONT_MOTOR,
        LEFT_REAR_MOTOR,
        RIGHT_FRONT_MOTOR,
        RIGHT_REAR_MOTOR,
        LEFT_MOTORS_GROUP,
        RIGHT_MOTORS_GROUP,
    }

    public DrivetrainSubsystem() {
        m_LeftFrontMotor.configFactoryDefault();
        m_LeftRearMotor.configFactoryDefault();
        m_RightFrontMotor.configFactoryDefault();
        m_RightRearMotor.configFactoryDefault();
    }

    public MotorController getMotorController(DrivetrainHardware hardware) {
        switch (hardware) {
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

    public MotorControllerGroup getMotorControllerGroup(DrivetrainHardware hardware) {
        switch (hardware) {
            case LEFT_MOTORS_GROUP:
                return m_LeftMotors;
            case RIGHT_MOTORS_GROUP:
                return m_RightMotors;
            default:
                return null;
        }
    }

    public DifferentialDrive getDifferentialDrive() {
        return m_DifferentialDrive;
    }
}
