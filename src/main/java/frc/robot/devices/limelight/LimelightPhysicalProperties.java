package frc.robot.devices.limelight;

public class LimelightPhysicalProperties {
    private final double m_LimelightAngle;
    private final double m_LimelightLensHeight;
    private final double m_AprilTagHeight;

    public LimelightPhysicalProperties(double limelightAngle, double limelightLensHeight, double aprilTagHeight) {
        m_LimelightAngle = limelightAngle;
        m_LimelightLensHeight = limelightLensHeight;
        m_AprilTagHeight = aprilTagHeight;
    }

    public double getM_LimelightAngle() {
        return m_LimelightAngle;
    }

    public double getM_LimelightLensHeight() {
        return m_LimelightLensHeight;
    }

    public double getM_AprilTagHeight() {
        return m_AprilTagHeight;
    }

}
