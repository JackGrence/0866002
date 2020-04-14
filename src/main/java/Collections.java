import java.util.Comparator;

public class Collections {
    static final <T> int compare(T o1, T o2, Comparator<? super T> c) {
        return c == null ? ((Comparable) o1).compareTo(o2) : c.compare(o1, o2);
    }
}
