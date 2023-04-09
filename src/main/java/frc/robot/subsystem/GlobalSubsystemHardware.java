package frc.robot.subsystem;

import edu.wpi.first.wpilibj.XboxController;

public class GlobalSubsystemHardware {
    private static XboxController m_XboxController;

    public static void setXboxController(XboxController xboxController) {
        m_XboxController = xboxController;
    }

    public static XboxController getXboxController() {
        return m_XboxController;
    }
}
