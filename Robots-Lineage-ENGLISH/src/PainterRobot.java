
public final class PainterRobot extends ArtsRobot {

	public PainterRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}
	
	public PainterRobot(String name, String serialNumber, Behavior behavior) {
		super(name, serialNumber, behavior);
	}
	
	public static enum Shape {
	    SQUARE, RHOMBUS, TRIANGLE
	}

	public void draw(Shape shape, int height, char character) {
		if (this.behavior.equals(ArtsRobot.Behavior.REGULAR)) {
		    switch(shape) {
	        	case TRIANGLE:
	        		drawTriangle(height, character);
	        		break;
		        case SQUARE:
		            drawSquare(height, character);
		            break;
		        case RHOMBUS:
		            drawRhombus(height, character);
		            break;
		        default:
		            System.out.println("Invalid shape");
		            break;
		    }
		} else if (this.behavior.equals(ArtsRobot.Behavior.RANDOM)) {
			int randomCase = (int) (Math.random() * 3 + 1);
			int randomHeight = (int) (Math.random() * 12 + 2);
			int randomASCIIcode = (int) (Math.random() * 95 + 33); 
			
	        switch (randomCase) {
	            case 1:
	        		drawTriangle(randomHeight, (char) randomASCIIcode);
	        		break;
	            case 2:
		            drawSquare(randomHeight, (char) randomASCIIcode);
		            break;
	            case 3:
		            drawRhombus(randomHeight, (char) randomASCIIcode);
		            break;
	        }
		}
	}
	
	private void drawTriangle(int height, char character) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}

	private void drawSquare(int height, char character) {
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < height; j++) {
	            System.out.print(character + " ");
	        }
	        System.out.println();
	    }
	}
	
	private void drawRhombus(int height, char character) {
	    int rhombusHeight = height % 2 == 0 ? height + 1 : height;
	    
	    for (int i = 1; i <= rhombusHeight / 2 + 1; i++) {
	        for (int j = rhombusHeight / 2 + 1 - i; j > 0; j--) {
	            System.out.print(" ");
	        }
	        for (int j = 1; j <= 2 * i - 1; j++) {
	            System.out.print(character);
	        }
	        System.out.println();
	    }
	    for (int i = rhombusHeight / 2; i >= 1; i--) {
	        for (int j = rhombusHeight / 2 + 1 - i; j > 0; j--) {
	            System.out.print(" ");
	        }
	        for (int j = 1; j <= 2 * i - 1; j++) {
	            System.out.print(character);
	        }
	        System.out.println();
	    }
	}

}
