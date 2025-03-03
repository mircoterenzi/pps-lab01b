package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {
    @BeforeEach
    void init(){
        super.account = super.factory.getGoldBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        super.account.deposit(INITIAL_BALANCE);
        super.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT, super.account.getBalance());
    }

    @Test
    public void testCannotWithdrawOverLimit() {
        account.deposit(INITIAL_BALANCE);
        assertThrows(
                IllegalStateException.class,
                () -> super.account.withdraw(INITIAL_BALANCE + GoldBankAccount.OVERDRAFT_AMOUNT + WITHDRAW_AMOUNT)
        );
    }

    @Test
    public void testCanWithdrawUpToLimit() {
        super.account.deposit(INITIAL_BALANCE);
        super.account.withdraw(INITIAL_BALANCE + GoldBankAccount.OVERDRAFT_AMOUNT);
        assertEquals(-GoldBankAccount.OVERDRAFT_AMOUNT, super.account.getBalance());
    }
}
