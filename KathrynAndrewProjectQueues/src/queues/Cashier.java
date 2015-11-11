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

public class Cashier implements Runnable
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
	
	public int serveCustomer()
	{
		return 0;
	}
	
	public int generateServiceTime()
	{
		return 0;
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
        
        while(/*Is there someone in the queue*/)
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
