/**
 * Kathryn Sarullo and Andrew Tompkins
 * Project 3: Queues
 * 11/20/15
 * CSCI142
 * 
 * Description: Queue based of a single link list. the Que adds to the end
 * of the linked list and takes from the beginning.
 * 
 */
package queues;

import java.util.LinkedList;

public class Queue<T>
{
	private LinkedList<T> myData;
	
	/**
	 * Creates the link list that is used as the structure for the queue
	 */
	public Queue()
	{
		myData = new LinkedList<T>();
	}
	/**
	 * @return if the linked list is empty
	 */
	public boolean empty()
	{
		return myData.isEmpty();
	}
	
	/**
	 * adds to the end of the linked list
	 * @param o
	 */
	public void enqueue(T o)
	{
		myData.addLast(o);
	}
	/**
	 * @return looks at the next thing in the list
	 */
	public T peek()
	{
		return myData.peekFirst();
	}
	/**
	 * @return returns the last thing on the link list
	 */
	public T dequeue()
	{
		if (myData.isEmpty())
		{
			return null;
		}
		return myData.removeFirst();
	}
	
	public int size()
	{
		return myData.size();
	}
	
}
