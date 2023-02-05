import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class OutputStatistics {
    Writer fout;
    Statistics dictionary;

    public OutputStatistics(String outputFile, Statistics dict) throws FileNotFoundException, UnsupportedEncodingException {
        fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
        //fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
        //fout = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(outputFile)), "UTF-8"));
        dictionary = dict;
    }

    public void outputData() throws IOException {
//        Comparator<String> comparator = new MyComparator(dictionary.getDictionary());
//        SortedMap<String, Integer> sortedMap = new TreeMap<>(comparator);
//        sortedMap.putAll(dictionary.getDictionary());
//
//        for (Object o : sortedMap.keySet()) {
//            //System.out.println(o + ";" + sortedMap.get(o) + ";");
//            fout.write((o + ";" + sortedMap.get(o) + "\n").getBytes());
//        }

        ArrayList<Record> sortedDictionary = new ArrayList<>();
        for (String o : dictionary.getDictionary().keySet()) {
            sortedDictionary.add(new Record(o, dictionary.getDictionary().get(o)));
        }
        Comparator<Record> comparator = new MyComparator();
        Collections.sort(sortedDictionary, comparator);

//        for (Object o : dictionary.getDictionary().keySet()) {
//            System.out.println(o + ";" + dictionary.getDictionary().get(o) + ";");
//        }

        for (Record o : sortedDictionary) {
            //System.out.println(o.word + ";" + o.number + "\n");
            //fout.write((o.word + ";" + o.number + "\n").getBytes());
            //fout.println(o.word + ";" + o.number);
            fout.write(o.word + ";" + o.number + ";" + (double) o.number / dictionary.getAllWordsNumber() + "\n");
        }
        fout.flush();
        fout.close();

    }
}
