import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputStatistics {
    Scanner scan;
    Statistics wordsDictionary;

    InputStatistics(String inputFile, Statistics words) throws FileNotFoundException {
        scan = new Scanner(new FileInputStream(inputFile), StandardCharsets.UTF_8);
        wordsDictionary = words;
    }

    public void inputData() {

        scan.useDelimiter("[^a-zA-Zа-яА-Я0-9]");

        while (scan.hasNext()) {
            wordsDictionary.addWord(scan.next());
        }

        scan.close();
    }
}
