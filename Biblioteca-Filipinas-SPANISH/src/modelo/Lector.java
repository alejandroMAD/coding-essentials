package modelo;

import java.time.LocalDate;

/**
 * Modelo que representa a una entidad de lector en la base de datos de la biblioteca.
 * Almacena información sobre el ID, nombre, apellido, email, número de teléfono, fecha
 * de nacimiento, el número de libros que el lector actualmente tiene prestados y la
 * penalización acumulada en días si corresponde.
 * 
 * Los atributos de Lector están mapeados a los campos de la tabla `lector` en la base de datos.
 * 
 * @author Alejandro M. González
 */
public class Lector {
	
    private int lectorId;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private int librosPrestados;
    private int diasPenalizacion;
    
    /**
     * Construye un nuevo objeto Lector con valores por defecto para los atributos
     * de libros prestados y días de penalización acumulados.
     */
    public Lector() {
		super();
		this.librosPrestados = 0;
		this.diasPenalizacion = 0;
	}

    /**
     * Construye un nuevo objeto Lector con el ID, nombre, apellido, email, número de
     * teléfono, fecha de nacimiento, número de libros prestados y número de días de
     * penalización especificados.
     * 
     * @param lectorId         El identificador único de este lector
     * @param nombre           El nombre de este lector
     * @param apellido         El apellido de este lector
     * @param email            La dirección de email de este lector
     * @param telefono         El número de teléfono de este lector
     * @param fechaNacimiento  La fecha de nacimiento de este lector
     * @param librosPrestados  El número de libros que este lector tiene actualmente prestados
     * @param diasPenalizacion El número de días de penalización acumulados de este lector
     */
	public Lector(int lectorId, String nombre, String apellido, String email, String telefono,
			LocalDate fechaNacimiento, int librosPrestados, int diasPenalizacion) {
        this.lectorId = lectorId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.librosPrestados = librosPrestados;
        this.diasPenalizacion = diasPenalizacion;
    }

	@Override
	public String toString() {
		return "Lector [lectorId=" + lectorId + ", nombre=" + nombre + ", apellido="
				+ apellido + ", email=" + email + ", teléfono=" + telefono + ", fechaNacimiento="
				+ fechaNacimiento + ", librosPrestados=" + librosPrestados + ", díasPenalización="
				+ diasPenalizacion + "]";
	}

    // Getters y setters
	public int getLectorId() {
		return lectorId;
	}

	public void setLectorId(int lectorId) {
		this.lectorId = lectorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(int librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	public int getDiasPenalizacion() {
		return diasPenalizacion;
	}

	public void setDiasPenalizacion(int diasPenalizacion) {
		this.diasPenalizacion = diasPenalizacion;
	}

}


