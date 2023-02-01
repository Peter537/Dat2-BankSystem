import main.Bank;
import main.account.BankAccount;
import main.account.SalaryAccount;
import main.entities.Customer;
import main.enums.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransferTest {

    @Test
    public void testTransferValid() {
        Bank bank = new Bank();
        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount();
        BankAccount account2 = new SalaryAccount();

        account1.setOwner(customer1);
        account2.setOwner(customer2);

        account1.deposit(1000);
        account2.deposit(1000);

        bank.addAccount(account1);
        bank.addAccount(account2);

        assertTrue(bank.transferMoney(account1, account2, 500));
    }

    @Test
    public void testTransferInvalid() {
        Bank bank = new Bank();
        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount();
        BankAccount account2 = new SalaryAccount();

        account1.setOwner(customer1);
        account2.setOwner(customer2);

        account1.deposit(1000);
        account2.deposit(1000);

        bank.addAccount(account1);
        bank.addAccount(account2);

        assertFalse(bank.transferMoney(account1, account2, 1500));
    }
}