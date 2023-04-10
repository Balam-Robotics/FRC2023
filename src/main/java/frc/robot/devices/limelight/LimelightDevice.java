package frc.robot.devices.limelight;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightDevice {
    private final NetworkTable m_Table;
    private final LimelightPhysicalProperties m_LimelightPhysicalProperties;

    public enum LedMode {
        CURRENT_PIPELINE_MODE,
        FORCE_OFF,
        FORCE_BLINK,
        FORCE_ON
    }

    public enum CameraMode {
        VISION_PROCESSOR,
        DRIVER_CAMERA
    }

    public enum Pipeline {
        APRIL_TAG,
        REFLECTIVE,
    }

    public LimelightDevice(String limelightTableName, LimelightPhysicalProperties limelightPhysicalProperties) {
        m_Table = NetworkTableInstance.getDefault().getTable(limelightTableName);
        m_LimelightPhysicalProperties = limelightPhysicalProperties;
    }

    public double getTargetX() {
        return m_Table.getEntry("tx").getDouble(0.0);
    }

    public double getTargetY() {
        return m_Table.getEntry("ty").getDouble(0.0);
    }

    public double getTargetArea() {
        return m_Table.getEntry("ta").getDouble(0.0);
    }

    public double getCurrentAprilTagId() {
        return m_Table.getEntry("tid").getDoubleArray(new double[1])[0]; //FIXME: This is a hack that may not work, further testing is needed
    }

    public boolean isTargetFound() {
        return m_Table.getEntry("tv").getDouble(0.0) == 1.0;
    }

    public void setLedMode(LedMode ledMode) {
        m_Table.getEntry("ledMode").setNumber(ledMode.ordinal());
    }

    public void setCameraMode(CameraMode cameraMode) {
        m_Table.getEntry("camMode").setNumber(cameraMode.ordinal());
    }

    public void setPipeline(Pipeline pipeline) {
        m_Table.getEntry("pipeline").setNumber(pipeline.ordinal());
    }

    // Utility functions
    public double getAprilTagDistance() {
        double angleToGoalDegrees = m_LimelightPhysicalProperties.getM_LimelightAngle() + getTargetY();
        double angleToGoalRadians = angleToGoalDegrees * (Math.PI / 180.0);
        return (m_LimelightPhysicalProperties.getM_AprilTagHeight()
                - m_LimelightPhysicalProperties.getM_LimelightLensHeight())
                / Math.tan(angleToGoalRadians);
    }
}
