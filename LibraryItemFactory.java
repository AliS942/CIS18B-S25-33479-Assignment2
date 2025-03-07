public class LibraryItemFactory {

    public static Item createItem(String type, String title, int publicationYear, String extraData) {
        if (type.equalsIgnoreCase("book")) {
            String[] data = extraData.split(",");
            return new Book(title, publicationYear, data[0], data[1]);
        } else if (type.equalsIgnoreCase("magazine")) {
            return new Magazine(title, publicationYear, Integer.parseInt(extraData));
        } else {
            return null;
        }
    }
}
