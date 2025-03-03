package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest {
    public static final int WITHDRAW_AMOUNT_WITHOUT_FEE = 50;

    @BeforeEach
    void init(){
        super.account = super.factory.getBronzeBankAccount();
    }

    @Test
    public void testWithdrawalFee() {
        super.account.deposit(INITIAL_BALANCE);
        super.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT - BankAccountFactory.FEE, super.account.getBalance());
    }

    @Test
    public void testFreeWithdrawalFee() {
        super.account.deposit(INITIAL_BALANCE);
        super.account.withdraw(WITHDRAW_AMOUNT_WITHOUT_FEE);
        assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT_WITHOUT_FEE, super.account.getBalance());
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
