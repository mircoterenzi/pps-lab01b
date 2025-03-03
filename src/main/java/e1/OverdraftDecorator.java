package e1;

public class OverdraftDecorator extends BankAccountDecorator {
    private final int overdraftAmountLimit;

    public OverdraftDecorator(BankAccount account, int overdraftAmountLimit) {
        super(account);
        this.overdraftAmountLimit = overdraftAmountLimit;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + overdraftAmountLimit < amount) {
            throw new IllegalStateException();
        }
        super.account.withdraw(amount);
    }
}
