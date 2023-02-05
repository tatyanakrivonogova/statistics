import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class OutputStatistics {
    Writer fout;
    Statistics wordsDictionary;

    OutputStatistics(String outputFile, Statistics words) throws FileNotFoundException {
        fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8));
        wordsDictionary = words;
    }

    public void outputData() throws IOException {

        ArrayList<Record> sortedWordsDictionary = new ArrayList<>();
        for (Map.Entry<String, Integer> o : wordsDictionary.getWordsDictionary().entrySet()) {
            sortedWordsDictionary.add(new Record(o.getKey(), o.getValue()));
        }

        //List.sort(sortedWordsDictionary, new recordComparator());
        sortedWordsDictionary.sort(new recordComparator());

        for (Record o : sortedWordsDictionary) {
            fout.write(o.word + ";" + o.number + ";" + (double) o.number / wordsDictionary.getAllWordsNumber() + "\n");
        }

        fout.close();

    }
}
