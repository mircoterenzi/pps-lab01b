package e1;

public class BankAccountFactory {
    public static final int DEFAULT_OVERDRAFT_AMOUNT_LIMIT = 0;
    public static final int FEE = 1;
    public static final int FREE_WITHDRAW_MAX_AMOUNT = 100;
    public static final int OVERDRAFT_AMOUNT_LIMIT = 500;

    public BankAccount getSilverBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(
                        new FeeDecorator(
                                new CoreBankAccount(),
                                amount -> FEE
                        ),
                        DEFAULT_OVERDRAFT_AMOUNT_LIMIT
                )
        );
    }

    public BankAccount getGoldBankAccount() {
        return new BankAccountDecorator(new OverdraftDecorator(new CoreBankAccount(), OVERDRAFT_AMOUNT_LIMIT));
    }

    public BankAccount getBronzeBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(
                        new FeeDecorator(
                                new CoreBankAccount(),
                                amount -> amount < FREE_WITHDRAW_MAX_AMOUNT ? 0 : FEE
                        ),
                        DEFAULT_OVERDRAFT_AMOUNT_LIMIT
                )
        );
    }
}
