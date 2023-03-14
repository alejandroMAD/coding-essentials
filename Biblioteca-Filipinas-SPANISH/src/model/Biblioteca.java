package model;

/**
 * Represents a Library entity that holds information about a library's name, address,
 * phone number, and the rules of borrowing period in days and late return penalty in days.
 * 
 * @author Alejandro M. González
 */
public class Biblioteca {
	
	private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private int borrowPeriodDays;
    private int lateReturnPenaltyDays;
    
    /**
     * Constructs a new Library object with the specified id, name, address, phone number,
     * and business logic rules of borrowing period in days and late return penalty in days.
     * @param id                    The ID of the library
     * @param name                  The name of the library
     * @param address               The address of the library
     * @param phoneNumber           The phone number of the library
     * @param borrowPeriodDays      The borrowing period of each library book in days
     * @param lateReturnPenaltyDays The penalty for a book late return in days per day of late return
     */
	public Biblioteca(int id, String name, String address, String phoneNumber, int borrowPeriodDays,
			int lateReturnPenaltyDays) {
		
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.borrowPeriodDays = borrowPeriodDays;
		this.lateReturnPenaltyDays = lateReturnPenaltyDays;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", borrowPeriodDays=" + borrowPeriodDays
				+ ", lateReturnPenaltyDays=" + lateReturnPenaltyDays + "]";
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getBorrowPeriodDays() {
		return borrowPeriodDays;
	}

	public void setBorrowPeriodDays(int borrowPeriodDays) {
		this.borrowPeriodDays = borrowPeriodDays;
	}

	public int getLateReturnPenaltyDays() {
		return lateReturnPenaltyDays;
	}

	public void setLateReturnPenaltyDays(int lateReturnPenaltyDays) {
		this.lateReturnPenaltyDays = lateReturnPenaltyDays;
	}
	
}

