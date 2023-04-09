package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;

public class ClawSubsystem {
    private final CANSparkMax m_ClawLeftMotor = new CANSparkMax(Constants.ClawConstants.kClawLeftMotorCANId,
            MotorType.kBrushless);
    private final WPI_TalonSRX m_ClawRightMotor = new WPI_TalonSRX(Constants.ClawConstants.kClawRightMotorCANId);

    public enum ClawHardware {
        CLAW_LEFT_MOTOR,
        CLAW_RIGHT_MOTOR
    }

    public ClawSubsystem() {
        m_ClawLeftMotor.restoreFactoryDefaults();
        m_ClawRightMotor.configFactoryDefault();
    }

    public MotorController getMotorController(ClawHardware hardware) {
        switch (hardware) {
            case CLAW_LEFT_MOTOR:
                return m_ClawLeftMotor;
            case CLAW_RIGHT_MOTOR:
                return m_ClawRightMotor;
            default:
                return null;
        }
    }
}
