/** 
 * interface for function objects that hash data
 */
public interface Hasher<E> {
	int hash(E e);
}
