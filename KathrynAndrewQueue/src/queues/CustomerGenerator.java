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

public abstract class CustomerGenerator implements Runnable 
{
	private int myMaxTimeBetweenCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private Thread myThread;
    private boolean mySuspended;
    private int myTotalNumberOfCustomers;
    private int myNumberCustomer;
    private Customer myCustomer;
	
	public CustomerGenerator(int maxTimeBetweenCustomers, int totalNumberOfCustomers, ServiceQueueManager serviceQueueManager)
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myServiceQueueManager = serviceQueueManager;
        mySuspended = false;
        myThread = new Thread(this);
        
        myTotalNumberOfCustomers = totalNumberOfCustomers;
        myNumberCustomer = 0;  
	}
	
	public abstract int generateTimeBetweenCustomers();
	
	public Customer generateCustomer()
	{
		myCustomer = new Customer();
		return myCustomer;
	}
	
	/**
	 * this function calls upon doSomething
	 */
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
            myServiceQueueManager.determineShortestQueue().insertCustomer(generateCustomer());
            try
            {
            	System.out.println(myNumberCustomer);
                Thread.sleep(generateTimeBetweenCustomers());
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
