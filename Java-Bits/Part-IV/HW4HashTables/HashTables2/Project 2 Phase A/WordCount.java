import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class WordCount {

	/**
	 * Return an array of DataCount objects containing each unique word.
	 * 
	 * @param counter a DataCounter which contains E objects
	 * @return an array of DataCount objects containing each unique word
	 */
	@SuppressWarnings("unchecked")
	public static <E> DataCount<E>[] getCountsArray(DataCounter<E> counter) {
		DataCount<E>[] dataCountArray = (DataCount<E>[]) new DataCount[counter.getSize()];
		SimpleIterator<DataCount<E>> dataCountIt = counter.getIterator();
		int idx = 0; // index of the array
		while (dataCountIt.hasNext()) {
			dataCountArray[idx] = dataCountIt.next();
			idx++;
		}
		return dataCountArray;
	}
	
    private static void countWords(String adt, String sortingType, String file) {
    	DataCounter<String> counter;
    	DataCount<String>[] counts;
    	if (adt.equals("-b")) { 
    	    counter = new BinarySearchTree<String>(new StringComparator());
    	} else if (adt.equals("-a")) {
    		counter = new AVLTree<String>(new StringComparator());
    	} else if (adt.equals("-m")) {
    		counter = new MoveToFrontList<String>(new StringComparator());
    	} else {
    		throw new UnsupportedOperationException();
    	}
        
        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + " " + e);
            System.exit(1);
        }
        
	    counts = getCountsArray(counter);
	    
    	if (sortingType.equals("-is")) {
    		insertionSort(counts, new DataCountStringComparator());
    	} else if (sortingType.equals("-hs")) {
    		heapSort(counts, new DataCountStringComparator());
    	} else {
    		throw new UnsupportedOperationException();
    	}
        for (DataCount<String> c : counts)
            System.out.println(c.count + " \t" + c.data);
    }
    
    /**
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in ordered according to the comparator,
     * but the code below does not do this. 
     * 
     * This code uses insertion sort. The code is generic, but in this project
     * we use it with DataCount<String> and DataCountStringComparator.
     * 
     * @param counts array to be sorted.
	 * @param comparator for comparing elements.
     */
    public static <E> void insertionSort(E[] array, Comparator<E> comparator) {
        for (int i = 1; i < array.length; i++) {
            E x = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (comparator.compare(x,array[j]) >= 0) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = x;
        }
    }
    
    /**
     * Sort the count array in descending order of count. 
     * This code uses heap sort.
     * 
     * @param counts array to be sorted.
	 * @param comparator for comparing elements.
     */
    public static <E> void heapSort(E[] array, Comparator<E> comparator) {
    	PriorityQueue<E> heap = new FourHeap<E>(comparator);
    	for (int i = 0; i < array.length; i++)
    		heap.insert(array[i]);
    	for (int j = 0; j < array.length; j++)
    		array[j] = heap.deleteMin();
    }
    
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: filename of document to analyze");
            System.exit(1);
        }
        countWords(args[0], args[1], args[2]);
    }
}
