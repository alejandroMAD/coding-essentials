
public abstract class ArtsRobot extends Robot {
	
	protected Behavior behavior;
	
	public static enum Behavior {
	    REGULAR, RANDOM
	}

	public ArtsRobot(String name, String serialNumber) {
		super(name, serialNumber);
		this.behavior = Behavior.REGULAR;
	}
	
	public ArtsRobot(String name, String serialNumber, Behavior behavior) {
		super(name, serialNumber);
		this.behavior = behavior;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", discipline=Arts]";
	}

}
