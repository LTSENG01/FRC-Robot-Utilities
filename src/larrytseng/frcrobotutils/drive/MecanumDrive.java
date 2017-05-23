package larrytseng.frcrobotutils.drive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class MecanumDrive {
	
	private RobotDrive mecanumDrive;
	
	public MecanumDrive(SpeedController frontLeft, SpeedController frontRight, SpeedController rearLeft, SpeedController rearRight) {
		mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		
	}
	
	public void drive(double x, double y, double rotation, double gyroAngle) {
		mecanumDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
		
	}
	
	public void drivePolar(double magnitude, double direction, double rotation) {
		mecanumDrive.mecanumDrive_Polar(magnitude, direction, rotation);
		
	}
	
}
