package queues;

public class Main 
{
	/**
	 * Properties
	 */
    private SimulationController myController;
    
    /**
     * Main class
     * @param args : arguments
     */
    public static void main(String[] args)
    {
        new Main();
    }
    
    /**
     * Setting up the controller
     */
    public Main()
    {
        setController(new SimulationController());
    }

    /**
     * Sets up the controller
     * @param controller : the controller being used
     */
	public void setController(SimulationController controller) 
	{
		myController = controller;
	}

	/**
	 * Getting the controller
	 * @return : the controller
	 */
	public SimulationController getController() 
	{
		return myController;
	}
}
