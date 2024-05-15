import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Control control = new Control(new Storage(new ArrayList<Book>(), new ArrayList<BookCopy>(), new ArrayList<Customer>()));
        control.run();
    }
}
