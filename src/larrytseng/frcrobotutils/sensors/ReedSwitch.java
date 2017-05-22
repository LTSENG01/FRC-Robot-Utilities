package larrytseng.frcrobotutils.sensors;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class ReedSwitch extends Trigger {

	private DigitalInput reedSwitch;
	private Command command;
	
	public ReedSwitch(int port) {
		this.reedSwitch = new DigitalInput(port);
		
	}
	
	public ReedSwitch(int port, Command command) {
		this.reedSwitch = new DigitalInput(port);
		this.command = command;
		
	}
	
	@Override
	public boolean get() {
		return reedSwitch.get();
		
	}
	
}
