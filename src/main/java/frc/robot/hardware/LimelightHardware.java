package frc.robot.hardware;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightHardware {
    private final NetworkTable m_Table;

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

    public LimelightHardware(String limelightTableName) {
        m_Table = NetworkTableInstance.getDefault().getTable(limelightTableName);
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

    public void setLedMode(LedMode ledMode) {
        m_Table.getEntry("ledMode").setNumber(ledMode.ordinal());
    }

    public void setCameraMode(CameraMode cameraMode) {
        m_Table.getEntry("camMode").setNumber(cameraMode.ordinal());
    }

    public void setPipeline(Pipeline pipeline) {
        m_Table.getEntry("pipeline").setNumber(pipeline.ordinal());
    }
}
