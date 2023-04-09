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
        public static final int kIntakeRightMotorCANId = 0;
        public static final int kIntakeLeftMotorCANId = 0;
        public static final int kIntakeAimMotorCANId = 0;
    }

    public static class ClawConstants {
        public static final int kClawLeftMotorCANId = 7;
        public static final int kClawRightMotorCANId = 8;
        public static final double kClawSpeed = 0.5;
    }

    public static class ArmConstants {
        public static final int kArmMotorCANId = 5;
        public static final int kForearmMotorCANId = 6;

        public static final int kArmMotorEncoderPortA = 0;
        public static final int kArmMotorEncoderPortB = 0;

        public static final double kForearmExtensionSpeed = 0.2;

        public static final int kArmPIDkP = 0;
        public static final int kArmPIDkI = 0;
        public static final int kArmPIDkD = 0;

        public static final int kForearmPIDkP = 0;
        public static final int kForearmPIDkI = 0;
        public static final int kForearmPIDkD = 0;
    }

    public static class VisionConstants {
        public static final String kLimelightKey = "limelight-balam";
    }
}