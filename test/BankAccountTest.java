import main.Bank;
import main.account.BankAccount;
import main.account.PenguinAccount;
import main.account.PremiumAccount;
import main.account.SalaryAccount;
import main.entities.Customer;
import main.enums.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountTest {

    private Customer customerVIP;
    private Customer customerAdult;
    private Customer customerChild;

    @BeforeAll
    public void init() {
        customerVIP = new Customer("VIP", Status.VIP);
        customerAdult = new Customer("ADULT", Status.ADULT);
        customerChild = new Customer("CHILD", Status.CHILD);
    }

    @Test
    public void testBankAccountID() {
        BankAccount bankAccount = new PenguinAccount();
        assertEquals(1, bankAccount.getID());
        BankAccount bankAccount2 = new SalaryAccount();
        assertNotEquals(bankAccount.getID(), bankAccount2.getID());
        assertEquals(2, bankAccount2.getID());
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

    @Test
    public void testSalaryAccountSetOwner2() {
        BankAccount bankAccount = new SalaryAccount();
        bankAccount.setOwner(customerVIP);
        assertNotEquals(customerChild, bankAccount.getOwner());
        assertNotEquals(customerAdult, bankAccount.getOwner());
        assertEquals(customerVIP, bankAccount.getOwner());
    }

    @Test
    public void testPenguinAccountDeposit() {
        BankAccount bankAccount = new PenguinAccount();
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testPremiumAccountDeposit() {
        BankAccount bankAccount = new PremiumAccount();
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testSalaryAccountDeposit() {
        BankAccount bankAccount = new SalaryAccount();
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testPenguinAccountWithdraw() {
        BankAccount bankAccount = new PenguinAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void testPremiumAccountWithdraw() {
        BankAccount bankAccount = new PremiumAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void testPremiumAccountWithdraw2() {
        BankAccount bankAccount = new PremiumAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(150);
        assertEquals(-50, bankAccount.getBalance());
    }

    @Test
    public void testSalaryAccountWithdraw() {
        SalaryAccount bankAccount = new SalaryAccount();
        bankAccount.setCreditLimit(-100);
        bankAccount.deposit(100);
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    public void testWrongPenguinAccountDeposit() {
        BankAccount bankAccount = new PenguinAccount();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-100));
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testWrongPremiumAccountDeposit() {
        BankAccount bankAccount = new PremiumAccount();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-100));
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testWrongSalaryAccountDeposit() {
        BankAccount bankAccount = new SalaryAccount();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-100));
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testWrongPenguinAccountWithdraw() {
        BankAccount bankAccount = new PenguinAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(-100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testWrongPremiumAccountWithdraw() {
        BankAccount bankAccount = new PremiumAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(-100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testWrongSalaryAccountWithdraw() {
        BankAccount bankAccount = new SalaryAccount();
        bankAccount.deposit(100);
        bankAccount.withdraw(-100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testWrongPenguinAccountOwner() {
        BankAccount bankAccount = new PenguinAccount();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.setOwner(customerAdult));
        assertNotEquals(customerAdult, bankAccount.getOwner());
        assertNotEquals(customerVIP, bankAccount.getOwner());
        assertNotEquals(customerChild, bankAccount.getOwner());
    }

    @Test
    public void testWrongPremiumAccountOwner() {
        BankAccount bankAccount = new PremiumAccount();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.setOwner(customerChild));
        assertNotEquals(customerAdult, bankAccount.getOwner());
        assertNotEquals(customerVIP, bankAccount.getOwner());
        assertNotEquals(customerChild, bankAccount.getOwner());
    }

    @Test
    public void testWrongSalaryAccountOwner() {
        BankAccount bankAccount = new SalaryAccount();
        assertThrows(IllegalArgumentException.class, () -> bankAccount.setOwner(customerChild));
        assertNotEquals(customerAdult, bankAccount.getOwner());
        assertNotEquals(customerVIP, bankAccount.getOwner());
        assertNotEquals(customerChild, bankAccount.getOwner());
    }
}