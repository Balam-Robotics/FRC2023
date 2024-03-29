package frc.robot;

public final class Constants {
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
    }

    public static class DrivetrainConstants {
        public static final int kLeftFrontMotorCANId = 1;
        public static final int kLeftRearMotorCANId = 2;
        public static final int kRightFrontMotorCANId = 3;
        public static final int kRightRearMotorCANId = 4;
    }

    public static class IntakeConstants {
        public static final int kIntakeAimingMotorCANId = 20;
        public static final int kLeftFrontMotorCANId = 22;
        public static final int kLeftRearMotorCANId = 21;
        public static final int kRightFrontMotorCANId = 23;
        public static final int kRightRearMotorCANId = 24;

        // TODO: Find the correct values for the PID
        public static final int kIntakePIDkP = 0;
        public static final int kIntakePIDkI = 0;
        public static final int kIntakePIDkD = 0;

        // TODO: Find the correct values for the encoder
        public static final double kIntakeEncoderMinPosition = 0.0;
        public static final double kIntakeEncoderMaxPosition = 0.0;
        public static final double kIntakeEncoderMinAngle = 0.0;
        public static final double kIntakeEncoderMaxAngle = 0.0;
    }

    public static class ClawConstants {
        public static final int kClawLeftMotorCANId = 7;
        public static final int kClawRightMotorCANId = 8;
        public static final double kClawSpeed = 1;
    }

    public static class ArmConstants {
        public static final int kArmMotorCANId = 5;
        public static final int kForearmMotorCANId = 6;

        public static final int kArmMotorEncoderPortA = 0;
        public static final int kArmMotorEncoderPortB = 1;

        public static final double kForearmExtensionSpeed = 0.2;

        public static final int kArmPIDkP = 0;
        public static final int kArmPIDkI = 0;
        public static final int kArmPIDkD = 0;

        public static final int kForearmPIDkP = 0;
        public static final int kForearmPIDkI = 0;
        public static final int kForearmPIDkD = 0;
    }

    public static class VisionConstant {
        public static final String kLimelightIntake = "limelight-intake";
        public static final String kLimelightArm = "limelight-arm";

        public static enum LimelightNames {
            LIMELIGHT_INTAKE,
            LIMELIGHT_ARM
        }
    }

    public static class ShuffleboardConstants {
        public static final String kScoringBoardTab = "Scoring Board";
    }
}
