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
	private float myAverageWaitTime;
	private float myAverageServiceTime;
	private int myAverageIdleTime;
	private int myPresentTime;
	private int myStartTime;
	
	public ServiceQueueManager()
	{
		myNumberOfServiceQueues = 0;
		myServiceQueues = new ServiceQueue[0];
		myTotalWaitTime = 0;
		myTotalServiceTime = 0;
		myTotalIdleTime = 0;
		myAverageWaitTime = 0;
		myAverageServiceTime = 0;
		myAverageIdleTime = 0;
		myPresentTime = 0;
		myStartTime = 0;
	}
	
	public int totalServedSoFar()
	{
		return 0;
	}
	
	public int totalWaitTime()
	{
		return 0;
	}
	
	public int totalServiceTime()
	{
		return 0;
	}
	
	public ServiceQueue determineShortestQueue()
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
}
