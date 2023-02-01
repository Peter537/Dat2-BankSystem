import main.account.BankAccount;
import main.account.SalaryAccount;
import main.entities.Customer;
import main.enums.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerTest {
    Customer customer;
    @BeforeAll
    public void init() {
        customer = new Customer("Test", Status.ADULT);
    }
    @Test
    public void testCustomerID() {
        assertEquals(1, customer.getID());
    }

    @Test
    public void testCustomerName() {
        assertEquals("Test", customer.getName());
    }

    @Test
    public void testCustomerStatus() {
        assertEquals(Status.ADULT, customer.getStatus());
    }

    @Test
    public void testRemoveAccount() {
        BankAccount account = new SalaryAccount();
        account.setOwner(customer);
        customer.addAccount(account);
        assertDoesNotThrow(() -> customer.removeAccount(account));
        assertThrows(IllegalArgumentException.class, () -> customer.removeAccount(account));
    }

    @Test
    public void testRemoveNullAccount() {
        assertThrows(IllegalArgumentException.class, () -> customer.removeAccount(null));
    }

    @Test
    public void testAddAccount() {
        BankAccount account = new SalaryAccount();
        assertThrows(IllegalArgumentException.class, () -> customer.addAccount(account));
        assertThrows(IllegalArgumentException.class, () -> customer.addAccount(null));
    }
}