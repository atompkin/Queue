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
 
 public class SimulationController implements Runnable
 {
 	/**
 	 * Properties
 	 */
 	private SimulationView myView;
 	private ServiceQueueManager myModel;
 	private boolean mySuspended;
 	private Thread myThread;
 	
 	/**
 	 * Constructor
 	 */
 	public SimulationController()
 	{
 		mySuspended = false;
 		myThread = new Thread(this);
 		myView = new SimulationView(this);
 		myModel = null;
 	}
 	
	public void cashierStats(Integer i)
	{
		if(myModel.getNumberOfServiceQueues() > i)
		{
			myView.setCashier(i, myModel.getServiceQueue()[i].getMyNumberCustomersServed(), myModel.getServiceQueue()[i].getMyTotalServiceTime(), myModel.getServiceQueue()[i].getMyTotalIdleTime(), myModel.getServiceQueue()[i].getMyTotalWaitTime());
			myView.setWaitTime(myModel.totalWaitTime());
 			myView.setIdleTime(myModel.totalIdleTime());
 			myView.setServiceTime(myModel.totalServiceTime());
		}	
	}
 	
 	public void startAndPause()
 	{
 		if(myModel == null)
 		{
 			myModel = new ServiceQueueManager(3, 20, 200, 5);
 			this.start();
 		}
 		else if(isSuspended())
 		{
 			resume();
 		}
 		else
 		{
 			suspend();
 		}
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
        
        while(true)
        {
            this.waitWhileSuspended();
        	
            //inserting pictures 
            
            try
            {
                Thread.sleep(500);
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
	
	public boolean isSuspended()
	{
		return mySuspended;
	}
 	
 }