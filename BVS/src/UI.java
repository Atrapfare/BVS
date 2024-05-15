import java.util.Scanner;

public class UI {

    Control control;
    Page currentPage;
    Scanner scMenu;
    Scanner scInput;

    public UI(Control control) {
        this.currentPage = Page.HOME;
        this.scMenu = new Scanner(System.in);
        this.scInput = new Scanner(System.in);
        this.control = control;
    }

    public void startUI() {
        System.out.println("Type >home< to start main menu.");
        while (true) {
            input();
        }
    }

    private void input() {

        String input = scMenu.nextLine();

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
                    books();
                } else if (currentPage == Page.BOOKCOPIES) {
                    booksCopies();
                } else if (currentPage == Page.CUSTOMER) {
                    deleteCustomer();
                } else {
                    System.out.println("Invalid Input!");
                }
                break;

            case "5":
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

    private void home() {

        currentPage = Page.HOME;

        System.out.println("\n\n");
        System.out.println("In which menu do you want to navigate:\n");
        System.out.println("1 Borrow a book");
        System.out.println("2 Return a book");
        System.out.println("3 Books");
        System.out.println("4 Book Copies");
        System.out.println("5 Customers");
        System.out.println("\n");

    }

    private void borrowBook() {

        currentPage = Page.BORROWBOOK;

        System.out.println("\n\n");
        System.out.println("Borrow a book \n");
        System.out.println("You can borrow a book here.");

    }

    private void returnBook() {

        currentPage = Page.RETURNBOOK;

        System.out.println("\n\n");
        System.out.println("Return a book \n");
        System.out.println("You can return a book here.");

    }

    private void books() {

        currentPage = Page.BOOK;

        System.out.println("\n\n");
        System.out.println("Books \n");
        System.out.println("1 Search");
        System.out.println("2 Add");
        System.out.println("3 Delete");
        System.out.println("\n");
    }

    private void booksCopies() {

        currentPage = Page.BOOKCOPIES;

        System.out.println("\n\n");
        System.out.println("Books Copies \n");
        System.out.println("1 Search");
        System.out.println("2 Add");
        System.out.println("3 Delete");
        System.out.println("\n");
    }

    private void searchBook() {
        /*TODO via CSV*/
    }

    private void addBook() {
        /*TODO via CSV*/
    }

    private void deleteBook() {
        System.out.println("\n\n");
        System.out.println("Delete books \n");
        System.out.println("Type the ISBN: ");

        String isbnInput = scInput.nextLine();
        control.deleteBook(isbnInput);
    }


    private void searchBookCopy() {
        /*TODO via CSV*/
    }

    private void addBookCopy() {
        /*TODO via CSV*/
    }

    private void deleteBookCopy() {
        System.out.println("\n\n");
        System.out.println("Delete book copy \n");
        System.out.println("Type the id: ");

        String idInput = scInput.nextLine();
        control.deleteBookCopy(idInput);
    }



    private void customer() {

        currentPage = Page.CUSTOMER;

        System.out.println("\n\n");
        System.out.println("Customer \n");
        System.out.println("1 Search");
        System.out.println("2 Add");
        System.out.println("3 Delete");
        System.out.println("\n");
    }

    private void searchCustomer() {
        /*TODO*/
    }

    private void addCustomer() {
        /*TODO via CSV*/
    }

    private void deleteCustomer() {
        System.out.println("\n\n");
        System.out.println("Delete Customer \n");
        System.out.println("Type the ID: ");

        String idInput = scInput.nextLine();
        control.deleteCustomer(idInput);
    }

    public void errorMessage(String message) {
        System.out.println(message);
    }

    enum Page {
        HOME, BORROWBOOK, RETURNBOOK, BOOK, CUSTOMER, BOOKCOPIES
    }
}