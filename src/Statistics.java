import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Statistics {
    int allWordsNumber = 0;
    SortedMap<String, Integer> wordsDictionary;

    public Statistics() {
        wordsDictionary = new TreeMap<String, Integer>();
    }

    public SortedMap<String, Integer> getWordsDictionary() {
        return wordsDictionary;
    }

    public int getAllWordsNumber() {
        return allWordsNumber;
    }

    public void addWord(String word) {
        if (word.length() == 0) {
            return;
        }
        wordsDictionary.merge(word, 1, Integer::sum);
//        if (wordsDictionary.get(word) == null) {
//            wordsDictionary.put(word, 1);
//        } else {
//            wordsDictionary.put(word, wordsDictionary.get(word) + 1);
//        }
        ++allWordsNumber;
    }
}
