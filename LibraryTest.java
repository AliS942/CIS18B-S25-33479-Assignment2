import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = Library.getInstance();

        // Create items using the factory
        Item book1 = LibraryItemFactory.createItem("book", "Java Programming", 2020, "John Doe,12345");
        Item book2 = LibraryItemFactory.createItem("book", "Effective Java", 2018, "Joshua Bloch,67890");
        Item magazine = LibraryItemFactory.createItem("magazine", "Tech Monthly", 2022, "12");

        // Add items to library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine);

        // Main menu
        while (true) {
            System.out.println("\nLibrary System:");
            System.out.println("1. List Available Items");
            System.out.println("2. Borrow Item");
            System.out.println("3. Return Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    library.listAvailableItems();
                    break;
                case 2:
                    System.out.print("Enter the title of the item to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Item itemToBorrow = library.findItemByTitle(borrowTitle);
                    if (itemToBorrow instanceof IBorrowable) {
                        System.out.print("Enter your name: ");
                        String borrower = scanner.nextLine();
                        ((IBorrowable) itemToBorrow).borrowItem(borrower);
                    } else {
                        System.out.println("Item not found or is not borrowable.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the item to return: ");
                    String returnTitle = scanner.nextLine();
                    Item itemToReturn = library.findItemByTitle(returnTitle);
                    if (itemToReturn instanceof IBorrowable) {
                        ((IBorrowable) itemToReturn).returnItem();
                    } else {
                        System.out.println("Item not found or is not borrowable.");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
