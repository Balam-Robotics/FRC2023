package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem {
    private final WPI_TalonSRX m_ArmMotor = new WPI_TalonSRX(ArmConstants.kArmMotorCANId);
    private final CANSparkMax m_ForearmMotor = new CANSparkMax(ArmConstants.kForearmMotorCANId,
            MotorType.kBrushless);

    public enum ArmHardware {
        ARM_MOTOR,
        FOREARM_MOTOR
    }

    public ArmSubsystem() {
        m_ArmMotor.configFactoryDefault();
        m_ForearmMotor.restoreFactoryDefaults();
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
}
