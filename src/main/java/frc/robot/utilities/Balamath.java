package frc.robot.utilities;

public class Balamath {
  public static double lerpEncoderPositionToDesiredUnit(double currentPos, double minPos, double maxPos,
      double minAngle,
      double maxAngle) {
    double ratio = (currentPos - minPos) / (maxPos - minPos);
    double angle = minAngle + ratio * (maxAngle - minAngle);
    return angle;
  }
}
