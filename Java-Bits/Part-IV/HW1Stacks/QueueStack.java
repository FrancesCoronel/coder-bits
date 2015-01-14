/*
 * The FIFOQueue class provides the operations enqueue, dequeue,
 * isEmpty and size and those are the ONLY operations that you can use.
 */

import java.util.EmptyStackException;

public class QueueStack implements DStack 
{
   // The queue object
   private FIFOQueue queue;

   // you can add more queue instances here and initialize in the constructor

   /*
    * Constructor. Initialize the instance field
    */
   public QueueStack() 
   {
      queue = new FIFOQueue();
      // initialize extra queue object if necessary
   }

   /*
    * Pushes the value onto the stack represented by this queue. In other
    * words, inserts the element at the front of this queue.
    * 
    * @param value
    *            the value that push into the stack
    */
   @Override
   public void push(double value) 
   {
      // TODO write your push operation here
   }

   /*
    * Pops the value from the stack represented by this queue. In other words,
    * removes and returns the first element of this queue.
    * 
    * @return the value that at the end of the stack
    */
   @Override
   public double pop() 
   {
      // TODO write your pop operation here
      return 0.0;
   }

   // ////////////////////////////////////////////////////////////////
   // Ignore all the methods below, those are only for testing
   // ////////////////////////////////////////////////////////////////

   /*
    * Check if the queue is empty
    * 
    * @return true if the queue is empty, false otherwise
    */
   @Override
   public boolean isEmpty() 
   {
      return queue.isEmpty();
   }

   /*
    * Peek the last element
    * 
    * @return the last element in the queue object
    */
   @Override
   public double peek() 
   {
      double popVal = pop();
      push(popVal);
      return popVal;
   }
}
