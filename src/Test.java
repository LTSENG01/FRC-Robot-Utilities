import OperatorControllers.XboxController;
import OperatorControllers.XboxController.Axes;
import OperatorControllers.XboxController.Buttons;
import OperatorControllers.XboxController.DirectionalPad;
import Sensors.ReedSwitch;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

public class Test {
	
	private XboxController xboxController;
	private ReedSwitch reedSwitch;
	
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
