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

public class ServiceQueueManager 
{
	public final int MAX_NUMBER_OF_QUEUES = 5;
	private int myNumberOfServiceQueues;
	private ServiceQueue[] myServiceQueues;
	private int myTotalWaitTime;
	private int myTotalServiceTime;
	private int myTotalIdleTime;
	private CustomerGenerator myCustomerGenerator;
	private Cashier[] myCashiers;
	
	public ServiceQueueManager(Integer numberOfQueues, Integer maxTimeBetweenCustomers, Integer maxServiceTime, Integer numberOfCustomers)
	{
		myNumberOfServiceQueues = numberOfQueues;
		myServiceQueues = new ServiceQueue[myNumberOfServiceQueues];
		myCashiers = new UniformCashier[myNumberOfServiceQueues];
		for(int i = 0; i < myNumberOfServiceQueues; i++)
		{
			myServiceQueues[i] = new ServiceQueue();
			myCashiers[i] = new UniformCashier(maxServiceTime, myServiceQueues[i]);
			myCashiers[i].start();
		}
		myTotalWaitTime = 0;
		myTotalServiceTime = 0;
		myTotalIdleTime = 0;
		myCustomerGenerator = new UniformCustomerGenerator(maxTimeBetweenCustomers, numberOfCustomers, this);
		
		myCustomerGenerator.start();
		
	}
	
	public int totalServedSoFar()
	{
		int totalserved = 0;
		for(int i = 0; i < myNumberOfServiceQueues; i++)
		{
			 totalserved = totalserved + myServiceQueues[i].getMyNumberCustomersServed();
		}
		return totalserved;
	}
	
	public int totalWaitTime()
	{
		return 0;
	}
	
	public int totalServiceTime()
	{
		return 0;
	}
	
	public int totalIdleTime()
	{
		return 0;
	}
	
	public ServiceQueue determineShortestQueue()
	{
		int shortestQueue = 0;
		if(myNumberOfServiceQueues == 1)
		{
			return myServiceQueues[shortestQueue];
		}
		
		int compare = myServiceQueues[shortestQueue].getMyNumberCustomersInLine();
		for(int i = 1; i < myNumberOfServiceQueues; i++)
		{
			int compare2 = myServiceQueues[i].getMyNumberCustomersInLine();
			if(compare > compare2)
			{
				shortestQueue = i;
				compare = compare2;
			}
		}
		return myServiceQueues[shortestQueue];
	}
	
	public int averageWaitTime()
	{
		return totalWaitTime()/totalServedSoFar();
	}
	
	public int averageServiceTime()
	{
		return totalServiceTime()/totalServedSoFar();
	}
	
	public int averageIdleTime()
	{
		return totalIdleTime()/totalServedSoFar();
	}
	
	public ServiceQueue[] getServiceQueue()
	{
		return myServiceQueues;
	}
	
	public int getNumberOfServiceQueues()
	{
		return myNumberOfServiceQueues;
	}
	
	public CustomerGenerator getCustomerGenerator()
	{
		return myCustomerGenerator;
	}
	
	public Cashier[] getCashier()
	{
		return myCashiers;
	}
}
