import main.entities.Customer;
import main.enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void testCustomerID() {
        Customer customer = new Customer("Test", Status.ADULT);
        assertEquals(1, customer.getID());
    }
}