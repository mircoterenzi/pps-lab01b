package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount silver, gold;

    @BeforeEach
    void init(){
        this.silver = new SilverBankAccount();
        this.gold = new GoldBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.silver.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.silver.deposit(1000);
        assertEquals(1000, this.silver.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.silver.deposit(1000);
        this.silver.withdraw(200);
        assertEquals(799, this.silver.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.silver.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.silver.withdraw(1200));
    }

}
