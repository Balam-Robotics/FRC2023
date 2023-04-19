package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.ArmConstants;
import frc.robot.utilities.Balamath;

public class ArmSubsystem {
    private final WPI_TalonSRX m_ArmMotor = new WPI_TalonSRX(ArmConstants.kArmMotorCANId);
    private final CANSparkMax m_ForearmMotor = new CANSparkMax(ArmConstants.kForearmMotorCANId,
            MotorType.kBrushless);
    private Encoder m_ArmEncoder;
    private final RelativeEncoder m_ForearmEncoder = m_ForearmMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor,
            42);
    private PIDController m_ForearmPIDController = new PIDController(-0.1, 0, 0); // TODO: Put them in constants
    private PIDController m_ArmPIDController = new PIDController(-0.1, 0, 0); // TODO: Put them in constants

    public enum ArmHardware {
        ARM_MOTOR,
        FOREARM_MOTOR
    }

    public ArmSubsystem() {
        m_ArmMotor.configFactoryDefault();
        m_ForearmMotor.restoreFactoryDefaults();
        m_ForearmEncoder.setPosition(0.0);
        m_ArmEncoder = new Encoder(ArmConstants.kArmMotorEncoderPortA, ArmConstants.kArmMotorEncoderPortB);
        m_ArmEncoder.setDistancePerPulse(1.0 / 6);
        m_ArmEncoder.reset();
    }

    public MotorController getMotorController(ArmHardware hardware) {
        switch (hardware) {
            case ARM_MOTOR:
                return m_ArmMotor;
            case FOREARM_MOTOR:
                return m_ForearmMotor;
            default:
                return null;
        }
    }

    // FOREARM ENCODER
    private double getForearmEncoderOriginalPosition() {
        return m_ForearmEncoder.getPosition() * -1;
    }

    public double getForearmEncoderPosition() {
        return Balamath.lerpEncoderPositionToDesiredUnit(getForearmEncoderOriginalPosition(), 0, 65, 0, 100);
    }

    public void setForearmMotorPosition(double desiredPosition) {
        m_ForearmMotor.set(m_ForearmPIDController.calculate(getForearmEncoderOriginalPosition(), desiredPosition));
    }

    // ARM ENCODER
    public double getArmEncoderOriginalPosition() {
        return m_ArmEncoder.getDistance();
    }

    public double getArmEncoderPosition() {
        return Balamath.lerpEncoderPositionToDesiredUnit(getArmEncoderOriginalPosition(), 0, 124, 0, 90);
    }

    public void setArmMotorAngle(double desiredAngle) {
        m_ArmMotor.set(m_ArmPIDController.calculate(getArmEncoderPosition(), desiredAngle));
    }
}
