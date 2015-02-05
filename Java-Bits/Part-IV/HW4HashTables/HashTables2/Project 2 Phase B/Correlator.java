import java.io.IOException;

/**
 * An executable that computes correlation between two files.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class Correlator {
	
	/**
	 * Compute the correlation between two files.
	 * 
	 * @param adt type of the data structure
	 * @param file1 first file to be read
	 * @param file2 second file to be read
	 * @return correlation between file1 and file2
	 */
	private static double computeCorrelation(String adt, String file1, String file2) {
    	DataCounter<String> counter1;
    	DataCounter<String> counter2;
    	double length1 = 0;
    	double length2 = 0; 
    	
    	if (adt.equals("-b")) { 
    	    counter1 = new BinarySearchTree<String>(new StringComparator());
    	    counter2 = new BinarySearchTree<String>(new StringComparator());
    	} else if (adt.equals("-a")) {
    		counter1 = new AVLTree<String>(new StringComparator());
    		counter2 = new AVLTree<String>(new StringComparator());
    	} else if (adt.equals("-m")) {
    		counter1 = new MoveToFrontList<String>(new StringComparator());
    		counter2 = new MoveToFrontList<String>(new StringComparator());
    	} else if (adt.equals("-h")){
    		counter1 = new Hashtable<String>(new StringComparator(), new StringHasher());
    		counter2 = new Hashtable<String>(new StringComparator(), new StringHasher());
    	} else {
    		throw new UnsupportedOperationException();
    	}
        
        try {
            FileWordReader reader = new FileWordReader(file1);
            String word = reader.nextWord();
            while (word != null) {
                counter1.incCount(word);
                length1++;
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file1 + " " + e);
            System.exit(1);
        }
        
        try {
            FileWordReader reader = new FileWordReader(file2);
            String word = reader.nextWord();
            while (word != null) {
                counter2.incCount(word);
                length2++;
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file2 + " " + e);
            System.exit(1);
        }
        
        SimpleIterator<DataCount<String>> dataCountIt = counter1.getIterator();
        double correlation = 0;
        while (dataCountIt.hasNext()) {
        	DataCount<String> c1 = dataCountIt.next();
        	int c2 = counter2.getCount(c1.data);
        	double f1 = c1.count / length1;
        	double f2 = c2 / length2;
        	// only take the word occurs in both files and its occurring frequencies are >= 0.0001 and <= 0.01 in both files into account
        	if (c2 != 0 && (f1 <= 0.01 && f1 >= 0.0001) && (f2 <= 0.01 && f2 >= 0.0001))
        		correlation += (f1 - f2) * (f1 - f2);
        }
        
        return correlation;
	}
	 
	/**
	 * Main method which calls computeCorrelation to compute the correlation between two files.
	 * 
	 * @param args first: data structure, second: first file to be read, third: second file to be read
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Invalid number of arguments");
            System.exit(1);
		}
		double correlation = computeCorrelation(args[0], args[1], args[2]);
		System.out.println(correlation);
	}
}