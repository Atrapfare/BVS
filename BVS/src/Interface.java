import java.util.Scanner;

public class Interface {

    static Page currentPage;
    static Scanner sc = new Scanner(System.in);
    static Scanner scBook = new Scanner(System.in);
    static Framework framework = new Framework();

    public static void startInterface() {
        System.out.println("Type home to get to the main menu.");
        while (true) {
            input();
        }
    }

    private static void input() {

        String input = sc.nextLine();

        switch (input) {
            case "home":
                home();
                break;

            case "exit":
                System.exit(0);
                break;

            case "1":
                if (currentPage == Page.HOME) {
                    borrowBook();
                } else if (currentPage == Page.BOOK) {
                    searchBook();
                } else if (currentPage == Page.CUSTOMER) {
                    searchCustomer();
                } else {
                    System.out.println("Invalid Input!");
                }
                break;

            case "2":
                if (currentPage == Page.HOME) {
                    returnBook();
                } else if (currentPage == Page.BOOK) {
                    addBook();
                } else if (currentPage == Page.CUSTOMER) {
                    addCustomer();
                } else {
                    System.out.println("Invalid Input!");
                }
                break;

            case "3":
                if (currentPage == Page.HOME) {
                    books();
                } else if (currentPage == Page.BOOK) {
                    deleteBook();
                } else if (currentPage == Page.CUSTOMER) {
                    deleteCustomer();
                } else {
                    System.out.println("Invalid Input!");
                }
                break;

            case "4":
                if (currentPage == Page.HOME) {
                    customer();
                } else {
                    System.out.println("Invalid Input!");
                }
                break;

            default:
                System.out.println("Invalid Input!");
                break;
        }
    }

    private static void home() {

        currentPage = Page.HOME;

        System.out.println("\n\n");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. Books");
        System.out.println("4. Customers");
        System.out.println("\n");

    }

    private static void borrowBook() {

        currentPage = Page.BORROWBOOK;

        System.out.println("\n\n");
        System.out.println("Borrow a book \n");
        System.out.println("You can borrow a book here.");

    }

    private static void returnBook() {

        currentPage = Page.RETURNBOOK;

        System.out.println("\n\n");
        System.out.println("Return a book \n");
        System.out.println("You can return a book here.");

    }

    private static void books() {

        currentPage = Page.BOOK;

        System.out.println("\n\n");
        System.out.println("Books \n");
        System.out.println("1. Search");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.println("\n");
    }

    private static void searchBook() {

    }

    private static void addBook() {

    }

    private static void deleteBook() {
        System.out.println("\n\n");
        System.out.println("Delete books \n");
        System.out.println("Type the ISBN: ");

        String next = scBook.nextLine();
        Framework.deleteBook(next);

    }

    private static void customer() {

        currentPage = Page.CUSTOMER;

        System.out.println("\n\n");
        System.out.println("Customer \n");
        System.out.println("1. Search");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.println("\n");
    }

    private static void searchCustomer() {

    }

    private static void addCustomer() {

    }

    private static void deleteCustomer() {

    }

    enum Page {
        HOME, BORROWBOOK, RETURNBOOK, BOOK, CUSTOMER
    }
}