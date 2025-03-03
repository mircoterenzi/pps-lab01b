package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SilverBankAccountTest extends BankAccountTest {
    @BeforeEach
    void init(){
        super.account = super.factory.getSilverBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        super.account.deposit(INITIAL_BALANCE);
        super.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT - FeeDecorator.FEE, super.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        super.account.deposit(INITIAL_BALANCE);
        assertThrows(
                IllegalStateException.class,
                () -> super.account.withdraw(INITIAL_BALANCE + WITHDRAW_AMOUNT)
        );
    }
}
