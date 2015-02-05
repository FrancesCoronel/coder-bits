/**
 * Print out the time of processing the text and printing out k most-frequently occurring words and its count in descending order 
 * used by nlogk approach and nlogn approach.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class TopKTimer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime, endTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "1", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k0 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"1", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n0 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "4", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k1 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"4", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n1 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "16", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k2 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"16", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n2 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "64", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k3 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"64", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n3 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "256", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k4 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"256", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n4 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "1024", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k5 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"1024", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n5 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "4096", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k6 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"4096", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n6 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "16384", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k7 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"16384", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n7 = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		WordCount.main(new String[]{"-b", "-k", "34109", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long k8 = endTime - startTime;
		startTime = System.currentTimeMillis();
		WordCount2.main(new String[]{"34109", "hamlet.txt"});
		endTime = System.currentTimeMillis();
		long n8 = endTime - startTime;
		
		
		System.out.println();
		System.out.println("Timing Results: ");
		System.out.println("Time of nlogk Approach with k = 2: " + k0 + " ms");
		System.out.println("Time of nlogn Approach with k = 2: " + n0 + " ms");
		System.out.println("Time of nlogk Approach with k = 4: " + k1 + " ms");
		System.out.println("Time of nlogn Approach with k = 4: " + n1 + " ms");
		System.out.println("Time of nlogk Approach with k = 16: " + k2 + " ms");
		System.out.println("Time of nlogn Approach with k = 16: " + n2 + " ms");
		System.out.println("Time of nlogk Approach with k = 64: " + k3 + " ms");
		System.out.println("Time of nlogn Approach with k = 64: " + n3 + " ms");
		System.out.println("Time of nlogk Approach with k = 256: " + k4 + " ms");
		System.out.println("Time of nlogn Approach with k = 256: " + n4 + " ms");
		System.out.println("Time of nlogk Approach with k = 1024: " + k5 + " ms");
		System.out.println("Time of nlogn Approach with k = 1024: " + n5 + " ms");
		System.out.println("Time of nlogk Approach with k = 4096: " + k6 + " ms");
		System.out.println("Time of nlogn Approach with k = 4096: " + n6 + " ms");
		System.out.println("Time of nlogk Approach with k = 16384: " + k7 + " ms");
		System.out.println("Time of nlogn Approach with k = 16384: " + n7 + " ms");
		System.out.println("Time of nlogk Approach with k = 34109: " + k8 + " ms");
		System.out.println("Time of nlogn Approach with k = 34109: " + n8 + " ms");
	}
}