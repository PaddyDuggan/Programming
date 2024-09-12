/**
 * 
 */
package p2;

/**
 * Smart Device object that acts as an abstract parent class for all devices within a smart home device monitoring and management application
 * @author PatrickDuggan_40125560
 *
 */
public abstract class SmartDevice {
	
	//constants to represent business rules
	public static final int MIN_NAME_LENGTH = 3;
	public static final int MAX_NAME_LENGTH = 20;
	public static final int MIN_MANUFACTURER_LENGTH = 3;
	public static final int MAX_MANUFACTURER_LENGTH = 20;

	
	//instance vars
	private String name;
	private String manufacturer;
	private Room room;
	private PowerState powerState;
	
	/**
	 * Default constructor
	 */
	
	public SmartDevice() {
		
	}
	
	/**
	 * Constructor with args
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param powerState
	 * @throws IllegalArgumentException thrown if name or manufacturer are invalid
	 */
	public SmartDevice(String name, String manufacturer, Room room, PowerState powerState) throws IllegalArgumentException {
		this.setName(name);
		this.setManufacturer(manufacturer);
		this.setRoom(room);
		this.setPowerState(powerState);
	}
	/**
	 * Return method to obtain the name of the current smart device
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to set the name of a smart device
	 * @param name
	 * @throws IllegalArgumentException thrown if name is invalid given the business rules
	 */
	public void setName(String name) throws IllegalArgumentException {
		if(name.length()>=MIN_NAME_LENGTH && name.length()<=MAX_NAME_LENGTH) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Invalid device name");
		}
		
	}
	/**
	 * Return method to obtain the manufacturer of the current smart device
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * Method to set the manufacturer of a smart device
	 * @param manufacturer
	 * @throws IllegalArgumentException thrown is manufacturer invalid given business rules
	 */
	public void setManufacturer(String manufacturer) throws IllegalArgumentException {
		if(manufacturer.length()>=MIN_MANUFACTURER_LENGTH && manufacturer.length()<=MAX_MANUFACTURER_LENGTH) {
			this.manufacturer = manufacturer;
		} else {
			throw new IllegalArgumentException("Invalid manufacturer name");
		}
		
	}
	
	/**
	 * Return method to obtain the room which the current smart device is located in
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * Method to set the room the smart device is located
	 * @param room
	 * @throws IllegalArgumentException thrown if room is null
	 */
	public void setRoom(Room room) throws IllegalArgumentException {
		if(room==null) {
			throw new IllegalArgumentException("Room cannot be null");
		} else {
			this.room = room;
		}
	}
	
	/**
	 * Return method to obtain the current power state of the smart device
	 * @return the powerState
	 */
	public PowerState getPowerState() {
		return powerState;
	}
	
	/**
	 * Method to set the power state (on/off) of the smart device
	 * @param powerState
	 * @throws IllegalArgumentException thrown if power state is null
	 */
	public void setPowerState(PowerState powerState) throws IllegalArgumentException {
		if(powerState==null) {
			throw new IllegalArgumentException("Power state cannot be null");
		} else {
			this.powerState = powerState;
		}
		
	}
	
	/**
	 * Void method that prints to screen all details of the smart device
	 */
	public void showAll() {
		System.out.println("NAME: "+this.name);
		System.out.println("MANUFACTURER: "+this.manufacturer);
		System.out.println("ROOM: "+this.room);
		System.out.println("POWERSTATE: "+this.powerState);
	}

}
