package modelo;

import java.sql.Timestamp;

/**
 * Modelo que representa a una entidad de préstamo de un libro por un lector en
 * la base de datos de la biblioteca, incluyendo el ID del préstamo, el Libro prestado,
 * el Lector prestatario, la fecha del préstamo, la fecha de la devolución del libro
 * y la penalización en días, si corresponde, en los casos de devolución con retraso.
 * 
 * Los atributos de un Prestamo están mapeados a los campos de la tabla `prestamo`
 * en la base de datos y guardan una relación de composición con objetos Libro y Lector
 * en el sistema.
 * 
 * @author Alejandro M. González
 */
public class Prestamo {
	
    private int prestamoId;
    private Libro libro;
    private Lector lector;
    private Timestamp fechaPrestamo;
    private Timestamp fechaDevolucion;
    private int diasPenalizacion;
    
    /**
     * Construye un nuevo objeto Prestamo con valores por defecto y díasPenalización=0.
     */
    public Prestamo() {
    	super();
    	this.diasPenalizacion = 0;
    }

    /**
     * Construye un nuevo objeto Prestamo con el id, libro, lector, fecha de préstamo,
     * fecha de devolución del préstamo y días de penalización especificados.
     *
     * @param prestamoId       El identificador único de este préstamo.
     * @param libro            El Libro que es objeto de este préstamo.
     * @param lector           El Lector que es sujeto de este préstamo.
     * @param fechaPrestamo    La fecha y hora de inicio de este préstamo.
     * @param fechaDevolucion  La fecha y hora en que se devolvió el Libro de este préstamo, 
     *                         o null si no se ha devuelto.
     * @param diasPenalizacion Los días de penalización por la devolución tardía de este préstamo.
     */
    public Prestamo(int prestamoId, Libro libro, Lector lector, 
    		Timestamp fechaPrestamo, Timestamp fechaDevolucion, int diasPenalizacion) {
    	
        this.prestamoId = prestamoId;
        this.libro = libro;
        this.lector = lector;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.diasPenalizacion = diasPenalizacion;
    }

	@Override
	public String toString() {
		return "Préstamo [préstamoId=" + prestamoId + ", libro=" + libro + ", lector=" + lector
				+ ", fechaPréstamo=" + fechaPrestamo + ", fechaDevolución=" + fechaDevolucion
				+ ", díasPenalización=" + diasPenalizacion + "]";
	}

	// Getters y setters
	public int getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(int prestamoId) {
		this.prestamoId = prestamoId;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Timestamp getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Timestamp fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Timestamp getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Timestamp fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public int getDiasPenalizacion() {
		return diasPenalizacion;
	}

	public void setDiasPenalizacion(int diasPenalizacion) {
		this.diasPenalizacion = diasPenalizacion;
	}
	
}

