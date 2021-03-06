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
		if(myModel != null)
		{
			if(myModel.getNumberOfServiceQueues() > i)
			{
				myView.setCashier(i, myModel.getServiceQueue()[i].getMyNumberCustomersServed(), 
					myModel.getServiceQueue()[i].getMyTotalServiceTime(), 
					myModel.getServiceQueue()[i].getMyTotalIdleTime(), 
					myModel.getServiceQueue()[i].getMyTotalWaitTime());
				myView.setOverallStats(myModel.totalServedSoFar(), myModel.totalServiceTime(),
					myModel.totalIdleTime(), myModel.totalWaitTime(), myModel.averageServiceTime(),
					myModel.averageIdleTime(), myModel.averageWaitTime());
			}
		}
	}
 	
 	public void startAndPause()
 	{
 		if(myModel == null)
 		{
 			myModel = new ServiceQueueManager(myView.getMyNumberOfQueuesEntered(),
 					(Integer)myView.getMyTimeBetweenCustomersEntered(), (Integer)myView.getMyServiceTimeEntered(),
 					(Integer)myView.getMyNumberOfCustomersEntered());
 			this.start();
 			myView.setButton("Pause");
 		}
 		else if(isSuspended())
 		{
 			myModel.getCustomerGenerator().resume();
 			for(int i = 0; i < myModel.getNumberOfServiceQueues(); i++)
 			{
 				myModel.getCashier()[i].resume();
 			}
 			resume();
 			myView.setButton("Pause");
 		}
 		else
 		{
 			myModel.getCustomerGenerator().suspend();
 			for(int i = 0; i < myModel.getNumberOfServiceQueues(); i++)
 			{
 				myModel.getCashier()[i].suspend();
 			}
 			suspend();
 			myView.setButton("Start");
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
    			this.doInsertPictures();
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
	private void doInsertPictures() throws InterruptedException
    {
        String message;
        
        while(true)
        {
            this.waitWhileSuspended();
        	
            if(myModel != null)
            {	
            	for(int i = 0; i < myModel.getNumberOfServiceQueues(); i++)
            	{
            		myView.setServed(i, myModel.getServiceQueue()[i].getMyNumberCustomersServed());
            	}
            	
            	for(int i = 0; i < myModel.getNumberOfServiceQueues(); i++)
            	{
            		myView.setLines(i, myModel.getServiceQueue()[i].getMyNumberCustomersInLine());
            	}
            }
            
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