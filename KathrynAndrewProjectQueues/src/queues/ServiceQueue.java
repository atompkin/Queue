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

public class ServiceQueue extends Queue
{
	private int myNumberCustomersServed;
	private int myNumberCustomersInLine;
	private int myTotalWaitTime;
	private int myTotalServiceTime;
	private int myTotalIdleTime;
	
	public ServiceQueue()
	{
		myNumberCustomersServed = 0;
		myNumberCustomersInLine = 0;
		myTotalWaitTime = 0;
		myTotalServiceTime = 0;
		myTotalIdleTime = 0;
	}
	
	public void addToElapsedTime(int elapsed)
	{
		
	}
	
	public void addToIdleTime(int idle)
	{
		
	}
	
	public void addToWaitTime(int wait)
	{
		
	}
	
	public void addToServiceTime(int service)
	{
		
	}
	
	public void insertCustomer(Customer customer)
	{
		
	}
	
	public Customer serveCustomer()
	{
		return null;
	}
	
	public int averageWaitTime()
	{
		return 0;
	}
	
	public int averageServiceTime()
	{
		return 0;
	}
	
	public int averageIdleTime()
	{
		return 0;
	}

	public void setMyNumberCustomersServed(int numberCustomersServed) 
	{
		myNumberCustomersServed = numberCustomersServed;
	}
	
	public void setMyNumberCustomersInLine(int numberCustomersInLine) 
	{
		myNumberCustomersInLine = numberCustomersInLine;
	}

	public void setMyTotalWaitTime(int totalWaitTime) 
	{
		myTotalWaitTime = totalWaitTime;
	}

	public void setMyTotalServiceTime(int totalServiceTime) 
	{
		myTotalServiceTime = totalServiceTime;
	}
	
	public void setMyTotalIdleTime(int totalIdleTime) 
	{
		myTotalIdleTime = totalIdleTime;
	}
	
	
	public int getMyNumberCustomersServed() 
	{
		return myNumberCustomersServed;
	}

	public int getMyNumberCustomersInLine() 
	{
		return myNumberCustomersInLine;
	}

	public int getMyTotalWaitTime() 
	{
		return myTotalWaitTime;
	}

	public int getMyTotalServiceTime() 
	{
		return myTotalServiceTime;
	}
	
	public int getMyTotalIdleTime() 
	{
		return myTotalIdleTime;
	}
	
}
