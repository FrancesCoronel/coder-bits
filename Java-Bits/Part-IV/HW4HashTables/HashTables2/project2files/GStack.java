/**
 * Interface for a type-generic stack.
 * 
 */
public interface GStack<T> {
    /** 
     * is empty?
     */
    public boolean isEmpty();

    /**
     * push
     */
    public void push(T d);

    /**
     * pop
     * @return the deleted value
     * @throws EmptyStackException if stack is empty
     */
    public T pop();

    /**
     * peek
     * @throws EmptyStackException if stack is empty
     */
    public T peek();
}
