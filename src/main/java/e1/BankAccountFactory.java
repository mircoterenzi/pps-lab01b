package e1;

public class BankAccountFactory {

    public static final int DEFAULT_OVERDRAFT_AMOUNT_LIMIT = 0;

    public BankAccount getSilverBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(new SilverBankAccount(new CoreBankAccount()), DEFAULT_OVERDRAFT_AMOUNT_LIMIT)
        );
    }

    public BankAccount getGoldBankAccount(int overdraftAmountLimit) {
        return new BankAccountDecorator(new OverdraftDecorator(new CoreBankAccount(), overdraftAmountLimit));
    }

    public BankAccount getBronzeBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(new BronzeBankAccount(new CoreBankAccount()), DEFAULT_OVERDRAFT_AMOUNT_LIMIT)
        );
    }
}
