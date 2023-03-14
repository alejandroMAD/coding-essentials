
/**
 * The ScienceRobot class represents a robot that is specialized in science-related tasks. 
 * It extends the Robot class and adds an abstract method process() that takes a double 
 * inputNumber and returns a String requiring all subclasses to implement this method.
 * The class overrides toString() to include the discipline of the robot as "Science".
 * 
 * The robot's name and serial number can be accessed or modified through its public
 * getter and setter methods. This class is abstract and cannot be instantiated on its own.
 * 
 * @author Alejandro M. González
 *
 */
public abstract class ScienceRobot extends Robot {
	
	/**
	 * Constructs a ScienceRobot object with the specified name and serial number.
	 * @param name         The name of the ScienceRobot.
	 * @param serialNumber The serial number of the ScienceRobot.
	 */
	public ScienceRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", discipline=Science]";
	}

	/**
	 * Processes a double input and returns a string result.
	 * @param inputNumber The double input to be processed.
	 * @return a string representing the result of processing the inputNumber.
    */
	public abstract String process(double inputNumber);

}
