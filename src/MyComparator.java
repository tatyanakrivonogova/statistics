import java.util.Comparator;
import java.util.Objects;

class recordComparator implements Comparator<Record> {
    @Override
    public int compare(Record first, Record second)
    {
        return second.number.compareTo(first.number); //sort in descending order
    }
}