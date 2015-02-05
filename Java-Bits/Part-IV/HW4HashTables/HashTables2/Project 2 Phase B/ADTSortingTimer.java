/**
 * Print out the time of processing the text and printing out the word and its count in descending order 
 * used by different combinations of an abstract data type and a sorting algorithm.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class ADTSortingTimer {
	
	/**
	 * @param args name of the file
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Invalid number of arguments");
            System.exit(1);
		} else {
			long startTime, endTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-b", "-is", args[0]});
			endTime=System.currentTimeMillis();
			long bis = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-b", "-hs", args[0]});
			endTime=System.currentTimeMillis();
			long bhs = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-b", "-os", args[0]});
			endTime=System.currentTimeMillis();
			long bos = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-a", "-is", args[0]});
			endTime=System.currentTimeMillis();
			long ais = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-a", "-hs", args[0]});
			endTime=System.currentTimeMillis();
			long ahs = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-a", "-os", args[0]});
			endTime=System.currentTimeMillis();
			long aos = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-m", "-is", args[0]});
			endTime=System.currentTimeMillis();
			long mis = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-m", "-hs", args[0]});
			endTime=System.currentTimeMillis();
			long mhs = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-m", "-os", args[0]});
			endTime=System.currentTimeMillis();
			long mos = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-h", "-is", args[0]});
			endTime=System.currentTimeMillis();
			long his = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-h", "-hs", args[0]});
			endTime=System.currentTimeMillis();
			long hhs = endTime - startTime;
			
			startTime = System.currentTimeMillis();
			WordCount.main(new String[]{"-h", "-os", args[0]});
			endTime=System.currentTimeMillis();
			long hos = endTime - startTime;
			System.out.println();
			
			System.out.println("Timing Results: ");
			System.out.println("Time of BinarySearchTree + insertionSort: " + bis + " ms");
			System.out.println("Time of BinarySearchTree + heapSort: " + bhs + " ms");
			System.out.println("Time of BinarySearchTree + mergeSort: " + bos + " ms");
			System.out.println("Time of AVLTree + insertionSort: " + ais + " ms");
			System.out.println("Time of AVLTree + heapSort: " + ahs + " ms");
			System.out.println("Time of AVLTree + mergeSort: " + aos + " ms");
			System.out.println("Time of MoveToFrontList + insertionSort: " + mis + " ms");
			System.out.println("Time of MoveToFrontList + heapSort: " + mhs + " ms");
			System.out.println("Time of MoveToFrontList + mergeSort: " + mos + " ms");
			System.out.println("Time of Hashtable + insertionSort: " + his + " ms");
			System.out.println("Time of Hashtable + heapSort: " + hhs + " ms");
			System.out.println("Time of Hashtable + mergeSort: " + hos + " ms");
		}
	}
}