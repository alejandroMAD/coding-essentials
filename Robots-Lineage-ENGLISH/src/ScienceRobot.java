
public abstract class ScienceRobot extends Robot {
	
	public ScienceRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", discipline=Science]";
	}

	public abstract String process(double inputNumber);

}
