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
	private LinkedList<T> myData;
	
	public Queue()
	{
		myData = new LinkedList<T>();
	}

	public boolean empty()
	{
		return myData.isEmpty();
	}
	
	public void enqueue(T o)
	{
		myData.addLast(o);
	}
	
	public T dequeue()
	{
		if(myData.isEmpty())
		{
			return null;
		}
		return myData.removeFirst();
	}
	
	public T peek()
	{
		return myData.peekFirst();
	}
}
