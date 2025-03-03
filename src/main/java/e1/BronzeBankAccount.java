package e1;

public class BronzeBankAccount extends BankAccountDecorator {

    public BronzeBankAccount(BankAccount account) {
        super(account);
    }
}
