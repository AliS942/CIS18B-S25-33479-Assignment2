import java.util.ArrayList;

// Singleton Library Class
public class Library {
    private static Library instance;
    private ArrayList<Item> items;

    private Library() {
        items = new ArrayList<>();
    }

    // Get the singleton instance
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Add item to library
    public void addItem(Item item) {
        items.add(item);
    }

    // List available items
    public void listAvailableItems() {
        System.out.println("Available items:");
        for (Item item : items) {
            if (item instanceof IBorrowable && !((IBorrowable) item).isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    // Find an item by title
    public Item findItemByTitle(String title) {
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}
