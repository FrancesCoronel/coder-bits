/**
 * AVLTree implements the DataCounter interface using an AVL tree.
 * It will check if the tree is balanced after inserting a new node, 
 * and repair it when it is imbalanced.
 * 
 * @param <E>
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class AVLTree<E> extends BinarySearchTree<E> {
	
	/**
     * Inner class to represent a node in the tree. Each node
     * includes a data of type E and an integer count.
     */
	protected class AVLNode extends BSTNode {
		protected int height;  // the height of current node in this AVLTree
		
		/**
         * Create a new data node and increase the enclosing tree's size.
         *
         * @param d data element to be stored at this node.
         */
        public AVLNode(E d) {
        	super(d);
        	height = 0;
        }
	}
	
	/**
     * Create an empty AVL tree.
     * 
     * @param c function object to compare elements of type E
     */
    public AVLTree(Comparator<? super E> c) {
        super(c);
    }
    
    /**
     * Increase the count for a particular data element.
     * 
     * @param data data element whose count is to be increased
     */
    @SuppressWarnings("unchecked")
	public void incCount(E data) {
    	overallRoot = incCount(data, (AVLNode) overallRoot);
    }
    
    @SuppressWarnings("unchecked")
	private AVLNode incCount(E data, AVLNode n) {
    	if (n == null) {
    		n = new AVLNode(data); // add new data to the tree
    		return n;
    	}
    	int cmp = comparator.compare(data, n.data);
    	if (cmp == 0) {
    		n.count++;  // increase the count if the data is already in the tree
    	} else if (cmp < 0) {
    		n.left = incCount(data, (AVLNode) n.left);
    		if (getHeight(n.left) - getHeight(n.right) == 2) { // tree is imbalanced
    			if (comparator.compare(data, n.left.data) < 0) // left-left case (case 1)
    				n = rotateRight(n);
    			else  // left-right case (case 2)
    				n = rotateLR(n);
    		}
    		n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1; // update height
    	} else {
    		n.right = incCount(data, (AVLNode) n.right);
    		if (getHeight(n.right) - getHeight(n.left) == 2) {
    			if (comparator.compare(data, n.right.data) > 0) // right-right case (case 4)
    				n = rotateLeft(n);
    			else  // right-left case (case 3)
    				n = rotateRL(n);
    		}
    		n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1; // update height
    	}
    	return n;
    }
    
    /**
     * Single rotation -- Case 4.
     * Return the AVL tree root at n after rotating left.
     * 
     * @param n root of the AVL tree
     * @return the AVL tree root at n after rotating left
     */
    @SuppressWarnings("unchecked")
	private AVLNode rotateLeft(AVLNode n) {
    	AVLNode temp = (AVLNode) n.right;
    	n.right = temp.left;
    	temp.left = n;
    	n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    	temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
    	return temp;
    }
    
    /**
     * Single rotation -- Case 1.
     * Return the AVL tree root at n after rotating right.
     * 
     * @param n root of the AVL tree
     * @return the AVL tree root at n after rotating right
     */
    @SuppressWarnings("unchecked")
    private AVLNode rotateRight(AVLNode n) {
    	AVLNode temp = (AVLNode) n.left;
    	n.left = temp.right;
    	temp.right = n;
    	n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    	temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
    	return temp;
    }
    
    /**
     * Double rotation -- Case 2.
     * Return AVL tree root at node n after rotating left and rotating right.
     * 
     * @param n root of the AVL tree
     * @return the AVL tree root at n after rotating left and rotating right
     */
    @SuppressWarnings("unchecked")
    private AVLNode rotateLR(AVLNode n) {
    	n.left = rotateLeft((AVLNode) n.left);
    	return rotateRight(n);
    }
    
    /**
     * Double rotation -- Case 3.
     * Return the AVL tree root at node n after rotating right and rotating left.
     * 
     * @param n root of the AVL tree
     * @return the AVL tree root at n after rotating right and rotating left
     */
    @SuppressWarnings("unchecked")
    private AVLNode rotateRL(AVLNode n) {
    	n.right = rotateRight((AVLNode) n.right);
    	return rotateLeft(n);
    }
    
    /**
     * Return the height of the node in the AVL tree.
     * 
     * @param n a BST node or an AVL node
     * @return the height of the node in the AVL tree
     */
	private int getHeight(BSTNode n) {
    	if (n == null)
    		return -1;
    	return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
	
	/**
	 * Return string representation of in-order traversal of the tree (print out data only).
	 * 
	 * @return string representation of in-order traversal of the tree
	 */
	protected String InOrder() {
		return "(" + InOrder(overallRoot) + ")";
	}
	
	/**
	 * Helper method for InOrder().
	 * 
	 * @param n root node
	 * @return string representation of in-order traversal of the tree
	 */
	private String InOrder(BSTNode n) {
		String out;
		if (n.left == null && n.right == null) {  // split into four parts because of the format of the result
			out = "" + n.data;
		} else if (n.left == null) {
		    out = n.data + ", ";
			out += InOrder(n.right);
		} else if (n.right == null) {
			out = InOrder(n.left) + ", ";
			out += n.data;
		} else {
			out = InOrder(n.left) + ", ";
			out += n.data + ", ";
			out += InOrder(n.right);
		}
		return out;
	}
	
	/**
     * Return string representation of data and height stored in every nodes in the tree (pre-order).
     * 
     * @return string representation of data and height stored in every nodes in the tree
     */
    @SuppressWarnings("unchecked")
	protected String dataAndHeight() {
        if (overallRoot != null)
            return dataAndHeight((AVLNode) overallRoot);
        return "<empty tree>";
    }
    
    /**
     * 
     * @param n root node
     * @return string representation of data and height stored in every nodes in the tree
     */
    @SuppressWarnings("unchecked")
	private String dataAndHeight(AVLNode n) {
        if(n == null)
            return ".";

        String out = "([" + n.data + "," + n.height + "] ";
        out += dataAndHeight((AVLNode) n.left);
        out += " ";
        out += dataAndHeight((AVLNode) n.right);
        out += ")";

        return out;
    }
}
