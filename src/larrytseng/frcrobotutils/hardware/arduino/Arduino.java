package larrytseng.frcrobotutils.hardware.arduino;

import edu.wpi.first.wpilibj.I2C;

/**
 * Two-way communication between an arduino through {@link edu.wpi.first.wpilibj.I2C} on any roboRIO I2C port.
 * 
 * @author Larry Tseng
 * 
 */
public class Arduino implements I2CDevice {
	
	private I2C arduino;
	
	/**
	 * Constructs an arduino connection with its port and the arduino-defined address.
	 * 
	 * @param port The roboRIO I2C port where the arduino is connected on.
	 * @param address The address of the arduino as defined by the arduino.
	 */
	public Arduino(I2C.Port port, int address) {
		arduino = new I2C(port, address);
		
	}
	
	/**
	 * Tests the connection of the arduino device on the {@link I2C} port. 
	 * 
	 * The result is inverted because false indicated a successful connection and true indicated a failure.
	 * 
	 * @return Whether or not the connection was successful. Returns false for a failure, true for success.
	 */
	public boolean verifyConnection() {
		return !arduino.addressOnly();
		
	}
	
	/**
	 * Reads a number of bytes from the arduino at the specified register address.
	 * 
	 * @param registerAddress The address of the register to read the bytes from.
	 * @param count The number of bytes to read from the arduino.
	 * @return An array of bytes read from the arduino.
	 */
	public byte[] read(int registerAddress, int count) {
		byte[] buffer = new byte[count];
		arduino.read(registerAddress, count, buffer);
		return buffer;
		
	}
	
	/**
	 * Reads a number of bytes from the arduino into a provided byte array. No need to send data first to the arduino.
	 * 
	 * The result is inverted because false indicated a successful connection and true indicated a failure.
	 * 
	 * @param buffer A pointer to the array of bytes to store the data read from the device.
	 * @param count The number of bytes to read in the transaction.
	 * @return Whether or not the connection was successful. Returns false for a failure, true for success.
	 */
	public boolean readOnly(byte[] buffer, int count) {
		return !arduino.readOnly(buffer, count);
	}
	
	/**
	 * Writes an int to the arduino to the specified register address. 
	 * 
	 * The result is inverted because false indicated a successful connection and true indicated a failure.
	 * 
	 * @param registerAddress The address of the register to write the int to.
	 * @param data The int that is to be written to the arduino.
	 * @return Whether or not the connection was successful. Returns false for a failure, true for success.
	 */
	public boolean write(int registerAddress, int data) {
		return !arduino.write(registerAddress, data);
	}
	
	/**
	 * Write an array of bytes to the arduino. 
	 * 
	 * @param data The byte array of data that is to be written to the arduino.
	 * @return Whether or not the connection was successful. Returns false for a failure, true for success.
	 */
	public boolean write(byte[] data) {
		return !arduino.writeBulk(data);
		
	}
	
	//Todo: ByteBuffer? and method to pack large data into bytes.

}
