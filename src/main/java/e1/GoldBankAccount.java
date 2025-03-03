package e1;

public class GoldBankAccount implements BankAccount {

    private final BankAccount base = new CoreBankAccount();

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + 500 < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
