
/**
 * The ArtsRobot class represents a robot that is specialized in arts-related tasks. 
 * It extends the Robot class and adds a Behavior property that indicates how the robot 
 * behaves when performing its tasks. The class also overrides the toString() method 
 * to include the discipline of the robot as "Arts".
 * 
 * The robot's name and serial number can be accessed or modified through its public
 * getter and setter methods. This class is abstract and cannot be instantiated on its own.
 * 
 * @author Alejandro M. González
 *
 */
public abstract class ArtsRobot extends Robot {
	
	protected Behavior behavior;
	
	/**
	 * Enum that represents the behavior of an ArtsRobot, eighter REGULAR or RANDOM.
	 */
	public static enum Behavior {
		REGULAR, RANDOM
	}

	/**
	 * Constructs an ArtsRobot with the given name and serial number, setting
	 * its behavior to REGULAR by default.
	 * @param name         The name of the ArtsRobot
	 * @param serialNumber The serial number of the ArtsRobot
	 */
	public ArtsRobot(String name, String serialNumber) {
		super(name, serialNumber);
		this.behavior = Behavior.REGULAR;
	}
	
	/**
	 * Constructs an ArtsRobot with the given name, serial number, and behavior.
	 * @param name         The name of the ArtsRobot
	 * @param serialNumber The serial number of the ArtsRobot
	 * @param behavior     The behavior of the ArtsRobot
	 */
	public ArtsRobot(String name, String serialNumber, Behavior behavior) {
		super(name, serialNumber);
		this.behavior = behavior;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", discipline=Arts]";
	}

}
