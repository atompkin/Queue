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
 
 public class SimulationController 
 {
 	/**
 	 * Properties
 	 */
 	private boolean isRunning = false;
 	private SimulationView myView;
 	private ServiceQueueManager myModel;
 	
 	/**
 	 * Constructor
 	 */
 	public SimulationController()
 	{
 		myView = new SimulationView(this);
 		myModel = new ServiceQueueManager(2, 20, 200, 500);
 	}
 	
	public void cashierStats(Integer i)
	{
		System.out.println(i);
	}
	
 	public int QueSize(int i)
 	{
 		return myModel.getServiceQueue()[i].getMyNumberCustomersInLine();
 	}
 	
 	public int QueServed(int i)
 	{
 		return myModel.getServiceQueue()[i].getMyNumberCustomersServed();
 	}
 	
 	
 	public void suspend()
 	{
 		if(isRunning)
 		{
 			try 
 			{
 				myModel.wait();
 			} 
 			catch (InterruptedException e) 
 			{
 				System.out.println("Pause failed");
 			}
 		}
 		else
 		{
 			myModel.notify();
 		}
 	}
 	
 	public int getTotalWaitTime()
 	{
 		return myModel.totalWaitTime();
 	}
 	
 	public int getTotalServiceTime()
 	{
 		return myModel.totalServiceTime();
 	}
 	
 	public int getTotalIdleTime()
 	{
 		return myModel.totalIdleTime();
 	}
 	
 	public int getTotalServedSoFar()
 	{
 		return myModel.totalServedSoFar();
 	}
 	
 	public int getAverageServiceTime()
 	{
 		return myModel.averageServiceTime();
 	}
 	
 	public int getAverageIdelTime()
 	{
 		return myModel.averageIdleTime();
 	}
 	
 	public int getAverageWaitTime()
 	{
 		return myModel.averageWaitTime();
 	}
 	
 }