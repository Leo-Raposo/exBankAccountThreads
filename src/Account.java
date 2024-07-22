import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountId;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(int accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public synchronized void deposit(double amount) {
        setBalance(getBalance() + amount);
        transactionHistory.add(new Transaction("Depósito", amount));
    }

    public synchronized void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactionHistory.add(new Transaction("Retirada", amount));
        } else {
            System.out.println("Saldo insuficiente para retirada.");
        }
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public int getAccountId() {
        return accountId;
    }
}
