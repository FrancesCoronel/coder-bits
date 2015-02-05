import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in descending order.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class WordCount {

	/**
	 * Return an array of DataCount objects containing each unique word.
	 * 
	 * @param counter a DataCounter which contains E objects
	 * @return an array of DataCount objects containing each unique word
	 */
	@SuppressWarnings("unchecked")
	private static <E> DataCount<E>[] getCountsArray(DataCounter<E> counter) {
		DataCount<E>[] dataCountArray = (DataCount<E>[]) new DataCount[counter.getSize()];
		SimpleIterator<DataCount<E>> dataCountIt = counter.getIterator();
		int idx = 0; // index of the array
		while (dataCountIt.hasNext()) {
			dataCountArray[idx] = dataCountIt.next();
			idx++;
		}
		return dataCountArray;
	}
	
	/**
	 * Count the words' occurring times in the file and print them out.
	 * 
	 * @param adt type of the data structure
	 * @param sortingType type of the sorting algorithm
	 * @param file file to be read
	 * @throws UnsupportedOperationException if adt passed in is not -b, -a, -m, or -h and 
	 * if sortingType passed in is not -is, -hs, -os
	 */
    private static void countWords(String adt, String sortingType, String file) {
    	DataCounter<String> counter;
    	DataCount<String>[] counts;
    	if (adt.equals("-b")) { 
    	    counter = new BinarySearchTree<String>(new StringComparator());
    	} else if (adt.equals("-a")) {
    		counter = new AVLTree<String>(new StringComparator());
    	} else if (adt.equals("-m")) {
    		counter = new MoveToFrontList<String>(new StringComparator());
    	} else if (adt.equals("-h")){
    		counter = new Hashtable<String>(new StringComparator(), new StringHasher());
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
    	} else if (sortingType.equals("-os")) {
    		mergeSort(counts, new DataCountStringComparator());
    	} else {
    		throw new UnsupportedOperationException();
    	}
        for (DataCount<String> c : counts)
            System.out.println(c.count + " \t" + c.data);
    }
    
    /**
	 * Count the words' occurring times in the file and print them out.
	 * This method is used to sort and print out k most-frequently occurring words.  
	 * 
	 * @param adt type of the data structure
	 * @param sortingType type of the sorting algorithm
	 * @param num number of words to be printed out
	 * @param file file to be read
	 * @throws UnsupportedOperationException if adt passed in is not -b, -a, -m, or -h
	 */
    @SuppressWarnings("unchecked")
	private static void countWords(String adt, String sortingType, String num, String file) {
    	DataCounter<String> counter;
    	DataCount<String>[] counts;
    	if (adt.equals("-b")) { 
    	    counter = new BinarySearchTree<String>(new StringComparator());
    	} else if (adt.equals("-a")) {
    		counter = new AVLTree<String>(new StringComparator());
    	} else if (adt.equals("-m")) {
    		counter = new MoveToFrontList<String>(new StringComparator());
    	} else if (adt.equals("-h")){
    		counter = new Hashtable<String>(new StringComparator(), new StringHasher());
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
	    
	    int k = 0;
	    try { 
	    	k = Integer.parseInt(num); 
	    } catch(NumberFormatException e) { 
	    	System.err.println("Error processing " + num + " " + e);
            System.exit(1); 
	    }
	    
		PriorityQueue<DataCount<String>> kWords = topK(counts, new Comparator<DataCount<String>>() {
			public int compare(DataCount<String> e1, DataCount<String> e2) {
				StringComparator alphabetical = new StringComparator();
				if(e1.count != e2.count)
					return e1.count - e2.count;
				return alphabetical.compare(e1.data, e2.data);
			}
		}, k);
		
		DataCount<String>[] arr;
		if (k >= counts.length) {
			arr = (DataCount<String>[]) new DataCount[counts.length];
		} else {
			arr = (DataCount<String>[]) new DataCount[k];
		}
		
		for (int i = arr.length - 1; i >= 0; i--)
			arr[i] = kWords.deleteMin();
		for (DataCount<String> c : arr)
            System.out.println(c.count + " \t" + c.data);
    }
    
    /**
     * Sort the counts array in descending order of count. If two elements have
     * the same count, they should be in ordered according to the comparator,
     * but the code below does not do this. 
     * 
     * This code uses insertion sort. The code is generic, but in this project
     * we use it with DataCount<String> and DataCountStringComparator.
     * 
     * @param array counts array to be sorted.
	 * @param comparator comparator for comparing elements.
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
     * Sort the counts array in descending order of count. 
     * This code uses heap sort.
     * 
     * @param array counts array to be sorted
	 * @param comparator comparator for comparing elements
     */
    public static <E> void heapSort(E[] array, Comparator<E> comparator) {
    	PriorityQueue<E> heap = new FourHeap<E>(comparator);
    	for (int i = 0; i < array.length; i++)
    		heap.insert(array[i]);
    	for (int j = 0; j < array.length; j++)
    		array[j] = heap.deleteMin();
    }
    
    /**
     * Sort the counts array in descending order of count. 
     * This code uses merge sort.
     * 
     * @param array counts array to be sorted
	 * @param comparator comparator for comparing elements
     */
    @SuppressWarnings("unchecked")
	public static <E> void mergeSort(E[] array, Comparator<E> comparator) {
    	E[] tempArray = (E[]) new Object[array.length];
    	mergeSort(array, tempArray, comparator, 0, array.length - 1);
    }
    
    /**
     * Helper method for merge sort. Divide the original array into two parts and then merge them in descending order.
     * 
     * @param array counts array to be sorted
     * @param tempArray an array to place the merged result
     * @param comparator comparator for comparing elements
     * @param left the first index of the subarray
     * @param right the last index of the subarray
     */
    private static <E> void mergeSort(E[] array, E[] tempArray, Comparator<E> comparator, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, tempArray, comparator, left, middle);
            mergeSort(array, tempArray, comparator, middle + 1, right);
            merge(array, tempArray, comparator, left, middle + 1, right);
        }
    }
    
    /**
     * Merge two subarrays together in descending order of count.
     * 
     * @param array counts array to be sorted
     * @param tempArray an array to place the merged result
     * @param comparator comparator for comparing elements
     * @param leftPos the first index of the subarray
     * @param rightPos the index of the start of the second half
     * @param rightEnd the last index of the subarray
     */
    private static <E> void merge(E [] array, E [] tempArray, Comparator<E> comparator, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int startPos = leftPos;
        
        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if (comparator.compare(array[leftPos], array[rightPos]) <= 0)
            	tempArray[tempPos++] = array[leftPos++];
            else
            	tempArray[tempPos++] = array[rightPos++];
        }
        
        while (leftPos <= leftEnd)    // copy rest of first half
        	tempArray[tempPos++] = array[leftPos++];
        
        while (rightPos <= rightEnd)  // copy rest of right half
        	tempArray[tempPos++] = array[rightPos++];
        
        // copy the sorted result back to original array
        while (startPos <= rightEnd) {
        	array[startPos] = tempArray[startPos];
        	startPos++;
        }
    }
    
    /**
     * Sort k most-frequently occurring words.
     * 
     * @param array counts array to be sorted
     * @param comparator comparator for comparing elements
     * @param k number of most-frequently occurring words
     * @return a priority queue holds k most-frequently occurring words
     */
	public static <E> PriorityQueue<E> topK(E[] array, Comparator<E> comparator, int k) {
    	if (k > array.length)
    		k = array.length;
    	PriorityQueue<E> pq = new FourHeap<E>(comparator);
    	for (int i = 0; i < k; i++)
    		pq.insert(array[i]);
    	for (int j = k; j < array.length; j++) {
    		if (comparator.compare(pq.findMin(), array[j]) < 0) {
    			pq.deleteMin();
    			pq.insert(array[j]);
    		}
    	}
    	return pq;
    }
    
	/**
	 * Main method which calls countWords to count the occurring times of the words in the file.
	 * 
	 * @param args if three arguments, first: data structure, second: sorting algorithm, third: file to be read; 
	 * if four arguments, first: data structure, second: -k, third: number of words to be printed, fourth: file to be read
	 */
    public static void main(String[] args) {
        if ((args.length < 3 && args.length > 4) || (args.length == 3 && args[1].equals("-k")) || (args.length == 4 && !args[1].equals("-k"))) {
            System.err.println("Invalid number of arguments");
            System.exit(1);
        } else if (args.length == 3) {
        	countWords(args[0], args[1], args[2]);
        } else {
        	countWords(args[0], args[1], args[2], args[3]);
        }
    }
}