public class Account {
    private String id;
    private double balance;

    public Account() {
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;

    }

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
    
    @Override
    public String toString() {
        return "Account [id: " + this.id + ", balance: " + this.balance + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}