package e1;

public class BankAccountDecorator implements BankAccount {
    protected final BankAccount account;

    public BankAccountDecorator(BankAccount account) {
        this.account = account;
    }

    @Override
    public int getBalance() {
        return this.account.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.account.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.account.withdraw(amount);
    }
}
