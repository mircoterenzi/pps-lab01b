package e1;

public class GoldBankAccount extends BankAccountDecorator {

    public static final int OVERDRAFT_AMOUNT = 500;

    public GoldBankAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + OVERDRAFT_AMOUNT < amount){
            throw new IllegalStateException();
        }
        super.account.withdraw(amount);
    }
}
