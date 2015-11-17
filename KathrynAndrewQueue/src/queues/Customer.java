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

public class Customer 
{
	private int myServiceTime;
	private int myEntryTime;
	private int myWaitTime;
	
	public Customer()
	{
		// all customers are named swaggintonyolo the third
		myServiceTime = 0;
		myEntryTime = 0;
		myWaitTime = 0;
	}

	public void setMyServiceTime(int serviceTime) 
	{
		myServiceTime = serviceTime;
	}
	
	public void setMyEntryTime(int entryTime) 
	{
		myEntryTime = entryTime;
	}

	public void setMyWaitTime(int waitTime) 
	{
		myWaitTime = waitTime;
	}
	
	public int getMyServiceTime() 
	{
		return myServiceTime;
	}

	public int getMyEntryTime() 
	{
		return myEntryTime;
	}

	public int getMyWaitTime() 
	{
		return myWaitTime;
	}

	
}
