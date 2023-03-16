package modelo;

/**
 * Modelo de una biblioteca que almacena información sobre su nombre, dirección,
 * número de teléfono y normas básicas de funcionamiento tales como el periodo
 * máximo de duración de los préstamos de libros y la penalización en días por
 * cada día de retraso en la devolución de un préstamo.
 * 
 * @author Alejandro M. González
 */
public class Biblioteca {
	
	private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private int diasPrestamo;
    private int diasPenalizacion;
    
    /**
     * Construye un nuevo objeto Biblioteca con el id, nombre, dirección, teléfono
     * y reglas de funcionamiento especificado en cuanto al periodo de préstamo y
     * los días de penalización por cada día de retraso en la devolución de un préstamo.
     * @param id               El identificador único de la biblioteca
     * @param nombre           El nombre de la biblioteca
     * @param direccion        La dirección de la biblioteca
     * @param telefono         El número de teléfono de la biblioteca
     * @param diasPrestamo     El periodo máximo de préstamo de un libro en días
     * @param diasPenalizacion La penalización en días por número de días de retraso en una devolución
     */
	public Biblioteca(int id, String nombre, String direccion, String telefono, 
			int diasPrestamo, int diasPenalizacion) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.diasPrestamo = diasPrestamo;
		this.diasPenalizacion = diasPenalizacion;
	}

	@Override
	public String toString() {
		return "Biblioteca [id=" + id + ", nombre=" + nombre + ", dirección=" + direccion 
				+ ", teléfono=" + telefono + ", díasPréstamo=" + diasPrestamo
				+ ", díasPenalización=" + diasPenalizacion + "]";
	}

	// Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getDiasPrestamo() {
		return diasPrestamo;
	}

	public void setDiasPrestamo(int diasPrestamo) {
		this.diasPrestamo = diasPrestamo;
	}

	public int getDiasPenalizacion() {
		return diasPenalizacion;
	}

	public void setDiasPenalizacion(int diasPenalizacion) {
		this.diasPenalizacion = diasPenalizacion;
	}
	
}

