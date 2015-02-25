/**
 * priority queue implementation through linked list
 * duplicates not allowed
 * order of return depends on priority
 * @see  MyPQ.java
 * @author  FVCproductions
 * @since  2-19-15
 * @version  1.0
 */

public class MyPQ implements PriorityQueue {

    private ListNode front; //front element in  priority queue
    private int size; //amount of elements in  priority queue

    //support class that creates  next element to be inserted into  priority queue
    class ListNode {
        public ListNode next; //next element in  priority queue
        public double data; //value to be kept track of

        /**
         * constructs list node with a given value and next node
         * @param  data [given value]
         * @param  next [next node]
         * @return      [N/A]
         */
        public ListNode(double data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        //constructs list node with only a given value
        public ListNode(double data) {
            this(data, null);
        }

        //constructor list node without parameters
        public ListNode() {
            this(0.0, null);
        }
    }

    //constructs priority queue ADT
    public MyPQ() {
        this.front = null;
        this.size = 0;
    }

    //returns true if no elements present
    public boolean isEmpty() {
        return (front == null);
    }

    //returns # of elements
    public int size() {
        return this.size;
    }

    //returns smallest #
    public double findMin() {
        if (this.isEmpty()) {
            throw new EmptyPQException();
        }
        return this.front.data;
    }

    /**
     * inserts new element into priority queue
     * @param  x [value to be inserted]
     */
    public void insert(double x) {
        if (front == null) {
            front = new ListNode(x);
        } else if (x < front.data) {
            ListNode temp = front;
            front = new ListNode(x, temp);
        } else {
            ListNode current = front;
            while (current.next != null && current.next.data < x) {
                current = current.next;
            }
            ListNode temp = current.next;
            current.next = new ListNode(x, temp);
        }
        this.size++;
    }

    //removes and returns minimum element
    public double deleteMin() {
        if (this.isEmpty()) {
            throw new EmptyPQException();
        }
        double min = front.data;
        front = front.next;
        this.size--;
        return min;
    }

    //resets priority queue to empty
    public void makeEmpty() {
        this.front = null;
        this.size = 0;
    }

}