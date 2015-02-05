import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in descending order.
 * This is only for top k experimentation. To keep things simple, this class 
 * only supports using binary search tree, merge sort to do the word count.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class WordCount2 {

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
	 * @param num number of words to be printed
	 * @param file file to be read
	 */
    private static void countWords(String num, String file) {
    	DataCounter<String> counter = new BinarySearchTree<String>(new StringComparator());
    	DataCount<String>[] counts;
        
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
	    
	    WordCount.mergeSort(counts, new DataCountStringComparator());
	    if (k > counts.length)
	    	k = counts.length;
	    for (int i = 0; i < k; i++)
	        System.out.println(counts[i].count + " \t" + counts[i].data);
    }
    
	/**
	 * Main method which calls countWords to count the occurring times of the words in the file.
	 * 
	 * @param args two arguments, first: number of words to be printed, second: name of the file to be read
	 */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Invalid number of arguments");
            System.exit(1);
        } else {
        	countWords(args[0], args[1]);
        }
    }
}