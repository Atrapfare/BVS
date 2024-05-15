import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

public class Control {

    UI ui;
    Storage storage;

    public Control(Storage storage) {
        this.ui = new UI(this);
        this.storage = new Storage(new ArrayList<Book>(), new ArrayList<BookCopy>(), new ArrayList<Customer>());
    }


    public void run() {
        generateSamples();
        ui.startUI();
    }


    public void generateSamples() {
        ArrayList<String> authors = new ArrayList<>(); // Sample list for authors

        Book book1 = new Book("123-456-789", "Sample Book 1", 1978, "Stuttgart", "Klett", 1, authors);
        Book book2 = new Book("123-789-456", "Sample Book 2", 1980, "Berlin", "Duden", 2, authors);
        Book book3 = new Book("789-456-123", "Sample Book 3", 2003, "Filderstadt", "Kosmos", 3, authors);

        storage.addBook(book1);
        storage.addBook(book2);
        storage.addBook(book3);

        BookCopy bookCopy1 = new BookCopy(12345, book1, "Shelf 1", new Date(), false, new Date());
        BookCopy bookCopy2 = new BookCopy(12362, book1, "Shelf 1", new Date(), true, new Date());
        BookCopy bookCopy3 = new BookCopy(12163, book2, "Shelf 2", new Date(), true, new Date());
        BookCopy bookCopy4 = new BookCopy(12546, book3, "Shelf 3", new Date(), false, new Date());

        storage.addBookCopy(bookCopy1);
        storage.addBookCopy(bookCopy2);
        storage.addBookCopy(bookCopy3);
        storage.addBookCopy(bookCopy4);


        Customer lena = new Customer(261523, "Schwarz", "Lena", "Vivaldiweg 36", "70195", "Stuttgart", true, new ArrayList<>());
        ArrayList<BookCopy> petersLend = new ArrayList<>();
        petersLend.add(bookCopy1);
        petersLend.add(bookCopy3);
        Customer peter = new Customer(261523, "Kohler", "Peter", "Schwarzweg 49", "70199", "Vaihingen", false, petersLend);
        ArrayList<BookCopy> lanasLend = new ArrayList<>();
        petersLend.add(bookCopy2);
        petersLend.add(bookCopy4);
        Customer lana = new Customer(234421, "Möhrke", "Lana", "Korelliweg 34", "70199", "Vaihingen", false, lanasLend);

        storage.addCustomer(lena);
        storage.addCustomer(peter);
        storage.addCustomer(lana);
    }


    public void deleteBook(String isbnInput) {
        try {
            Book foundBook = storage.searchBookByISBN(isbnInput);
            storage.deleteBook(foundBook);
        } catch (NoSuchElementException exception) {
            ui.errorMessage(exception.getMessage());
        }
    }

    public void deleteBookCopy(String idInput) {
        try {
            long id = Long.parseLong(idInput);
            BookCopy foundBookCopy = storage.searchBookCopyById(id);
            storage.deleteBookCopy(foundBookCopy);
        } catch (NoSuchElementException exception) {
            ui.errorMessage(exception.getMessage());
        } catch (NumberFormatException exception) {
            ui.errorMessage("Invalid ID format!");
        }
    }

    public void deleteCustomer(String idInput) {
        try {
            long id = Long.parseLong(idInput);
            Customer foundCustomer = storage.searchCustomerById(id);
            storage.deleteCustomer(foundCustomer);
        } catch (NoSuchElementException exception) {
            ui.errorMessage(exception.getMessage());
        } catch (NumberFormatException exception) {
            ui.errorMessage("Invalid ID format!");
        }
    }
}