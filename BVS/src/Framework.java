import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Framework {

    static Storage storage = new Storage();
    static Interface userInterface = new Interface();


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();


        Book testBook = new Book("123", "bla", 2003, "bla", "bla ", 11, list);

        storage.addBook(testBook);
        System.out.println(storage.searchBook("123").getIsbn());
        Interface.startInterface();

    }

    public static void deleteBook(String input) {
        try {
            System.out.println(input);
            Book book = storage.searchBook(input);
            storage.deleteBook(book);
            System.out.println("Book deleted succesfully");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}