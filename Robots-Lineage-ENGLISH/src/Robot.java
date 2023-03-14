
/**
 * The abstract class Robot represents a robot object that has a name, a serial number,
 * and a static count of how many robots have been created. This class cannot be instantiated
 * and serves as a superclass or generic model for concrete robot classes.
 * 
 * @author Alejandro M. González
 *
 */
public abstract class Robot {
	
	private String name;
	private String serialNumber;
	private static int robotCount = 0;
	
	/**
	 * Constructs a new Robot object with the given name and serial number,
	 * and increments the robotCount.
	 * @param name         The name of the robot.
	 * @param serialNumber The serial number of the robot.
	 * */
	public Robot(String name, String serialNumber) {
		this.name = name;
		this.serialNumber = serialNumber;
		robotCount++;
	}

	/**
	 * Returns a String representation of the Robot object.
	 * */
	@Override
	public String toString() {
		return "I am a Robot of: [name=" + name + ", serialNumber=" + serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Returns the total number of robot objects that have been created.
	 * @return The total number of robot objects that have been created.
	 */
	public static int getRobotCount() {
		return robotCount;
	}
	
}
