import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class ParallelLogProcessor {
    private ExecutorService executor;

    public ParallelLogProcessor(int numberOfThreads) {
        setExecutor(Executors.newFixedThreadPool(numberOfThreads));
    }

    public int processLogs(List<String> logFiles, String word) {
        int totalOccurrences = 0;

        try {
            List<Future<Integer>> results = getExecutor().invokeAll(logFiles.stream()
                    .map(filePath -> new LogProcessor(filePath, word))
                    .toList());

            for (Future<Integer> result : results) {
                totalOccurrences += result.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            getExecutor().shutdown();
        }

        return totalOccurrences;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }
}
