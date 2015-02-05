/**
 * A Comparator for DataCount<String> that sorts two data-counts in the order
 * we need for the output of WordCount: Higher frequency comes first and
 * frequency ties are resolved in alphabetical order.
 * 
 * Uses StringComparator, which you must implement.
 */
public class DataCountStringComparator implements Comparator<DataCount<String>>{
	StringComparator alphabetical = new StringComparator();
	public int compare(DataCount<String> c1, DataCount<String> c2) {
		if(c1.count != c2.count)
			return c2.count - c1.count;
		return alphabetical.compare(c1.data, c2.data);
	}
}
