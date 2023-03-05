package products;

/**
 * This exception is thrown when an illegal size is provided for a product
 * according to the business rules.
 * 
 * @author Alejandro M. González
 */
public class IllegalSizeException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param errorMessage the detail message of the exception.
     */
    public IllegalSizeException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * 
     * @param errorMessage the detail message of the exception.
     * @param cause        the cause of the exception.
     */
    public IllegalSizeException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    /**
     * Constructs a new exception with the specified cause.
     * 
     * @param cause the cause of the exception.
     */
    public IllegalSizeException(Throwable cause) {
        super(cause);
    }
}
