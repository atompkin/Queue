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
	private int myServiceTime;
	
	public UniformCashier(int maxServiceTime, ServiceQueue serviceQueue) 
	{
		super(maxServiceTime, serviceQueue);
		myMaxServiceTime = maxServiceTime;
		myRandom = new Random();
	}
	
	public int generateServiceTime()
	{
		myServiceTime = myRandom.nextInt(getMyMaxServiceTime());
		this.setTotalServiceTime(myServiceTime);
		return myServiceTime;
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
