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
	
	public ServiceQueueManager(int numberOfQueues)
	{
		myNumberOfServiceQueues = numberOfQueues;
		myServiceQueues = new ServiceQueue[myNumberOfServiceQueues];
		
		for(int i = 0; i < myNumberOfServiceQueues; i++)
		{
			myServiceQueues[i] = new ServiceQueue();
		}
			
		myTotalWaitTime = 0;
		myTotalServiceTime = 0;
		myTotalIdleTime = 0;
		myCustomerGenerator = new UniformCustomerGenerator(100, 50, this);
		myCustomerGenerator.start();
	}
	
	public int totalServedSoFar()
	{
		return 0;
	}
	
	public int totalWaitTime()
	{
		for(int i = 0; i <= myNumberOfServiceQueues; i++)
		{
			myTotalWaitTime = myTotalWaitTime + myServiceQueues[i].averageWaitTime();
		}
		return myTotalWaitTime;
	}
	
	public int totalServiceTime()
	{
		for(int i = 0; i <= myNumberOfServiceQueues; i++)
		{
			myTotalServiceTime = myTotalServiceTime + myServiceQueues[i].averageServiceTime();
		}
		return myTotalServiceTime;
	}
	
	public int totalIdleTime()
	{
		for(int i = 0; i <= myNumberOfServiceQueues; i++)
		{
			myTotalIdleTime = myTotalIdleTime + myServiceQueues[i].averageIdleTime();
		}
		return myTotalIdleTime;
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
			if(compare < compare2)
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
}
