import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

//public class MyComparator<String, Integer extends Comparable> implements Comparator<String> {
//    private SortedMap<String, Integer> map;
//
//    public MyComparator(SortedMap<String, Integer> map) {
//        this.map = new TreeMap<String, Integer>(map);
//    }
//
//    public int compare(String s1, String s2) {
//        return map.get(s1).compareTo(map.get(s2));
//    }
//}

//class MyComparator<Record> implements Comparator<Record> {
//
//    // override the compare() method
//    public int compare(Record first, Record second)
//    {
//        if (first.pup() == second.getCount()) {
//            return 0;
//        } else if (first.getNumber() < second.getNumber())
//            return 1;
//        else
//            return -1;
//    }
//}

class MyComparator implements Comparator<Record> {

    public int compare(Record first, Record second)
    {
        if (first.number == second.number)
            return 0;
        else if (first.number > second.number)
            return -1;
        else
            return 1;
    }
}