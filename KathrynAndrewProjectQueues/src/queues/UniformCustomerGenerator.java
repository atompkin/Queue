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

import java.util.Random;

public class UniformCustomerGenerator extends CustomerGenerator
{
	private Random myRandom;
	private int myMaxTimeBetweenCustomers;
	
	public UniformCustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager) 
	{
		super(maxTimeBetweenCustomers, serviceQueueManager);
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myRandom = new Random();
	}

	public int generateTimeBetweenCustomers()
	{
		return myRandom.nextInt(getMyMaxTimeBetweenCustomers());
	}
	
	public void setMyMaxTimeBetweenCustomers(int maxTimeBetweenCustomers) 
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
	}
	
	public int getMyMaxTimeBetweenCustomers() 
	{
		return myMaxTimeBetweenCustomers;
	}
	
}
