import main.Bank;
import main.account.BankAccount;
import main.account.SalaryAccount;
import main.entities.Customer;
import main.enums.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferTest {

    @Test
    public void testTransferValid() {
        Bank bank = new Bank();
        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount(customer1);
        BankAccount account2 = new SalaryAccount(customer2);

        account1.deposit(1000);
        account2.deposit(1000);

        assertTrue(bank.transferMoney(account1, account2, 500));
    }

    @Test
    public void testTransferInvalid() {
        Bank bank = new Bank();
        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount(customer1);
        BankAccount account2 = new SalaryAccount(customer2);

        account1.deposit(1000);
        account2.deposit(1000);

        assertFalse(bank.transferMoney(account1, account2, 1500));
    }

    @Test
    public void testTransferNegativeValue() {
        Bank bank = new Bank();
        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount(customer1);
        BankAccount account2 = new SalaryAccount(customer2);

        account1.deposit(1000);
        account2.deposit(1000);

        assertFalse(bank.transferMoney(account1, account2, -500));
    }

    @Test
    public void testTransferWithNullAccount() {
        Bank bank = new Bank();
        assertThrows(IllegalArgumentException.class, () -> bank.transferMoney(null, null, 500));
    }
}