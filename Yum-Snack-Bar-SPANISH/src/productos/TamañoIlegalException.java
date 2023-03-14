package productos;

/**
 * Esta excepción es arrojada cuando se emplea un tamaño no permitido para
 * un producto de acuerdo con las reglas del negocio.
 * 
 * @author Alejandro M. González
 */
public class TamañoIlegalException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construye una nueva excepción con el mensaje informativo especificado.
     * 
     * @param mensajeError el mensaje informativo de la excepción
     */
    public TamañoIlegalException(String mensajeError) {
        super(mensajeError);
    }

    /**
     * Construye una nueva excepción con el mensaje informativo y causa especificados.
     * 
     * @param mensajeError el mensaje informativo de la excepción
     * @param causa        la causa de la excepción
     */
    public TamañoIlegalException(String mensajeError, Throwable causa) {
        super(mensajeError, causa);
    }

    /**
     * Construye una nueva excepción con la causa especificada.
     * 
     * @param causa la causa de la excepción
     */
    public TamañoIlegalException(Throwable causa) {
        super(causa);
    }
}
