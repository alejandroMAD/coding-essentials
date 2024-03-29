package model;

import java.sql.Timestamp;

/**
 * A model class representing a record of a book borrowing by a reader in a library system, including
 * the borrowing id, the Book object, the Reader object, the borrowing date, the return date, and the
 * overdue penalty in days charged in case of a late return.
 * 
 * The Borrowing attributes are to be mapped to the fields in the table `borrowing` of the database and
 * are related to the objects Book and Reader of the system by means of composition.
 * 
 * @author Alejandro M. González
 */
public class Borrowing {
	
    private int borrowingId;
    private Book book;
    private Reader reader;
    private Timestamp borrowingDate;
    private Timestamp returnDate;
    private int overduePenalty;
    
    /**
     * Constructs a new Borrowing object with default values. The borrowing id
     * is set to 0, the book and reader are set to null, the borrowing and return dates
     * are set to null, and the overdue penalty is set to 0.
     */
    public Borrowing() {
    	super();
    	this.overduePenalty = 0;
    }

    /**
     * Constructs a new Borrowing object with the specified borrowing id, book, reader,
     * borrowing date, return date, and overdue penalty.
     *
     * @param borrowingId    The unique identifier of the borrowing
     * @param book           The book object that is borrowed
     * @param reader         The reader object who borrowed the book
     * @param borrowingDate  The date and time when the book was borrowed
     * @param returnDate     The date and time when the book was returned if it has already been returned, null otherwise
     * @param overduePenalty The amount of overdue penalty in days for returning the book late
     */
    public Borrowing(int borrowingId, Book book, Reader reader, 
    		Timestamp borrowingDate, Timestamp returnDate, int overduePenalty) {
    	
        this.borrowingId = borrowingId;
        this.book = book;
        this.reader = reader;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.overduePenalty = overduePenalty;
    }

	@Override
	public String toString() {
		return "Borrowing [borrowingId=" + borrowingId + ", book=" + book + ", reader=" + reader
				+ ", borrowingDate=" + borrowingDate + ", returnDate=" + returnDate
				+ ", overduePenalty=" + overduePenalty + "]";
	}

	// Getters and setters
	public int getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(int borrowingId) {
		this.borrowingId = borrowingId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Timestamp getBorrowingDate() {
		return borrowingDate;
	}

	public void setBorrowingDate(Timestamp borrowingDate) {
		this.borrowingDate = borrowingDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public int getOverduePenalty() {
		return overduePenalty;
	}

	public void setOverduePenalty(int overduePenalty) {
		this.overduePenalty = overduePenalty;
	}

}

