package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        this.gold.deposit(1000);
        assertAll(
                () -> assertEquals(1000, this.silver.getBalance()),
                () -> assertEquals(1000, this.gold.getBalance())
        );
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
