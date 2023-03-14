package model;

import java.time.LocalDate;

/**
 * A model class representing a reader entity in a library system. It stores information about the
 * reader's ID, first name, last name, email, phone number, date of birth, the number of books
 * he currently holds on borrowing and the accumulated penalty count in days if applicable.
 * The Reader attributes are to be mapped to the fields in the table `reader` of the database.
 * 
 * @author Alejandro M. González
 */
public class Lector {
	
    private int readerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private int borrowedBooks;
    private int penaltyCount;
    
    /**
     * Constructs a new Reader object with default values for the borrowed books count and penalty count.
     */
    public Lector() {
		super();
		this.borrowedBooks = 0;
		this.penaltyCount = 0;
	}

    /**
     * Constructs a new Reader object with the specified reader ID, first name, last name, email, 
     * phone number, date of birth, borrowed books, and penalty count.
     * 
     * @param readerId      The unique identifier for this reader
     * @param firstName     The first name of this reader
     * @param lastName      The last name of this reader
     * @param email         The email address of this reader
     * @param phoneNumber   The phone number of this reader
     * @param dateOfBirth   The date of birth of this reader
     * @param borrowedBooks The number of books this reader currently has borrowed
     * @param penaltyCount  The number of days of penalty prohibiting borrowing this reader currently has
     */
	public Lector(int readerId, String firstName, String lastName, String email, 
    		String phoneNumber, LocalDate dateOfBirth, int borrowedBooks, int penaltyCount) {
        this.readerId = readerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.borrowedBooks = borrowedBooks;
        this.penaltyCount = penaltyCount;
    }

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", dateOfBirth="
				+ dateOfBirth + ", borrowedBooks=" + borrowedBooks + ", penaltyCount="
				+ penaltyCount + "]";
	}

    // Getters and setters
	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public int getPenaltyCount() {
		return penaltyCount;
	}

	public void setPenaltyCount(int penaltyCount) {
		this.penaltyCount = penaltyCount;
	}

}


