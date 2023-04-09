package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.actions.autoActions.scoreCubes.InterpolateCubeTable;
import frc.robot.actions.autoActions.scoreCubes.CubeScoringTable.CubeScoringTableRow;

public class IntakeSubsystem {
    private final CANSparkMax m_IntakeAimingMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_LeftFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_LeftRearMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_RightFrontMotor = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_RightRearMotor = new CANSparkMax(0, MotorType.kBrushless);

    private RelativeEncoder m_IntakeAimingEncoder;
    private PIDController m_IntakeAimingPID;

    public enum IntakeHardware {
        INTAKE_AIMING_MOTOR,
        LEFT_FRONT_MOTOR,
        LEFT_REAR_MOTOR,
        RIGHT_FRONT_MOTOR,
        RIGHT_REAR_MOTOR,
    }

    public IntakeSubsystem() {
        m_IntakeAimingMotor.restoreFactoryDefaults();
        m_LeftFrontMotor.restoreFactoryDefaults();
        m_LeftRearMotor.restoreFactoryDefaults();
        m_RightFrontMotor.restoreFactoryDefaults();
        m_RightRearMotor.restoreFactoryDefaults();

        m_IntakeAimingEncoder = m_IntakeAimingMotor.getEncoder();
        m_IntakeAimingPID.reset();
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
        m_IntakeAimingMotor.set(m_IntakeAimingPID.calculate(m_IntakeAimingEncoder.getPosition(), degrees)); // TO DO
    }

    public double getAngleForScoring(Double distance, CubeScoringTableRow row) {
        return InterpolateCubeTable.interpolate(distance, row);
    }
}
