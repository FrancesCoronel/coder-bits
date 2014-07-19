public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] input = new int[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 };
 
        for (int i : input) {
            bst.insert(i);
        }
 
        System.out.println("Preorder Traversal:");
        bst.preorderTraversal();
 
        System.out.println( "\nInorder Traversal:");
        bst.inorderTraversal();
 
        System.out.println("\nPostorder Traversal:");
        bst.postorderTraversal();
    }
}