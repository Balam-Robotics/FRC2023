package frc.robot.hardware;

import edu.wpi.first.wpilibj.XboxController;

public class GlobalSubsystemHardware {
    private static XboxController m_XboxController;
    private static LimelightHardware[] m_LimelightHardware;

    // XBOX CONTROLLER
    public static void setXboxController(XboxController xboxController) {
        m_XboxController = xboxController;
    }

    public static XboxController getXboxController() {
        return m_XboxController;
    }

    // LIMELIGHT
    public static void setLimelightHardware(LimelightHardware[] limelightHardware) {
        m_LimelightHardware = limelightHardware;
    }

    public static LimelightHardware[] getLimelightHardware() {
        return m_LimelightHardware;
    }
}