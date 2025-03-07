// Subclass Book
public class Book extends Item implements IBorrowable {
    private String author;
    private String ISBN;
    private String borrower;

    public Book(String title, int publicationYear, String author, String ISBN) {
        super(title, publicationYear);
        this.author = author;
        this.ISBN = ISBN;
        this.borrower = null;
    }

    // Getter methods
    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    // Implement the IBorrowable methods
    @Override
    public void borrowItem(String borrower) {
        if (this.borrower == null) {
            this.borrower = borrower;
            System.out.println(title + " has been borrowed by " + borrower);
        } else {
            System.out.println("Sorry, " + title + " is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        this.borrower = null;
        System.out.println(title + " has been returned.");
    }

    @Override
    public boolean isBorrowed() {
        return borrower != null;
    }
}