
import java.util.HashSet;


public class MoneyDemo {
    public static void main(String[] args) {
        // TODO: build Money USD 1000 cents twice, add to HashSet, print size
        // TODO: print equals vs ==
        HashSet<Money> bank = new HashSet<>();

        Money money1 = new Money("USD", 1000);
        Money money2 = new Money("USD", 1000);

        System.out.println("Before 1st add: " + bank.size());
        bank.add(money1);
        System.out.println("After 1st add: " + bank.size());

        System.out.println("Before 2nd add: " + bank.size());
        bank.add(money2);
        System.out.println("After 2nd add: " + bank.size());

        System.out.println("Using 'equals()': " + money1.equals(money2));
        System.out.println("Using '==': " + (money1 == money2));
    }
}