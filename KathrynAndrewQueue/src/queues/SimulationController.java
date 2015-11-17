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
	private SimulationView myView;
	private ServiceQueueManager myModel;
	
	/**
	 * Constructor
	 */
	public SimulationController()
	{
		myView = new SimulationView(this);
		myModel = new ServiceQueueManager(2);
		System.out.println("Stuff: " + myModel.determineShortestQueue());
	}
	
	public void suspend()
	{
		
	}
}
