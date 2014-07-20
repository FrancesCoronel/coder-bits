public class Node_String {
 
    private String key;
    private Node_String parent;
    private Node_String leftChild;
    private Node_String rightChild;

    public Node_String(String str) {
        key = str;
    }

    public Node_String(String str, Node_String leftChild, Node_String rightChild) {
        this.setKey(key);
        this.setLeftChild(leftChild);
        this.setRightChild(rightChild);
    }
 
    public void setKey(String key) {
        this.key = key;
    }
 
    public String getKey() {
        return key;
    }
 
    public void setParent(Node_String parent) {
        this.parent = parent;
    }
 
    public Node_String getParent() {
        return parent;
    }
 
    public void setLeftChild(Node_String leftChild) {
        this.leftChild = leftChild;
    }
 
    public Node_String getLeftChild() {
        return leftChild;
    }
 
    public void setRightChild(Node_String rightChild) {
        this.rightChild = rightChild;
    }
 
    public Node_String getRightChild() {
        return rightChild;
    }
}