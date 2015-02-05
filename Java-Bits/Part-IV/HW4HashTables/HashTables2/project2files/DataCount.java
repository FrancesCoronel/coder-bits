/**
 * Simple class to hold a piece of data and its count. The class has package
 * access so that the various implementations of DataCounter can access its
 * contents.  See also the return type of the getIterator method of DataCounter.
 * 
 * @param <E> type of data whose count we are recording.
 */
class DataCount<E> {
    /**
     * The data element whose count we are recording.
     */
    E data;

    /**
     * The count for the data element.
     */
    int count;

    /**
     * Create a new data count.
     * 
     * @param data the data element whose count we are recording.
     * @param count the count for the data element.
     */
    DataCount(E data, int count) {
        this.data = data;
        this.count = count;
    }
}
