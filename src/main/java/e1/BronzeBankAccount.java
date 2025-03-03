package e1;

public class BronzeBankAccount extends BankAccountDecorator {

    public static final int FEE = 1;
    public static final int FREE_WITHDRAW_MAX_AMOUNT = 100;

    public BronzeBankAccount(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.account.withdraw(amount + (amount < FREE_WITHDRAW_MAX_AMOUNT ? 0 : FEE));
    }
}
