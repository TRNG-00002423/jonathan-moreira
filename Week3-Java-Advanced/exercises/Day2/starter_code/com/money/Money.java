import java.util.Objects;

public final class Money {

    private final String currency;
    private final long amountMinor; 

    public Money(String currency, long amountMinor) {
        if (currency == null)
            throw new IllegalArgumentException("Wrong currency!" + currency);
        else
            this.currency = currency;

        this.amountMinor = amountMinor;
    }

    public String getCurrency() {
        return currency;
    }

    public long getAmountMinor() {
        return amountMinor;
    }    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Money obj = (Money) o;

        return this.currency.equals(obj.getCurrency()) && Long.compare(this.amountMinor, obj.getAmountMinor()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency, this.amountMinor);
    }

    @Override
    public String toString() {
        return "Money{currency=" + currency + ", amountMinor=" + amountMinor + "}";
    }

}