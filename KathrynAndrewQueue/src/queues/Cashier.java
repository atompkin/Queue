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

public abstract class Cashier implements Runnable
{
	/**
	 * Properties
	 */
	private int myMaxTimeOfService;
	private ServiceQueue myServiceQueue;
	private Thread myThread;
    private boolean mySuspended;
	
    /**
     * Constructor, which instantiates all of the properties
     * @param maxServiceTime : The max service time for the cashiers
     * @param serviceQueue : The service queue the cashier is working with
     */
	public Cashier(int maxServiceTime, ServiceQueue serviceQueue)
	{
		myMaxTimeOfService = maxServiceTime;
		myServiceQueue = serviceQueue;
		mySuspended = false;
        myThread = new Thread(this);
	}
	
	/**
	 * Removes of one customer in the queue
	 * @return : The customer off the queue
	 */
	public Customer serveCustomer()
	{
		return myServiceQueue.serveCustomer();
	}
	
	/**
	 * Generates the service time for the cashiers 
	 * @return : The service time
	 */
	public abstract int generateServiceTime();
	
	/**
	 * What happens when the thread starts
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
	
	/**
	 * Serving the customer inside the thread
	 * @throws InterruptedException
	 */
	private void doSomething() throws InterruptedException
    {
        String message;
        
        while(true)
        {
        	this.waitWhileSuspended();
        	 
        	if(!myServiceQueue.empty())
        	{
        		try
                {
        			serveCustomer();
                    Thread.sleep(generateServiceTime());
                }
                catch(InterruptedException e)
                {
                    message = e.getMessage();
                    System.err.println(message);
                }
        	}
        	else
        	{
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
    }

	/**
	 * When the thread stops, it calls wait on the thread
	 * @throws InterruptedException
	 */
	private void waitWhileSuspended() throws InterruptedException
    {
    	while (mySuspended)
    	{
    		this.wait();
    	}
    }
	
	/**
	 * Used to suspend the thread
	 */
	public void suspend()
	{
		mySuspended = true;
	}
	
	/**
	 * Starting the thread
	 */
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
	
	/**
	 * Starting the thread back up after being paused
	 */
	public synchronized void resume()
    {
    	mySuspended = false;
    	notify();
    }
	
	/**
	 * Getting the max service time
	 * @return : the max service time
	 */
	public int getMyMaxTimeOfService() 
	{
		return myMaxTimeOfService;
	}

}
