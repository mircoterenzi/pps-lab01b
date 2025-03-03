package e1;

import org.junit.jupiter.api.BeforeEach;

public class BronzeBankAccountTest extends BankAccountTest {
    @BeforeEach
    void init(){
        super.account = super.factory.getBronzeBankAccount();
    }
}
