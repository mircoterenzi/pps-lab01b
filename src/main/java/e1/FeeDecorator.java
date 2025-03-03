package e1;

import java.util.function.Function;

public class FeeDecorator extends BankAccountDecorator {

    public static final int FEE = 1;
    private final Function<Integer, Integer> calculateFeeFromAmount;

    public FeeDecorator(BankAccount account, Function<Integer, Integer> calculateFeeFromAmount) {
        super(account);
        this.calculateFeeFromAmount = calculateFeeFromAmount;
    }

    @Override
    public void withdraw(int amount) {
        super.account.withdraw(amount + calculateFeeFromAmount.apply(amount));
    }
}
