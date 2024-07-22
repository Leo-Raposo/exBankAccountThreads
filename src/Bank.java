import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        getAccounts().put(account.getAccountId(), account);
    }

    public Account getAccount(int accountId) {
        return getAccounts().get(accountId);
    }

    public void deposit(int accountId, double amount) {
        Account account = getAccount(accountId);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(int accountId, double amount) {
        Account account = getAccount(accountId);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
