import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> bank;
    private String bankname;

    public Bank() {
    }

    public Bank(String bankname) {
        this.bankname = bankname;
        bank = new HashMap<>();
    }


    public void openAccount(String id, double initialDeposit) throws InvalidAccountException {
        if(bank.containsKey(id) || id.isBlank())
            throw new InvalidAccountException(id);

        bank.put(id, new Account(id, initialDeposit));
        System.out.println(getAccount(id));
    }

    public Account getAccount(String id) throws InvalidAccountException {
        if(!bank.containsKey(id) || id.isBlank())
            throw new InvalidAccountException(id);
        
        return bank.get(id);
    }

    public void transfer(String fromId, String toId, double amount)
            throws InvalidAccountException, InsufficientFundsException {
        if(!bank.containsKey(fromId) || fromId.isBlank())
            throw new InvalidAccountException(fromId);
        if(!bank.containsKey(toId) || toId.isBlank())
            throw new InvalidAccountException(toId); 

        Account accountFromId = getAccount(fromId);
        accountFromId.withdraw(amount);
        
        Account accountToId = getAccount(toId);
        accountToId.deposit(amount);

        System.out.println(accountFromId);
        System.out.println(accountToId);
        
    }
}