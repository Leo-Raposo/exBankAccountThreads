import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 2000);

        bank.addAccount(account1);
        bank.addAccount(account2);

        Thread t1 = new Customer(bank, 1, true, 500);
        Thread t2 = new Customer(bank, 1, false, 200);
        Thread t3 = new Customer(bank, 2, true, 300);
        Thread t4 = new Customer(bank, 2, false, 1000);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------");
        System.out.println(" ____    _    _   _ _  __\n" +
                "| __ )  / \\  | \\ | | |/ /\n" +
                "|  _ \\ / _ \\ |  \\| | ' / \n" +
                "| |_) / ___ \\| |\\  | . \\ \n" +
                "|____/_/   \\_\\_| \\_|_|\\_\\");
        System.out.println("---------------------------");
        System.out.println();
        System.out.println("Saldo da Conta 1: " + account1.getBalance());
        System.out.println("Histórico de Transações da Conta 1: " + account1.getTransactionHistory());

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();

        System.out.println("Saldo da Conta 2: " + account2.getBalance());
        System.out.println("Histórico de Transações da Conta 2: " + account2.getTransactionHistory());

        List<String> logFiles = List.of("src/log1.txt", "src/log2.txt", "src/log3.txt");
        String wordToCount = "error";

        ParallelLogProcessor parallelLogProcessor = new ParallelLogProcessor(4);
        int totalOccurrences = parallelLogProcessor.processLogs(logFiles, wordToCount);

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("Total de ocorrências da palavra '" + wordToCount + "': " + totalOccurrences);
    }
}
