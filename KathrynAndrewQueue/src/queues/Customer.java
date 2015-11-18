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
	/**
	 * Properties
	 */
	private int myServiceTime;
	private int myEntryTime;
	private int myWaitTime;
	
	/**
	 * Constructor, instantiates all the properties
	 */
	public Customer()
	{
		// all customers are named Swaggintonyolo III
		myServiceTime = 0;
		myEntryTime = 0;
		myWaitTime = 0;
	}
	
	/**
	 * Setting the service time
	 * @param serviceTime
	 */
	public void setMyServiceTime(int serviceTime) 
	{
		myServiceTime = serviceTime;
	}
	
	/**
	 * Setting the entry time
	 * @param entryTime
	 */
	public void setMyEntryTime(int entryTime) 
	{
		myEntryTime = entryTime;
	}

	/**
	 * Setting the wait time
	 * @param waitTime
	 */
	public void setMyWaitTime(int waitTime) 
	{
		myWaitTime = waitTime;
	}
	
	/**
	 * Gets the service time
	 * @return : service time
	 */
	public int getMyServiceTime() 
	{
		return myServiceTime;
	}

	/**
	 * Gets the entry time
	 * @return : entry time
	 */
	public int getMyEntryTime() 
	{
		return myEntryTime;
	}

	/**
	 * Gets the wait time
	 * @return : wait time
	 */
	public int getMyWaitTime() 
	{
		return myWaitTime;
	}

	
}
