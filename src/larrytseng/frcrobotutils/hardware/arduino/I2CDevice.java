package larrytseng.frcrobotutils.hardware.arduino;

/**
 * Interface for I2C communicating devices on the roboRIO.
 * 
 * @see {@link larrytseng.frcrobotutils.arduino.Arduino}
 * @author Larry Tseng
 *
 */
public interface I2CDevice {
	
	boolean verifyConnection();
	
	byte[] read(int registerAddress, int count);
	
	boolean readOnly(byte[] buffer, int count);
	
	boolean write(int registerAddress, int data);
	
	boolean write(byte[] data);
	
}
