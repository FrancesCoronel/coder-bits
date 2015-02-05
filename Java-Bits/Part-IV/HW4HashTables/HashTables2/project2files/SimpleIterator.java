/**  Interface for a simpler iterator for returning DataCount<E> elements from a 
 *   DataCounter<E> one at a time.  We do not use Java's iterators because we
 *   don't want to obey all the rules for correct iterators.
 */
public interface SimpleIterator<E> {
	/**
	 * @return next element in collection
	 * @throws java.util.NoSuchElementException if no next element
	 */
	E next();
	
	/**
	 * @return whether there are more elements to iterate through
	 */
	boolean hasNext();
}
