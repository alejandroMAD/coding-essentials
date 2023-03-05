
public abstract class Robot {
	
	private String name;
	private String serialNumber;
	private static int robotCount = 0;
	
	public Robot(String name, String serialNumber) {
		this.name = name;
		this.serialNumber = serialNumber;
		robotCount++;
	}

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

	public static int getRobotCount() {
		return robotCount;
	}
	
}
