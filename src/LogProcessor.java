import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class LogProcessor implements Callable<Integer> {
    private String filePath;
    private String word;

    public LogProcessor(String filePath, String word) {
        this.filePath = filePath;
        this.word = word;
    }

    @Override
    public Integer call() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += countOccurrences(line, getWord());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private int countOccurrences(String line, String word) {
        int count = 0;
        int index = 0;
        while ((index = line.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getWord() {
        return word;
    }
}
