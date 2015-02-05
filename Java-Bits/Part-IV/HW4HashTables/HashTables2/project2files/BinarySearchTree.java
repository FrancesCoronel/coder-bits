/**
 * BinarySearchTree implements the DataCounter interface using
 * a binary search tree.  The constructor takes a Comparator<? super E> 
 * "fuction object" so that items of type E can be compared.  
 * Each tree node associates a count with an E.
 *
 * @param <E> The type of the data elements. 
 */
public class BinarySearchTree<E> implements DataCounter<E> {

    /**
     * The root of the binary search tree. root is null if and only if the tree
     * is empty.
     */
    protected BSTNode overallRoot;

    /**
     * Number of nodes in the binary search tree.
     */
    protected int size;

    /**
     * Function object to compare elements of type E, passed in constructor.
     */
    protected Comparator<? super E> comparator;
    
    /**
     * Inner class to represent a node in the tree. Each node
     * includes a data of type E and an integer count. The class is protected so that
     * subclasses of BinarySearchTree can access it.
     */
    protected class BSTNode {
        /**
         * The left child of this node.
         */
        public BSTNode left;

        /**
         * The right child of this node.
         */
        public BSTNode right;

        /**
         * The data element stored at this node.
         */
        public E data;

        /**
         * The count for this data element.
         */
        public int count;

        /**
         * Create a new data node and increment the enclosing tree's size.
         *
         * @param data data element to be stored at this node.
         */
        public BSTNode(E d) {
            data  = d;
            count = 1;
            left  = null;
            right = null;
            size++;
        }
    }

    /**
     * Create an empty binary search tree.
     */
    public BinarySearchTree(Comparator<? super E> c) {
        overallRoot = null;
        size = 0;
        comparator = c;
    }

    /** {@inheritDoc} */
    public void incCount(E data) {
        if (overallRoot == null) {
            overallRoot = new BSTNode(data);
            return;
        }
        // traverse the tree
        BSTNode currentNode = overallRoot;
        while (true) {
        	// compare the new data with the data at the current node
        	int cmp = comparator.compare(data, currentNode.data);
        	
        	if (cmp == 0) {
        		// current node is a match
        		currentNode.count++;
        		return;
             } else if (cmp < 0) {
            	 // new data goes to the left of the current node
            	 if (currentNode.left == null) {
            		 currentNode.left = new BSTNode(data);
            		 return;
                 }	
            	 currentNode = currentNode.left;
              } else {
            	  // new data goes to the right of the current node
            	  if (currentNode.right == null) {
            		  currentNode.right = new BSTNode(data);
            		  return;
                  }
                  currentNode = currentNode.right;
              }
        }
    }
    
    /** {@inheritDoc} */
    public int getCount(E data) {
    	BSTNode n = overallRoot;
    	while(n != null) {
    		int cmp = comparator.compare(data, n.data);
    		if(cmp < 0)
    			n = n.left;
    		else if(cmp > 0)
    			n = n.right;
    		else
    			return n.count;
    	}
    	return 0;
    }
    
    /** {@inheritDoc} */
    public int getSize() {
        return size;
    }
    
    /** {@inheritDoc} */
    public SimpleIterator<DataCount<E>> getIterator() {
    	// anonymous inner class
    	return new SimpleIterator<DataCount<E>>() {
    		// keep a stack of yet-to-be-processed nodes, initialized to the root, if present
    		GStack<BSTNode> stack = new GArrayStack<BSTNode>();
    		{
    			if(overallRoot!=null) stack.push(overallRoot);
    		}
    		public boolean hasNext() {
        		return !stack.isEmpty();
        	}
        	public DataCount<E> next() {
        		if(!hasNext())
        			throw new java.util.NoSuchElementException();
        		BSTNode nextNode = stack.pop();
        		if(nextNode.left != null)
        			stack.push(nextNode.left);
        		if(nextNode.right != null)
        			stack.push(nextNode.right);
        		return new DataCount<E>(nextNode.data, nextNode.count);
        	}
    	};
    }
    
    /**
     * Dump the contents of the tree to a String 
     * (provided for debugging and testing purposes).
     *
     * @return a textual representation of the tree.
     */
    protected String dump() {
        if (overallRoot != null)
            return dump(overallRoot);
        return "<empty tree>";
    }

    /**
     * Dump the contents of the tree to a String 
     * (provided for debugging and testing purposes).
     *
     * @return a textual representation of the subtree rooted at this node.
     */
    protected String dump(BSTNode root) {
        if(root == null)
            return ".";

        String out = "([" + root.data + "," + root.count + "] ";
        out += dump(root.left);
        out += " ";
        out += dump(root.right);
        out += ")";

        return out;
    }
}
