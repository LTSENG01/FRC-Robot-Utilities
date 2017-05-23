import java.util.ArrayList;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import larrytseng.frcrobotutils.operatorcontrollers.XboxController;
import larrytseng.frcrobotutils.operatorcontrollers.XboxController.Axes;
import larrytseng.frcrobotutils.operatorcontrollers.XboxController.Buttons;
import larrytseng.frcrobotutils.operatorcontrollers.XboxController.DirectionalPad;
import larrytseng.frcrobotutils.hardware.sensors.ReedSwitch;

public class Test {
	
	private XboxController xboxController;
	private ReedSwitch reedSwitch;
	
	private ArrayList<SpeedController> motorControllers = new ArrayList<SpeedController>();
	
	public Test() {
		xboxController = new XboxController(0);
		reedSwitch = new ReedSwitch(0);
		
	}
	
	public void test() {
		System.out.println(xboxController.getRawButton(Buttons.A));
		System.out.println(xboxController.getRawAxis(Axes.LEFT_X));
		System.out.println(xboxController.getPOV(DirectionalPad.D_TOP));
		xboxController.setRumble(RumbleType.kLeftRumble, 1);
		
		// xboxController.getButton(Buttons.A).whenPressed( // COMMAND );
		
		System.out.println(reedSwitch.get());
		
	}
	
}
