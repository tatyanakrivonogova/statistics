import java.util.HashMap;

public class Statistics {
    int allWordsNumber = 0;
    HashMap<String, Integer> wordsDictionary;

    public Statistics() {
        wordsDictionary = new HashMap<>();
    }

    public HashMap<String, Integer> getWordsDictionary() {
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
