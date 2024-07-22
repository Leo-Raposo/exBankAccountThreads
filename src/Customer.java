public class Customer extends Thread {
    private Bank bank;
    private int accountId;
    private boolean deposit;
    private double amount;

    public Customer(Bank bank, int accountId, boolean deposit, double amount) {
        this.bank = bank;
        this.accountId = accountId;
        this.deposit = deposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit()) {
            getBank().deposit(getAccountId(), getAmount());
        } else {
            getBank().withdraw(getAccountId(), getAmount());
        }
    }

    public Bank getBank() {
        return bank;
    }

    public int getAccountId() {
        return accountId;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public double getAmount() {
        return amount;
    }

}
