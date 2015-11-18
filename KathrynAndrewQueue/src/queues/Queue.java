/**
 * Kathryn Sarullo and Andrew Tompkins
 * Project 3: Queues
 * 11/20/15
 * CSCI142
 * 
 * Description: 
 * 
 */
package queues;

import java.util.LinkedList;

public class Queue<T>
{
	/**
	 * Properties
	 */
	private LinkedList<T> myData;
	
	/**
	 * Constructor
	 */
	public Queue()
	{
		myData = new LinkedList<T>();
	}

	/**
	 * Checking to see if the queue is empty
	 * @return
	 */
	public boolean empty()
	{
		return myData.isEmpty();
	}
	
	/**
	 * Inserting data into the queue
	 * @param o : the data
	 */
	public void enqueue(T o)
	{
		myData.addLast(o);
	}
	
	/**
	 * Removing data from the queue
	 * @return : the data that was removed
	 */
	public T dequeue()
	{
		if(myData.isEmpty())
		{
			return null;
		}
		return myData.removeFirst();
	}
	
	/**
	 * Seeing what is in the front of the queue
	 * @return : the front of the queue
	 */
	public T peek()
	{
		return myData.peekFirst();
	}
}
