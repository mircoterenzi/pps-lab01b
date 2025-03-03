package e1;

public class SilverBankAccount extends BankAccountDecorator {

    public static final int FEE = 1;

    public SilverBankAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {
        super.account.withdraw(amount + FEE);
    }
}
