package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.ArmConstants;
import frc.robot.utilities.Balamath;

public class ArmSubsystem {
    private final WPI_TalonSRX m_ArmMotor = new WPI_TalonSRX(ArmConstants.kArmMotorCANId);
    private final CANSparkMax m_ForearmMotor = new CANSparkMax(ArmConstants.kForearmMotorCANId,
            MotorType.kBrushless);
    private final RelativeEncoder m_ForearmEncoder = m_ForearmMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor,
            42);
    private PIDController m_ForearmPIDController = new PIDController(-0.1, 0, 0);

    public enum ArmHardware {
        ARM_MOTOR,
        FOREARM_MOTOR
    }

    public ArmSubsystem() {
        m_ArmMotor.configFactoryDefault();
        m_ForearmMotor.restoreFactoryDefaults();
        m_ForearmEncoder.setPosition(0.0);
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

    public double getEncoderOriginalPosition() {
        return m_ForearmEncoder.getPosition() * -1;
    }

    public double getEncoderPosition() {
        // Cambiar 467 por elvalor de la posición final
        return Balamath.lerpEncoderPositionToDesiredUnit(getEncoderOriginalPosition(), 0, 65, 0, 100);
    }

    public void setForearmMotorPosition(double desiredPosition) {
        m_ForearmMotor.set(m_ForearmPIDController.calculate(getEncoderOriginalPosition(), desiredPosition));
    }
}
