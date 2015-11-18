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

public class UniformCashier extends Cashier
{	
	private Random myRandom;
	private int myMaxServiceTime;
	
	public UniformCashier(int maxServiceTime, ServiceQueue serviceQueue) 
	{
		super(maxServiceTime, serviceQueue);
		myMaxServiceTime = maxServiceTime;
		myRandom = new Random();
		this.start();
	}
	
	public int generateServiceTime()
	{
		return myRandom.nextInt(getMyMaxServiceTime());
	}

	public void setMyMaxServiceTime(int maxServiceTime) 
	{
		myMaxServiceTime = maxServiceTime;
	}
	
	public int getMyMaxServiceTime() 
	{
		return myMaxServiceTime;
	}

}
