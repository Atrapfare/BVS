import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagementPageTest {

    private Control control;

    @BeforeEach
    public void setUp() {
        control = new Control();
        control.generateSamples();
    }

    @Test
    public void deleteCustomerTest() {
        assertEquals(0, control.deleteCustomer(54321)); // success
        assertEquals(1, control.deleteCustomer(12345)); // not possible
        assertEquals(2, control.deleteCustomer(97654)); // not found
    }

    @Test
    public void deleteBookCopyTest() {
        assertEquals(0, control.deleteBookCopy(13243)); // success
        assertEquals(1, control.deleteBookCopy(12345)); // not possible
        assertEquals(2, control.deleteBookCopy(98765)); // not found
    }

    @Test
    public void deleteBookTest() {
        assertEquals(0, control.deleteBook("789-456-123")); // success
        assertEquals(1, control.deleteBook("123-789-456")); // not possible
        assertEquals(2, control.deleteBook("123-123-123")); // not found
    }
}
