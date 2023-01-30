import main.account.BankAccount;
import main.account.PenguinAccount;
import main.account.PremiumAccount;
import main.account.SalaryAccount;
import main.entities.Customer;
import main.enums.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountTest {

    private Customer customerVIP;
    private Customer customerAdult;
    private Customer customerChild;

    @BeforeAll
    public void setup() {
        customerVIP = new Customer("Test", Status.VIP);
        customerAdult = new Customer("Test2", Status.ADULT);
        customerChild = new Customer("Test3", Status.CHILD);
    }

    @Test
    public void testPenguinAccountBalance() {
        BankAccount bankAccount = new PenguinAccount();
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testPremiumAccountBalance() {
        BankAccount bankAccount = new PremiumAccount();
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testSalaryAccountBalance() {
        BankAccount bankAccount = new SalaryAccount();
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testPenguinAccountSetOwner() {
        BankAccount bankAccount = new PenguinAccount();
        bankAccount.setOwner(customerChild);
        assertNotEquals(customerVIP, bankAccount.getOwner());
        assertNotEquals(customerAdult, bankAccount.getOwner());
        assertEquals(customerChild, bankAccount.getOwner());
    }

    @Test
    public void testPremiumAccountSetOwner() {
        BankAccount bankAccount = new PremiumAccount();
        bankAccount.setOwner(customerVIP);
        assertNotEquals(customerAdult, bankAccount.getOwner());
        assertNotEquals(customerChild, bankAccount.getOwner());
        assertEquals(customerVIP, bankAccount.getOwner());
    }

    @Test
    public void testSalaryAccountSetOwner() {
        BankAccount bankAccount = new SalaryAccount();
        bankAccount.setOwner(customerAdult);
        assertNotEquals(customerVIP, bankAccount.getOwner());
        assertNotEquals(customerChild, bankAccount.getOwner());
        assertEquals(customerAdult, bankAccount.getOwner());
    }
}