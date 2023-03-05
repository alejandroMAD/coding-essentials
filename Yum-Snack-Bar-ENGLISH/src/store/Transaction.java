package store;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import products.Product;

/**
 * A class representing a transaction in the store, which includes a unique ID,
 * a timestamp, a list of purchased products, and the total cost of the transaction.
 * 
 * This class implements the Comparable interface so transactions can be compared based
 * on their total cost.
 * 
 * @author Alejandro M. González
 */
public class Transaction implements Comparable<Transaction> {

	private final int ID;
	private LocalDateTime timestamp;
	private List<Product> items;
	private double totalCost;

	/**
	 * Constructs a new transaction with the given ID and list of purchased products.
	 * The Transaction timestamp is set to the current time.
	 * @param id the ID of the transaction
	 * @param products the list of purchased products
	 */
	public Transaction(int id, List<Product> products) {
		this.ID = id;
		this.timestamp = LocalDateTime.now();
		this.items = new ArrayList<>(products);
		this.totalCost = calculateTotalCost();
	}

	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ",\n\tformattedTimestamp=" + getFormattedTimestamp()
				+ ",\n\titems=" + items + ",\n\ttotalCost=" + totalCost + "]";
	}

	/**
	 * Adds a new item to the list of purchased products and updates the total cost accordingly.
	 * @param item the item to add to the list of purchased products
	 */
	public void addItem(Product item) {
		items.add(item);
		totalCost += item.getPrice();
	}

	/**
	 * Calculates and returns the total cost of the transaction based on the list of purchased products.
	 * @return the total cost of the transaction
	 */
	private double calculateTotalCost() {
		double cost = 0;

		for (Product item : items) {
			cost += item.getPrice();
		}

		return cost;
	}

	/**
	 * Compares this transaction to another transaction based on their total cost.
	 * @param other The other transaction to compare to
	 * @return 1 if this transaction's total cost is greater than the other transaction's total cost,
	 * 			 -1 if this transaction's total cost is less than the other transaction's total cost,
	 * 			 or 0 if they have the same total cost
	 */
	@Override
	public int compareTo(Transaction other) {
		if (this.totalCost > other.totalCost) {
			return 1;
		} else if (this.totalCost < other.totalCost) {
			return -1;
		}
		return 0;
	}

	public int getID() {
		return ID;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Returns the timestamp of the transaction in a formatted string representation.
	 * @return A string representation of the transaction timestamp in the format "dd/MM/yyyy-HH:mm:ss".
	 */
	public String getFormattedTimestamp() {
		return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss"));
	}

}
