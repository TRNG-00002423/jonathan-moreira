/**
 * Week 2 Exercise — Calculator with static methods and overloads.
 *
 * Division by zero strategy ( choose and implement):
 *   Option A: print error message and return Double.NaN
 *   Option B: return 0.0 and document why (not ideal for production)
 *
 * Compile: javac Calculator.java
 * Run:     java Calculator
 */
public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    /** Sum of three doubles — overloads add(a,b). */
    public static double add(double a, double b, double c) {
        return a + b + c;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0){  
            System.err.println("Division by zero!!");
            return Double.NaN;
        }

        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("Add a + b: " + Calculator.add(1, 2));
        System.out.println("Add a + b + c: " + Calculator.add(1, 2, 3));
        System.out.println("Subtract a - b: " + Calculator.subtract(4, 5));
        System.out.println("Multiply a * b: " + Calculator.multiply(4, 5));
        System.out.println("Divide a / b: " + Calculator.divide(4, 5));
        System.out.println("Divide a / b (b = 0): " + Calculator.divide(4, 0));
    }
}