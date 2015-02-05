import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

	// TODO implement this method (if the generics confuse you,
	//      you might do a non-generic version first and then adjust it)
	// return an array of DataCount objects containing each unique word 
	public static <E> DataCount<E>[] getCountsArray(DataCounter<E> counter) {
		System.err.println("Must implement getCountsArray in WordCount");
		System.exit(1);
		return null;
	}
	
    private static void countWords(String file) {
        DataCounter<String> counter = new BinarySearchTree<String>(new StringComparator());
        
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

        DataCount<String>[] counts = getCountsArray(counter);
        insertionSort(counts, new DataCountStringComparator());
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
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: filename of document to analyze");
            System.exit(1);
        }
        countWords(args[0]);
    }
}
