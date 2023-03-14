
/**
 * A subclass of ArtsRobot that provides methods for drawing various shapes such as
 * a square, rhombus, and triangle on the console output. It has two constructors:
 * one that takes a name and serial number as parameters, and another that also takes
 * a behavior. It also provides an enum Shape that defines the available shapes.
 * 
 * @author Alejandro M. González
 *
 */
public final class PainterRobot extends ArtsRobot {

	/**
	 * Constructs a new PainterRobot with the specified name and serial number.
	 * @param name         The name of the robot
	 * @param serialNumber The serial number of the robot
	 */

	public PainterRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}
	
	/**
	 * Creates a new PainterRobot object with the specified name, serial number, and behavior.
	 * @param name         The name of the robot
	 * @param serialNumber The serial number of the robot
	 * @param behavior     The behavior of the robot, either ArtsRobot.Behavior.REGULAR 
	 *        or ArtsRobot.Behavior.RANDOM; it determines the output of the draw() method.
	 */
	public PainterRobot(String name, String serialNumber, Behavior behavior) {
		super(name, serialNumber, behavior);
	}
	
	/**
	 * An enumeration representing different geometric shapes that
	 * a PainterRobot can draw: SQUARE, RHOMBUS, and TRIANGLE.
	 */
	public static enum Shape {
	    SQUARE, RHOMBUS, TRIANGLE
	}

	/**
	 * Draws a geometric shape with a given height and character in the console output.
	 * The type of shape drawn depends on the behavior of the robot. If the behavior
	 * is REGULAR, the method draws the specified shape of the specified height an character.
	 * If the behavior is random, the method ignores the arguments and draws a random shape
	 * of a random height between 2 and 12 lines of height and a random character.
	 * @param shape     The shape to be drawn (SQUARE, RHOMBUS, or TRIANGLE)
	 * @param height    The height of the shape to be drawn in lines of console output
	 */
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
			int randomAsciiCode = (int) (Math.random() * 95 + 33); 
			
	        switch (randomCase) {
	            case 1:
	        		drawTriangle(randomHeight, (char) randomAsciiCode);
	        		break;
	            case 2:
		            drawSquare(randomHeight, (char) randomAsciiCode);
		            break;
	            case 3:
		            drawRhombus(randomHeight, (char) randomAsciiCode);
		            break;
	        }
		}
	}
	
	/**
	 * Draws a triangle shape with the specified height and character.
	 * @param height    The height of the triangle to be drawn in lines of console output
	 * @param character The character to be used to draw the triangle
	 */
	private void drawTriangle(int height, char character) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}

	/**
	 *  Draws a square shape with the specified height and character.
	 *  @param height    The height of the square to be drawn in lines of console output
	 *  @param character The character to be used to draw the square
	 */
	private void drawSquare(int height, char character) {
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < height; j++) {
	            System.out.print(character + " ");
	        }
	        System.out.println();
	    }
	}
	
	/**
	 *  Draws a rhombus shape with the specified height and character.
	 *  @param height    The height of the rhombus to be drawn in lines of console output
	 *  @param character The character to be used to draw the rhombus
	 */
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
