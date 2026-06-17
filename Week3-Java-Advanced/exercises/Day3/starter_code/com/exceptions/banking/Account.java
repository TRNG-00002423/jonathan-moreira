public class Account {
    private String id;
    private double balance;

    public void deposit(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Cannot deposit negative amount!");

        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount < 0)
            throw new IllegalArgumentException("Cannot withdraw negative amount!");

        if(amount > balance)
            throw new InsufficientFundsException(balance - amount);
        
        balance -= amount;
    }
}