import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagementPageTest {

    private static Control control;

    @BeforeAll
    public static void setUp() {
        control = new Control();
        control.run();
    }

    @Test
    public void deleteCustomerTest() {
        assertEquals(control.deleteCustomer(261523), 0); // success
        assertEquals(control.deleteCustomer(261263), 1); // not possible
        assertEquals(control.deleteCustomer(123456), 2); // not found
    }

    @Test
    public void deleteBookCopyTest() {
        assertEquals(control.deleteBookCopy(12362), 0); // success
        assertEquals(control.deleteBookCopy(12345), 1); // not possible
        assertEquals(control.deleteBookCopy(98765), 2); // not found
    }

    @Test
    public void deleteBookTest() {
        assertEquals(control.deleteBook("123-456-789"), 0); // success
        assertEquals(control.deleteBook("789-456-123"), 1); // not possible
        assertEquals(control.deleteBook("123-123-123"), 2); // not found
    }


}