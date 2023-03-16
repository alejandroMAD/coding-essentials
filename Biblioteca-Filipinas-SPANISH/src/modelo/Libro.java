package modelo;

/**
 * Modelo que representa a una entidad de libro en la base de datos de la biblioteca.
 * Almacena información sobre el ID, título, autor, año de edición, editor, código
 * ISBN, número de páginas y disponibilidad de libro.

 * Los atributos de Libro están mapeados a los campos de la tabla `libro` en la base de datos.
 * 
 * @author Alejandro M. González
 */
public class Libro {
	
    private int libroId;
    private String titulo;
    private String autor;
    private int fechaEdicion;
    private String editor;
    private String isbn;
    private int numeroPaginas;
    private boolean disponible;
    
    /**
     * Construye un nuevo objeto Libro con valores por defecto y disponible=true.
     */
    public Libro() {
		super();
		this.disponible = true;
	}

    /**
     * Construye un nuevo objeto Libro con los valores especificados.
     * @param libroId       El identificador único de este libro.
     * @param titulo        El título de este libro.
     * @param autor         El autor de este libro.
     * @param fechaEdicion  El año de edición de este libro.
     * @param editor        El editor de este libro.
     * @param isbn          El código ISBN de 13 caracteres de este libro.
     * @param numeroPaginas El número de páginas de este libro.
     * @param disponible    La disponibilidad de este libro, true si no está actualmente
     *                      prestado, false en caso contrario.
    */
	public Libro(int libroId, String titulo, String autor, int fechaEdicion, 
    		String editor, String isbn, int numeroPaginas, boolean disponible) {
        this.libroId = libroId;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaEdicion = fechaEdicion;
        this.editor = editor;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.disponible = disponible;
    }

	@Override
	public String toString() {
		return "Libro [libroId=" + libroId + ", título=" + titulo + ", autor=" + autor
				+ ", fechaEdición=" + fechaEdicion + ", editor=" + editor + ", ISBN="
				+ isbn + ", númeroPáginas=" + numeroPaginas + ", disponible=" + disponible + "]";
	}

    // Getters y setters
	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(int fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}


