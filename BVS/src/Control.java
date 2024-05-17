import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

public class Control {

    UI ui;
    Storage storage;

    public Control() {
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
        Customer peter = new Customer(261263, "Kohler", "Peter", "Schwarzweg 49", "70199", "Vaihingen", false, petersLend);
        ArrayList<BookCopy> lanasLend = new ArrayList<>();
        petersLend.add(bookCopy2);
        petersLend.add(bookCopy4);
        Customer lana = new Customer(234421, "Möhrke", "Lana", "Korelliweg 34", "70199", "Vaihingen", false, lanasLend);

        storage.addCustomer(lena);
        storage.addCustomer(peter);
        storage.addCustomer(lana);
    }


    // CUSTOMER MANAGEMENT
    public int deleteCustomer(long id) {
        try {
            Customer customer = storage.searchCustomerById(id);
            if (customer.getNothingLend()) {
                storage.deleteCustomer(customer);
                return 0; // successfully deleted
            }
        } catch (NoSuchElementException exception) {
            return 2; // not found
        }
        return 1; // not deleted due to customer still has lent books
    }

    // BOOK MANAGEMENT
    public int deleteBook(String isbn) {
        try {
            Book book = storage.searchBookByISBN(isbn);
            ArrayList<BookCopy> bookCopies = storage.getBookCopies();
            boolean readyForDeletion = true;
            for (BookCopy bookCopy : bookCopies) {
                if (bookCopy.getBook().getIsbn().equals(book.getIsbn())) {
                    if (bookCopy.isLent()) {
                        readyForDeletion = false;
                    }
                }
            }
            if (readyForDeletion) {
                for (BookCopy bookCopy : bookCopies) {
                    if (bookCopy.getBook().getIsbn().equals(book.getIsbn())) {
                        storage.deleteBookCopy(bookCopy);
                    }
                }
                storage.deleteBook(book);
                return 0; // successfully deleted
            }
        } catch (NoSuchElementException exception) {
            return 2; // not found
        }
        return 1; // not deleted due to not ready for deletion
    }

    // BOOK COPY MANAGEMENT
    public int deleteBookCopy(long id) {
        try {
            BookCopy bookCopy = storage.searchBookCopyById(id);
            if (!bookCopy.isLent()) {
                storage.deleteBookCopy(bookCopy);
                return 0; // successfully deleted
            }
        } catch (NoSuchElementException exception) {
            return 2; // not found
        }
        return 1; // not deleted due to book copy still lend
    }


}