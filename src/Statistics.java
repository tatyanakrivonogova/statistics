import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Statistics {
    int allWordsNumber = 0;
    SortedMap<String, Integer> dictionary;

    public Statistics() {
        dictionary = new TreeMap<String, Integer>();
    }

    public SortedMap<String, Integer> getDictionary() {
        return dictionary;
    }

    public int getAllWordsNumber() {
        return allWordsNumber;
    }

    public void addWord(String value) {
        if (value.length() == 0) {
            return;
        }
        if (dictionary.get(value) == null) {
            dictionary.put(value, 1);
        } else {
            dictionary.put(value, dictionary.get(value) + 1);
        }
        ++allWordsNumber;
    }
}
