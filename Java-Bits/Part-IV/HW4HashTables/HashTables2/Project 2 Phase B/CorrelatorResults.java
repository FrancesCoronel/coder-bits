/**
 * Results of correlation between different works. 
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class CorrelatorResults {
	
	/**
	 * Print out the result of correlations.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Results of Correlation: ");
		System.out.println();
		
		System.out.println("Correlation between works that are known to be written by Bacon.");
		System.out.print("The Advancement of Learning vs The Essays: ");
		Correlator.main(new String[]{"-b", "the-advancement-of-learning.txt", "the-essays-of-francis-bacon.txt"});
		System.out.println();
		
		System.out.println("Correlation between The New Atlantis and other works.");
		System.out.print("The New Atlantis vs The Advancement of Learning: ");
		Correlator.main(new String[]{"-b", "the-new-atlantis.txt", "the-advancement-of-learning.txt"});
		System.out.print("The New Atlantis vs The Essays: ");
		Correlator.main(new String[]{"-b", "the-new-atlantis.txt", "the-essays-of-francis-bacon.txt"});
		System.out.print("The New Atlantis vs Macbeth: ");
		Correlator.main(new String[]{"-b", "the-new-atlantis.txt", "macbeth.txt"});
		System.out.print("The New Atlantis vs King Lear: ");
		Correlator.main(new String[]{"-b", "the-new-atlantis.txt", "king-lear.txt"});
		System.out.print("The New Atlantis vs Romeo and Juliet: ");
		Correlator.main(new String[]{"-b", "the-new-atlantis.txt", "romeo-and-juliet.txt"});
		System.out.print("The New Atlantis vs Hamlet: ");
		Correlator.main(new String[]{"-b", "the-new-atlantis.txt", "hamlet.txt"});
		System.out.println();
		
		System.out.println("Correlation between works that are known to be written by Shakespeare.");
		System.out.print("King Lear vs Macbeth: ");
		Correlator.main(new String[]{"-b", "king-lear.txt", "macbeth.txt"});
		System.out.print("Romeo and Juliet vs Macbeth: ");
		Correlator.main(new String[]{"-b", "romeo-and-juliet.txt", "macbeth.txt"});
		System.out.print("Romeo and Juliet vs King Lear: ");
		Correlator.main(new String[]{"-b", "romeo-and-juliet.txt", "king-lear.txt"});
		System.out.println();
		
		System.out.println("Correlation between Hamlet and other works.");
		System.out.print("Hamlet vs King Lear: ");
		Correlator.main(new String[]{"-b", "hamlet.txt", "king-lear.txt"});
		System.out.print("Hamlet vs Macbeth: ");
		Correlator.main(new String[]{"-b", "hamlet.txt", "macbeth.txt"});
		System.out.print("Hamlet vs Romeo and Juliet: ");
		Correlator.main(new String[]{"-b", "hamlet.txt", "romeo-and-juliet.txt"});
		System.out.print("Hamlet vs The Advancement of Learning: ");
		Correlator.main(new String[]{"-b", "hamlet.txt", "the-advancement-of-learning.txt"});
		System.out.print("Hamlet vs The Essays: ");
		Correlator.main(new String[]{"-b", "hamlet.txt", "the-essays-of-francis-bacon.txt"});
		System.out.println();
		
		System.out.println("Correlation between other works.");
		System.out.print("King Lear vs The Advancement of Learning: ");
		Correlator.main(new String[]{"-b", "king-lear.txt", "the-advancement-of-learning.txt"});
		System.out.print("King Lear vs The Essays: ");
		Correlator.main(new String[]{"-b", "king-lear.txt", "the-essays-of-francis-bacon.txt"});
		System.out.print("Romeo and Juliet vs The Advancement of Learning: ");
		Correlator.main(new String[]{"-b", "romeo-and-juliet.txt", "the-advancement-of-learning.txt"});
		System.out.print("Romeo and Juliet vs The Essays: ");
		Correlator.main(new String[]{"-b", "romeo-and-juliet.txt", "the-essays-of-francis-bacon.txt"});
		System.out.print("Macbeth vs The Advancement of Learning: ");
		Correlator.main(new String[]{"-b", "macbeth.txt", "the-advancement-of-learning.txt"});
		System.out.print("Macbeth vs The Essays: ");
		Correlator.main(new String[]{"-b", "macbeth.txt", "the-essays-of-francis-bacon.txt"});
	}
}