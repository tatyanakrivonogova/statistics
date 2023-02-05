import java.util.Comparator;

class recordComparator implements Comparator<Record> {
    @Override
    public int compare(Record first, Record second)
    {
        return second.number.compareTo(first.number); //sort in descending order
    }
}