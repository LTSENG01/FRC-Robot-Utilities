package larrytseng.frcrobotutils.operatorcontrollers;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * 
 * @author Larry Tseng 
 *
 */
public class XboxController extends Joystick {

	private final static double DEADBAND = 0.15;
	
	private List<JoystickButton> joystickButtons = new ArrayList<JoystickButton>(super.getButtonCount());
	
	public interface XboxControllerControls {
		public int getValue();
		
	}
	
	public enum Buttons implements XboxControllerControls {
		A(1), B(2), X(3), Y(4), LEFT_BUMPER(5), RIGHT_BUMPER(6), 
		BACK(7), START(8), LEFT_STICK_BUTTON(9), RIGHT_STICK_BUTTON(10);
		
		private int value;
		
		private Buttons(int value) {
			this.value = value;
			
		}
		
		public int getValue() {
			return value;
		}
		
	}
	
	/**
	 * Enum of possible XboxController D-Pad buttons.
	 */
	public enum DirectionalPad implements XboxControllerControls {
		D_TOP(0), D_RIGHT(90), D_BOTTOM(180), D_LEFT(270);
		
		private int value;
		
		private DirectionalPad(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
	}
	
	/**
	 * Enum of possible XboxController axes.
	 */
	public enum Axes implements XboxControllerControls {
		LEFT_X(0), LEFT_Y(1), LEFT_TRIGGER(2), RIGHT_TRIGGER(3), RIGHT_X(4), RIGHT_Y(5);
		
		private int value;
		
		private Axes(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
	}

	/**
	 * Constructs a XboxController instance.
	 * 
	 * @param port The Driver Station port the controller is plugged into.
	 */
	public XboxController(int port) {
		super(port);
		
		for (Buttons button : Buttons.values()) {
			joystickButtons.add(new JoystickButton(this, button.getValue()));
		}
		
	}
	
	/**
	 * Get the JoystickButton associated with a Buttons button.
	 * 
	 * @param button The button of the desired JoystickButton.
	 * @return The JoystickButton of the desired button.
	 */
	public JoystickButton getButton(Buttons button) {
		return joystickButtons.get(button.getValue() + 1);
		
	}
	
	/**
	 * Get the value of the button.
	 * 
	 * @param button The button to read.
	 * @return The value of the button.
	 */
	public boolean getRawButton(Buttons button) {
		return super.getRawButton(button.getValue());
		
	}
	
	/**
	 * 
	 * @param pov The DirectionalPad button to read.
	 * @return The value of the POV button.
	 */
	public boolean getPOV(DirectionalPad pov) {
		return super.getPOV(pov.getValue()) == pov.getValue();
		
	}
	
	/**
	 * Get the value of the axis.
	 *
	 * @param axis The axis to read.
	 * @return The value of the axis.
	 */
	public double getRawAxis(Axes axis) {
	  return super.getRawAxis(axis.getValue());
	  
	}
	
	/**
	 * Sets the vibration motors of the Xbox controller.
	 * 
	 * @param type	The motor to vibrate. Left motor is rougher than right motor. Uses a RumbleType constant.
	 * @param value	The strength at which the motor vibrates in range [0, 1]
	 */
	public void setRumble(GenericHID.RumbleType type, double value) {
		super.setRumble(type, value);
		
	}

}
