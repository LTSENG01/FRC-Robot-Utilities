package larrytseng.frcrobotutils.arduino;

import edu.wpi.first.wpilibj.I2C;

/**
 * Todo: documentation
 * 
 * @author Larry Tseng
 *
 */
public class Arduino {
	
	private I2C arduino;
	
	/**
	 * 
	 * @param port
	 * @param address
	 */
	public Arduino(I2C.Port port, int address) {
		arduino = new I2C(port, address);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean verifyConnection() {
		return arduino.addressOnly();
		
	}
	
	/**
	 * 
	 * @param registerAddress
	 * @param count
	 * @return
	 */
	public byte[] read(int registerAddress, int count) {
		byte[] buffer = new byte[count];
		arduino.read(registerAddress, count, buffer);
		return buffer;
		
	}
	
	/**
	 * 
	 * @param buffer
	 * @param count
	 * @return
	 */
	public boolean readOnly(byte[] buffer, int count) {
		return arduino.readOnly(buffer, count);
	}
	
	/**
	 * 
	 * @param registerAddress
	 * @param data
	 * @return
	 */
	public boolean write(int registerAddress, int data) {
		return arduino.write(registerAddress, data);
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public boolean write(byte[] data) {
		return arduino.writeBulk(data);
		
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public byte[] packData(Object[] data) {
		byte[] array = new byte[data.length];
		for (int i = 0; i < data.length; i++) {
			array[i] = (byte) data[i];
		}
		return array;
		
	}

}
