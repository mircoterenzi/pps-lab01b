package e1;

/**
 * Models a Bank Account
 */
public interface BankAccount {
    /**
     * Return the current balance.
     * @return the balance.
     */
    int getBalance();

    /**
     * Adds the amount to the balance.
     * @param amount amount to be added to the balance.
     */
    void deposit(int amount);

    /**
     * Removes the amount from th balance.
     * @param amount amount to be removed from the balance.
     */
    void withdraw(int amount);
}
