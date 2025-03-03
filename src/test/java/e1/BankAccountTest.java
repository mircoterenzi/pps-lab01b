package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BankAccountTest {

    public static final int INITIAL_BALANCE = 1000;
    public static final int WITHDRAW_AMOUNT = 200;
    protected final BankAccountFactory factory = new BankAccountFactory();
    protected BankAccount account;

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_BALANCE);
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }
}
