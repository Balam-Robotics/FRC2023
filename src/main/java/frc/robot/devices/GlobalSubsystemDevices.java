package frc.robot.devices;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.devices.limelight.LimelightDevice;

public class GlobalSubsystemDevices {
    private static XboxController m_XboxController;
    private static LimelightDevice[] m_LimelightDevice;

    // XBOX CONTROLLER
    public static void setXboxController(XboxController xboxController) {
        m_XboxController = xboxController;
    }

    public static XboxController getXboxController() {
        return m_XboxController;
    }

    // LIMELIGHT
    public static void setLimelightDevice(LimelightDevice[] limelightDevice) {
        m_LimelightDevice = limelightDevice;
    }

    public static LimelightDevice[] getLimelightDevice() {
        return m_LimelightDevice;
    }
}