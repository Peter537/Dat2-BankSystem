import main.Bank;
import main.account.BankAccount;
import main.account.SalaryAccount;
import main.entities.Customer;
import main.enums.Status;
import main.observer.ResponseHandler1;
import main.observer.ResponseHandler2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObserverTest {

    @Test
    public void testTransferOver10000() {
        Bank bank = new Bank();
        bank.addObserver(new ResponseHandler1());
        bank.addObserver(new ResponseHandler2());

        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount(customer1);
        BankAccount account2 = new SalaryAccount(customer2);

        account1.deposit(100000);
        account2.deposit(100000);

        bank.transferMoney(account1, account2, 10001);
    }

    @Test
    public void testTransferUnder10000() {
        Bank bank = new Bank();
        bank.addObserver(new ResponseHandler1());
        bank.addObserver(new ResponseHandler2());

        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        BankAccount account1 = new SalaryAccount(customer1);
        BankAccount account2 = new SalaryAccount(customer2);

        account1.deposit(100000);
        account2.deposit(100000);

        bank.transferMoney(account1, account2, 500);
    }
}