public class ManagementPage extends Page {
    public ManagementPage(UI ui, PageName pageName, String pageUI) {
        super(ui, pageName, pageUI);
    }

    @Override
    protected void pageJob() {
        this.selectAction();
        ui.setCurrentPage(ui.getHomePage());
    }

    private void selectAction() {
        String input = ui.getSc().next();
        if (input == null || input.isEmpty()) {
            ui.errorMessage("Invalid Input!");
            this.selectAction();
        } else {
            try {
                int actionNumber = Integer.parseInt(input);

                switch (actionNumber) {
                    case 1:
                        deleteCustomer();
                        break;
                    case 2:
                        deleteBook();
                        break;
                    case 3:
                        deleteBookCopy();
                        break;
                    default:
                        ui.errorMessage("Invalid Input!");
                        this.selectAction();
                        break;
                }
            } catch (NumberFormatException exception) {
                ui.errorMessage("Invalid Input!");
                this.selectAction();
            }
        }
    }

    private void deleteBookCopy() {
        ui.setMessage("Please insert the book copy id:");
        String bookCopyIdInput = ui.getSc().next();
        long bookCopyId = Long.parseLong(bookCopyIdInput);
        int resultBookCopyDeletion = ui.deleteBookCopy(bookCopyId);
        switch (resultBookCopyDeletion) {
            case 0:
                ui.setMessage("#0 Book Copy deleted successfully!");
                break;
            case 1:
                ui.setMessage("#1 Book Copy is still lend. Cannot be deleted!");
                break;
            case 2:
                ui.setMessage("#2 Book Copy not found!");
                this.resetPage();
                break;
        }
    }

    private void deleteBook() {
        ui.setMessage("Please insert the book isbn:");
        String bookIsbnInput = ui.getSc().next();
        int resultBookDeletion = ui.deleteBook(bookIsbnInput);
        switch (resultBookDeletion) {
            case 0:
                ui.setMessage("#0: Book and all related book copies deleted successfully!");
                break;
            case 1:
                ui.setMessage("#1 Some Book copies are still lend. Cannot delete book!");
                break;
            case 2:
                ui.setMessage("#2 Book not found!");
                this.resetPage();
                break;
        }
    }

    private void deleteCustomer() {
        ui.setMessage("Please insert the customer id:");
        String customerIdInput = ui.getSc().next();
        long customerId = Long.parseLong(customerIdInput);
        int resultCustomerDeletion = ui.deleteCustomer(customerId);
        switch (resultCustomerDeletion) {
            case 0:
                ui.setMessage("#0: Customer deleted successfully!");
                break;
            case 1:
                ui.setMessage("#1: Customer has lent books. Cannot be deleted!");
                break;
            case 2:
                ui.setMessage("#2: Customer not found!");
                this.resetPage();
                break;
        }
    }
}
