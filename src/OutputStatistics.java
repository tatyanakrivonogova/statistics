import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class OutputStatistics {
    Writer fout;
    Statistics wordsDictionary;

    OutputStatistics(String outputFile, Statistics words) {
        wordsDictionary = words;
        try {
            fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8));
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error while reading output file: " + e.getLocalizedMessage());
        }
    }

    public void outputData() {

        ArrayList<Record> sortedWordsDictionary = new ArrayList<>();
        for (Map.Entry<String, Integer> o : wordsDictionary.getWordsDictionary().entrySet()) {
            sortedWordsDictionary.add(new Record(o.getKey(), o.getValue()));
        }

        sortedWordsDictionary.sort(new recordComparator());

        try {
            for (Record o : sortedWordsDictionary) {
                fout.write(o.word + ";" + o.number + ";" + ((double) o.number / wordsDictionary.getAllWordsNumber()) * 100 + "%\n");
            }
            fout.close();
        }
        catch (IOException e)
        {
            System.err.println("Error while writing to output file: " + e.getLocalizedMessage());
        }

    }
}
