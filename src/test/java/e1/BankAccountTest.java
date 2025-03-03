package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    public static final int INITIAL_BALANCE = 1000;
    public static final int WITHDRAW_AMOUNT = 200;
    private final BankAccountFactory factory = new BankAccountFactory();
    private BankAccount silver, gold;

    @BeforeEach
    void init(){
        this.silver = this.factory.getSilverBankAccount();
        this.gold = this.factory.getGoldBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.silver.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.silver.deposit(INITIAL_BALANCE);
        this.gold.deposit(INITIAL_BALANCE);
        assertAll(
                () -> assertEquals(INITIAL_BALANCE, this.silver.getBalance()),
                () -> assertEquals(INITIAL_BALANCE, this.gold.getBalance())
        );
    }

    @Test
    public void testCanWithdraw() {
        this.silver.deposit(INITIAL_BALANCE);
        this.silver.withdraw(WITHDRAW_AMOUNT);
        this.gold.deposit(INITIAL_BALANCE);
        this.gold.withdraw(WITHDRAW_AMOUNT);
        assertAll(
                () -> assertEquals(
                        INITIAL_BALANCE - WITHDRAW_AMOUNT - SilverBankAccount.FEE,
                        this.silver.getBalance()
                ),
                () -> assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT, this.gold.getBalance())
        );
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.silver.deposit(INITIAL_BALANCE);
        assertThrows(IllegalStateException.class, () -> this.silver.withdraw(INITIAL_BALANCE + WITHDRAW_AMOUNT));
    }

    @Test
    public void testCannotWithdrawOverLimit() {
        this.gold.deposit(INITIAL_BALANCE);
        assertThrows(
                IllegalStateException.class,
                () -> this.gold.withdraw(INITIAL_BALANCE + GoldBankAccount.OVERDRAFT_AMOUNT + WITHDRAW_AMOUNT)
        );
    }

    @Test
    public void testCanWithdrawUpToLimit() {
        this.gold.deposit(INITIAL_BALANCE);
        this.gold.withdraw(INITIAL_BALANCE + GoldBankAccount.OVERDRAFT_AMOUNT);
        assertEquals(-GoldBankAccount.OVERDRAFT_AMOUNT, this.gold.getBalance());
    }

}
