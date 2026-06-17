public class BankingDemo {
    public static void main(String[] args) throws Exception {
        Bank bank1 = new Bank("AMEX");
        Account checkingAccount = new Account("1", 10_000);
        Account savingsAccount = new Account("2", 5_000);
        Account loansAccount = new Account("3", 25_0000);
        try {
            bank1.openAccount(checkingAccount.getId(), checkingAccount.getBalance());
            bank1.openAccount(savingsAccount.getId(), savingsAccount.getBalance());
            bank1.transfer(checkingAccount.getId(), savingsAccount.getId(), 5_000);
    
        } catch (InvalidAccountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        
        try {
             // IllegalArgumentException 
            checkingAccount.deposit(-10_000);
        } catch (IllegalArgumentException  e) {
            System.out.println(e.getMessage());
        }
        try {
             // InvalidAccountException
            bank1.transfer(checkingAccount.getId(), loansAccount.getId(), 1_000);
        } catch (InvalidAccountException e) {
            System.out.println(e.getMessage());
        }
           
        try {
            // InsufficientFundsException
            bank1.transfer(checkingAccount.getId(), savingsAccount.getId(), 6_000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

            
    }
}