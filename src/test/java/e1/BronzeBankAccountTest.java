package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBankAccountTest extends BankAccountTest {

    public static final int WITHDRAW_AMOUNT_WITHOUT_FEE = 50;

    @BeforeEach
    void init(){
        super.account = super.factory.getBronzeBankAccount();
    }

    @Test
    public void testWithdrawalFee() {
        this.account.deposit(INITIAL_BALANCE);
        this.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT - 1, this.account.getBalance());
    }

    @Test
    public void testFreeWithdrawalFee() {
        this.account.deposit(INITIAL_BALANCE);
        this.account.withdraw(WITHDRAW_AMOUNT_WITHOUT_FEE);
        assertEquals(INITIAL_BALANCE - WITHDRAW_AMOUNT_WITHOUT_FEE, this.account.getBalance());
    }
}
