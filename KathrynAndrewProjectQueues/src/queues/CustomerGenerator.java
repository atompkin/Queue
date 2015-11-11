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

public class CustomerGenerator implements Runnable 
{
	private int myMaxTimeBetweenCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private Thread myThread;
    private boolean mySuspended;
    private int myTotalNumberOfCustomers;
    private int myNumberCustomer;
	
	public CustomerGenerator(int maxTimeBetweenCustomers, ServiceQueueManager serviceQueueManager)
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myServiceQueueManager = serviceQueueManager;
        mySuspended = false;
        myThread = new Thread(this);
        
        myTotalNumberOfCustomers = 0;
        myNumberCustomer = 0;
	}
	
	public int generateTimeBetweenCustomers()
	{
		return 0;
	}
	
	public Customer generateCustomer()
	{
		return null;
	}
	
	public void run() 
	{
		try
    	{
    		synchronized(this)
    		{
    			this.doSomething();
    		}
    	}
    	catch (InterruptedException e)
    	{
    		System.out.println("Thread suspended.");
    	}
	}
	
	private void doSomething() throws InterruptedException
    {
        String message;
        
        while(getMyNumberCustomer() < getMyTotalNumberOfCustomers())
        {
            this.waitWhileSuspended();
        	
            myNumberCustomer++;
            
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException e)
            {
                message = e.getMessage();
                System.err.println(message);
            }
        }
    }

	private void waitWhileSuspended() throws InterruptedException
    {
    	while (mySuspended)
    	{
    		this.wait();
    	}
    }
	
	public void suspend()
	{
		mySuspended = true;
	}
	
	public void start()
	{
		try
        {
            myThread.start();
        }
        catch(IllegalThreadStateException e)
        {
            System.out.println("Thread already started");
        }
	}
	
	public synchronized void resume()
    {
    	mySuspended = false;
    	notify();
    }
	
	public void setMyMaxTimeBetweenCustomers(int maxTimeBetweenCustomers) 
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
	}
	
	public int getMyMaxTimeBetweenCustomers() 
	{
		return myMaxTimeBetweenCustomers;
	}
	
	public int getMyTotalNumberOfCustomers() 
	{
		return myTotalNumberOfCustomers;
	}

	public int getMyNumberCustomer() 
	{
		return myNumberCustomer;
	}
	
}
