/** Checked — include shortfall. */
public class InsufficientFundsException extends Exception {
    private double shortfall;

    public InsufficientFundsException(double shortfall) {
        super("Withdrawal failed! You are short by : " + shortfall);
        this.shortfall = shortfall;
    }

    public double getShortFall(){
        return shortfall;
    }
}