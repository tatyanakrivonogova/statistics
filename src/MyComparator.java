import java.util.Comparator;

class recordComparator implements Comparator<Record> {
    @Override
    public int compare(Record first, Record second)
    {
        return first.number.equals(second.number) ? first.word.compareTo(second.word) : second.number.compareTo(first.number); //sort in descending order
    }
}