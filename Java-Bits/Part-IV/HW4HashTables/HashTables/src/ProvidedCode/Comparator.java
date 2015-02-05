/*
 * interface for function objects that compare elements
 */

package providedCode;

public interface Comparator<E> 
{
	public int compare(E e1, E e2);
}
