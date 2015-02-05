/**
 * A comparator used to compare two strings and determine which comes first alphabetically.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class StringComparator implements Comparator<String> {
	/**
	 * Compare two strings and return -1 if first argument to compare comes first alphabetically, 
	 * 1 if second argument to compare comes first alphabetically, or 0 if two arguments are the same.
	 * 
	 * @param e1 first String argument
	 * @param e2 second String argument
	 * @return -1 if first argument to compare comes first alphabetically, 
	 * 1 if second argument to compare comes first alphabetically, or 0 if two arguments are the same.
	 */
	public int compare(String e1, String e2) {
		int l1 = e1.length();
		int l2 = e2.length();
		int smaller;
		
		if (l1 <= l2)
			smaller = l1;
		else
			smaller = l2;
		
		for (int i = 0; i < smaller; i++) {
			if (e1.charAt(i) < e2.charAt(i))
				return -1;
			else if (e1.charAt(i) > e2.charAt(i))
				return 1;
		}
		
		if (smaller == l1 && smaller == l2)  // two strings are the same
			return 0;
		else if (smaller == l2)   // second string is first string's substring(0, l2 - 1)
			return 1;
		else                      // first string is second string's substring(0, l2 - 1)
			return -1;
	}
}
