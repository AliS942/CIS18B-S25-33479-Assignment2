// Base class Item
public class Item {
    protected String title;
    protected int publicationYear;

    public Item(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
