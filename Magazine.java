// Subclass Magazine
public class Magazine extends Item {
    private int issueNumber;

    public Magazine(String title, int publicationYear, int issueNumber) {
        super(title, publicationYear);
        this.issueNumber = issueNumber;
    }

    // Getter method
    public int getIssueNumber() {
        return issueNumber;
    }
}