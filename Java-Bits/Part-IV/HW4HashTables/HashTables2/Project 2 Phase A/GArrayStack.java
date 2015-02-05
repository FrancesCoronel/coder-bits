import java.util.EmptyStackException;

/**
 * This class implements generic stacks by array.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class GArrayStack<T> implements GStack<T> {

	private T[] stack;    // an array that holds the elements of the stack
	private int size;      // size of the stack
	
	/**
	 * Create an empty Stack.
	 */
	@SuppressWarnings("unchecked")
	public GArrayStack() {
		stack = (T[]) new Object[10];
		size = 0;
	}
	
	/**
	 * Returns true if the stack is empty.
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Stores a value of type T into stack.
	 * 
	 * @param d a value of type T
	 */
	public void push(T d) {
		ensureCapacity();
		stack[size] = d;
		size++;
	}
	
	/**
	 * Ensures the stack has space to store at least one more value. If the space is not enough 
	 * to store one more value, create a new one with twice as the old capacity and 
	 * copy the old values stored in the stack into the new one.
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (size < stack.length)
			return;
		T[] tempStack = (T[]) new Object[stack.length * 2];
		for (int i = 0; i < size; i++) {
			tempStack[i] = stack[i];
		}
		stack = tempStack;
	}

	/**
	 * Returns the last value stored into the stack and removes it from the stack.
	 * 
	 * @return the last value stored into the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		T value = stack[size - 1];
		size--;
		return value;
	}

	/**
	 * Returns the last value stored into the stack and without modifying the stack.
	 * 
	 * @return the last value stored into the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return stack[size - 1];
	}
}