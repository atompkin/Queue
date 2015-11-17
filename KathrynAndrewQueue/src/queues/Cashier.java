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
	private int myMaxTimeOfService;
	private ServiceQueue myServiceQueue;
	private Thread myThread;
    private boolean mySuspended;
	
    
	public Cashier(int maxServiceTime, ServiceQueue serviceQueue)
	{
		myMaxTimeOfService = maxServiceTime;
		myServiceQueue = serviceQueue;
		mySuspended = false;
        myThread = new Thread(this);
	}
	
	public Customer serveCustomer()
	{
		return myServiceQueue.serveCustomer();
	}
	
	public abstract int generateServiceTime();
	
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
        
        while(true)
        {
        	System.out.println(myServiceQueue.empty());
        	if(!myServiceQueue.empty())
        	{
        		try
                {
        			System.out.println("Generated");
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

	public void setMyMaxTimeOfService(int maxServiceTime) 
	{
		myMaxTimeOfService = maxServiceTime;
	}
	
	public int getMyMaxTimeOfService() 
	{
		return myMaxTimeOfService;
	}

}
