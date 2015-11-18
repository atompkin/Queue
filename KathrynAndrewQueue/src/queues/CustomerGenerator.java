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
	/**
	 * Properties
	 */
	private int myMaxTimeBetweenCustomers;
	private ServiceQueueManager myServiceQueueManager;
	private Thread myThread;
    private boolean mySuspended;
    private int myTotalNumberOfCustomers;
    private int myNumberCustomer;
    private Customer myCustomer;
	
    /**
     * Constructor, instantiates all the properties
     * @param maxTimeBetweenCustomers : the user enters the max time allowed
     * between customers
     * @param totalNumberOfCustomers : the user enters the total number of
     * customers
     * @param serviceQueueManager : the service queue manager being used
     */
	public CustomerGenerator(int maxTimeBetweenCustomers, int totalNumberOfCustomers, ServiceQueueManager serviceQueueManager)
	{
		myMaxTimeBetweenCustomers = maxTimeBetweenCustomers;
		myServiceQueueManager = serviceQueueManager;
        mySuspended = false;
        myThread = new Thread(this);
        
        myTotalNumberOfCustomers = totalNumberOfCustomers;
        myNumberCustomer = 0;  
	}
	
	/**
	 * Generates time between customers
	 * @return : the time between customers
	 */
	public abstract int generateTimeBetweenCustomers();
	
	/**
	 * Creates a new customer
	 * @return : a customer
	 */
	public Customer generateCustomer()
	{
		myCustomer = new Customer();
		return myCustomer;
	}
	
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
	 * Inserting the customer into the queue
	 * @throws InterruptedException
	 */
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
                Thread.sleep(generateTimeBetweenCustomers());
            }
            catch(InterruptedException e)
            {
                message = e.getMessage();
                System.err.println(message);
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
	 * Getting the max time between the customers
	 * @return : max time between customers
	 */
	public int getMyMaxTimeBetweenCustomers() 
	{
		return myMaxTimeBetweenCustomers;
	}
	
	/**
	 * Getting the total number of customers
	 * @return : the total number of customers
	 */
	public int getMyTotalNumberOfCustomers() 
	{
		return myTotalNumberOfCustomers;
	}

	/**
	 * Getting the number customer you are currently inserting
	 * @return : the number customer
	 */
	public int getMyNumberCustomer() 
	{
		return myNumberCustomer;
	}
	
}
