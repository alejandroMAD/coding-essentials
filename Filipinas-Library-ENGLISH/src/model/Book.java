package model;

/**
 * A model class representing a book entity in a library system. It stores information about the
 * book's ID, title, author, publication year, publisher, ISBN code, number of pages and availability.
 * The Book attributes are to be mapped to the fields in the table `book` of the database.
 * 
 * @author Alejandro M. González
 */
public class Book {
	
    private int bookId;
    private String title;
    private String author;
    private int publicationYear;
    private String publisher;
    private String isbn;
    private int numberOfPages;
    private boolean available;
    
    /**
     * Constructs a new book object with default values. The book is available by default.
     */
    public Book() {
		super();
		this.available = true;
	}

    /**
     * Constructs a new book object with the specified values.
     * @param bookId          The ID of the book.
     * @param title           The title of the book.
     * @param author          The author of the book.
     * @param publicationYear The publication year of the book.
     * @param publisher       The publisher of the book.
     * @param isbn            The ISBN character code of the book of length 13.
     * @param numberOfPages   The number of pages in the book.
     * @param available       The availability of the book, true if it's not borrowed, false otherwise.
    */
	public Book(int bookId, String title, String author, int publicationYear, 
    		String publisher, String isbn, int numberOfPages, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.available = available;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author
				+ ", publicationYear=" + publicationYear + ", publisher=" + publisher + ", isbn="
				+ isbn + ", numberOfPages=" + numberOfPages + ", available=" + available + "]";
	}
	
    // Getters and setters
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}


