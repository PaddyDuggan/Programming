/**
 * 
 */
package p2;

/**
 * Smart Radiator - child/sub-class of Smart Device that inherits all of its properties
 * @author PatrickDuggan_40125560
 *
 */
public class SmartRadiator extends SmartDevice {

	// constants to represent business rules
	public static final double MIN_TEMP_NOW = -10;
	public static final double MAX_TEMP_NOW = 30;
	public static final double MIN_TEMP_TARGET = 5;
	public static final double MAX_TEMP_TARGET = 26;

	// instance vars
	private double tempNow;
	private double tempTarget;

	/**
	 * Default constructor
	 */
	public SmartRadiator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with args
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param powerState
	 * @param tempNow
	 * @param tempTarget
	 * @throws IllegalArgumentException - if current temperature or target temperature are invalid given business rules
	 */
	public SmartRadiator(String name, String manufacturer, Room room, PowerState powerState, double tempNow,
			double tempTarget) throws IllegalArgumentException {
		super(name, manufacturer, room, powerState);
		this.setTempNow(tempNow);
		this.setTempTarget(tempTarget);
	}

	/**
	 * Return method to obtain the target temperature of the current device
	 * @return the tempTarget
	 */
	public double getTempTarget() {
		return tempTarget;
	}

	/**
	 * Method to set the target temperature of a smart radiator
	 * @param tempTarget
	 * @throws IllegalArgumentException thrown if temperature is too low or too high given business rules (5-26)
	 */
	public void setTempTarget(double tempTarget) throws IllegalArgumentException {
		if (tempTarget >= MIN_TEMP_TARGET && tempTarget <= MAX_TEMP_TARGET) {
			this.tempTarget = tempTarget;
		} else {
			throw new IllegalArgumentException("Invalid temperature target");
		}

	}

	/**
	 * Return method to obtain the current temperature 
	 * @return the tempNow
	 */
	public double getTempNow() {
		return tempNow;
	}

	/**
	 * Method to set the current temperature associated with a specific radiator
	 * @param tempNow
	 * @throws IllegalArgumentException if temperature is too low or too high given business rules (-10 - 30)
	 */
	public void setTempNow(double tempNow) throws IllegalArgumentException {
		if (tempNow >= MIN_TEMP_NOW && tempNow <= MAX_TEMP_NOW && tempNow < this.tempTarget) {
			this.tempNow = tempNow;
			this.setPowerState(PowerState.ON);

		} else if (tempNow >= MIN_TEMP_NOW && tempNow <= MAX_TEMP_NOW && tempNow > this.tempTarget) {
			this.tempNow = tempNow;
			this.setPowerState(PowerState.OFF);
		} else {
			throw new IllegalArgumentException("Invalid current tempreature");
		}
	}

	/**
	 * Return method that shows the current status of the radiator object in a formatted String
	 * @return - status (String)
	 */
	public String status() {

		String name = this.getName().toUpperCase().replace(" ", "");

		String status = "SR-" + name + "-" + this.getRoom() + "-NOW:" + this.getTempNow() + "-TARGET:"
				+ this.getTempTarget() + "-" + this.getPowerState();

		return status;

	}

	/**
	 * Override method that prints to screen all details of a smart radiator 
	 * Includes a call to the super (SmartDevice) method
	 */
	@Override
	public void showAll() {
		super.showAll();
		System.out.println("TEMPNOW: " + this.tempNow);
		System.out.println("TEMPTARGET: " + this.tempTarget);
	}

}
