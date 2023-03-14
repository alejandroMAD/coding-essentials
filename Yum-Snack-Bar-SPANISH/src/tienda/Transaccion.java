package tienda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import productos.Producto;

/**
 * Una clase que representa una transacción o compra por un cliente de la tienda
 * e incluye un identificador o ID único, la fecha y hora de la transacción, la
 * lista de productos comprados por el cliente y el precio total de la transacción.
 * 
 * El precio total se calcula invocando el método getter del precio de la clase Producto
 * por cada ítem de la lista de productos.
 * 
 * Esta clase implementa la interfaz Comparable de manera que las transacciones
 * pueden ser comparadas con base en su precio total.
 * 
 * @author Alejandro M. González
 */
public class Transaccion implements Comparable<Transaccion> {

	private final int ID;
	private LocalDateTime fechaHora;
	private List<Producto> items;
	private double precioTotal;

	/**
	 * Construye una nueva transacción con el ID y lista de productos especificados.
	 * La fecha y hora del objeto Transaccion se fijan con arreglo a la hora actual del sistema.
	 * @param id        el ID de la transacción
	 * @param productos la lista de productos comprados
	 */
	public Transaccion(int id, List<Producto> productos) {
		this.ID = id;
		this.fechaHora = LocalDateTime.now();
		this.items = new ArrayList<>(productos);
		this.precioTotal = calcularPrecioTotal();
	}

	@Override
	public String toString() {
		return "Transacción [ID=" + ID + ",\n\tformattedTimestamp=" + getFechaHoraFormateadas()
				+ ",\n\títems=" + items + ",\n\tprecioTotal=" + precioTotal + "]";
	}

	/**
	 * Añade un ítem a la lista de productos comprados y actualiza el precio total en consecuencia.
	 * @param item el ítem que será añadido a la lista de productos comprados
	 */
	public void añadirItem(Producto item) {
		items.add(item);
		precioTotal += item.getPrecio();
	}

	/**
	 * Calcula y devuelve el precio total de la transacción basado en la lista de productos comprados.
	 * @return el precio total de la transacción
	 */
	private double calcularPrecioTotal() {
		double precioTotal = 0;

		for (Producto item : items) {
			precioTotal += item.getPrecio();
		}

		return precioTotal;
	}

	/**
	 * Compara este objeto Transaccion con otro objeto Transaccion con base en su precio total.
	 * @param otraTransaccion La otra Transaccion especificada para realizar la comparación
	 * @return 1 si el precio total de esta Transaccion es mayor que el de la otra Transaccion,
	 * 			 -1 si el precio total de esta Transaccion es menor que el de la otra Transaccion
	 * 			 o 0 si ambas transacciones tienen el mismo precio total.
	 */
	@Override
	public int compareTo(Transaccion otraTransaccion) {
		if (this.precioTotal > otraTransaccion.precioTotal) {
			return 1;
		} else if (this.precioTotal < otraTransaccion.precioTotal) {
			return -1;
		}
		return 0;
	}

	public int getID() {
		return ID;
	}

	public List<Producto> getItems() {
		return items;
	}

	public void setItems(List<Producto> items) {
		this.items = items;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * Devuelve la fecha y hora de esta Transaccion en un String formateado.
	 * @return La representación en String de la fecha y hora de esta Transaccion 
	 *         con el formato "dd/MM/aaaa-HH:mm:ss"
	 */
	public String getFechaHoraFormateadas() {
		return fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss"));
	}

}
