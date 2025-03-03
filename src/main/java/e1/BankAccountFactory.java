package e1;

public class BankAccountFactory {
    public BankAccount getSilverBankAccount() {
        return new BankAccountDecorator(new SilverBankAccount(new CoreBankAccount()));
    }

    public BankAccount getGoldBankAccount() {
        return new BankAccountDecorator(new GoldBankAccount(new CoreBankAccount()));
    }
}
