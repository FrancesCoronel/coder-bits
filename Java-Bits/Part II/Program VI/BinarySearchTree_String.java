public class BinarySearchTree_String {
 
    private Node_String root;
 
    public void insert(String key) {

        //root = insert(root, item);
        insert(new Node_String(key, null, null));
            
    }
 
    public void insert(Node_String item) {
 
        Node_String y = null;
        Node_String x = root;

        while(x != null) {
            y = x;
            
            if(item.compareTo(x.getKey()) < 0) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }

        item.setParent(y);

        if (y == null) {
            root = item;
        } else if (item.compareTo(y.getKey()) < 0) {
            y.setLeftChild(item);
        } else {
            y.setRightChild(item);
        }


        /*
        if (x == y) {
            x = new Node_String(z);
            return;
        }

        Node_String runner;
        runner = x;
 
        while (true) {

            if (z.compareTo(runner.getKey()) < 0) {
                if (runner.getLeftChild() == 0) {
                    runner.getLeftChild() = new Node_String(z);
                    return;
                }
                else 
                    runner = runner.getLeftChild;
            }
            else {
                if (runner.getRightChild == null) {
                    runner.getRightChild() = new Node_String(z);
                    return;
                }
                else
                    runner = runner.getRightChild();
            }
        }
        */
    }

    /*public void toString() {
        this.inorderTraversal(root);
    }*/
 
    public void preorderTraversal() {
        preorderTraversal(root);
    }
 
    public void preorderTraversal(Node_String node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preorderTraversal(node.getLeftChild());
            preorderTraversal(node.getRightChild());          
        }
    }
 
    public void inorderTraversal() {
        inorderTraversal(root);
    }
 
    private void inorderTraversal(Node_String node) {
        if (node != null) {
            inorderTraversal(node.getLeftChild());
            System.out.print(node.getKey() + " ");
            inorderTraversal(node.getRightChild());
        }
    }
 
    public void postorderTraversal() {
        postorderTraversal(root);
    }
 
    private void postorderTraversal(Node_String node) {
        if (node != null) {
            postorderTraversal(node.getLeftChild());
            postorderTraversal(node.getRightChild());
            System.out.print(node.getKey() + " ");
        }  
    }
}