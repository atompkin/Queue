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
 
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.GridLayout;
 import java.lang.reflect.Method;
 import javax.swing.*;
 
 public class SimulationView extends JFrame
 {
 	private JPanel myPanel;
 	private JPanel myPanel2;
 	private JPanel myPanel3;
 	private JPanel myPanel4;
 	private JPanel myPanel5;
 	private JLabel[][] myLines;
 	private JLabel myCustomersServed;
 	private JLabel myOverallStats;
 	private JLabel myServiceTime;
 	private JLabel myIdleTime;
 	private JLabel myWaitTime;
 	private JLabel myAverageServiceTime;
 	private JLabel myAverageIdleTime;
 	private JLabel myAverageWaitTime;
 	private JLabel myCashierStats;
	private JLabel myCashierWait;
	private JLabel myCashierServed;
	private JLabel myCashierServeTime;
	private JLabel myCashierIdle;
 	private JButton mySuspend;
 	private ButtonListener mySuspendListener;
	private ButtonListener[][] myLinesListener;
	private ImageIcon myPicture;
	
	private JLabel myNumberOfCustomersLabel;
	private JLabel myServiceTimeLabel;
	private JLabel myTimeBetweenCustomersLabel;
	private JLabel myNumberOfQueuesLabel;
	private JComboBox<Integer> myNumberOfCustomersEntered;
	private JComboBox<Integer> myServiceTimeEntered;
	private JComboBox<Integer> myTimeBetweenCustomersEntered;
	private JComboBox<Integer> myNumberOfQueuesEntered;
 	
 	/**
 	 * Constructor
 	 * @param controller : the controller being used
 	 */
 	public SimulationView(SimulationController controller)
 	{
 		this.setSize(900, 600);
 		this.setLayout(null);
 		this.setTitle("Queue");
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		this.associateListeners(controller);
 		getContentPane().setBackground(Color.white);
 		
 		myPicture = new ImageIcon("src/images/Queen1.jpg");
 		
 		myPanel = new JPanel(new GridLayout(3,0));
 		myPanel.setSize(285,560);
 		myPanel.setLocation(600,0);
 		myPanel.setBackground(Color.black);
 		
 		myPanel3 = new JPanel(new GridLayout(0,1));
 		myPanel3.setBackground(Color.white);
 		myPanel3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
 		
 		myPanel5 = new JPanel(new GridLayout(0,1));
 		myPanel5.setBackground(Color.white);
 		myPanel5.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
 		
 		myPanel4 = new JPanel(new GridLayout(0,2));
 		myPanel4.setBackground(Color.white);
 		myPanel4.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
 		
 		myPanel2 = new JPanel(new GridLayout(10,5));
 		myPanel2.setSize(600,560);
 		myPanel2.setLocation(0,0);
 		myPanel2.setBackground(Color.cyan);
 		myPanel2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
 		
 		myLines = new JLabel[10][5];
 		for (int i = 0; i < 10; i++) 
 		{
 			for (int j = 0; j < 5; j++) 
 			{
 				myLines[i][j] = new JLabel();
 				myLines[i][j].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				myLines[i][j].addMouseListener(myLinesListener[i][j]);
 				myPanel2.add(myLines[i][j]);
 			}
 		}
 	
 		for(int i = 0; i < 5; i++)
 		{
 			myLines[9][i].setText("Served: ");
 		}
 		
 		for(int i = 0; i < 5; i++)
 		{
 			myLines[0][i].setText("Overflow: ");
 		}
 		
 		mySuspend = new JButton("Start");
 		mySuspend.addMouseListener(mySuspendListener);
 		
 		myOverallStats = new JLabel("Overall Stats");
 		myOverallStats.setFont(new Font("TimesRoman", Font.BOLD, 20));
 		myCustomersServed = new JLabel("Total Customers Served: ");
 		myCustomersServed.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		myServiceTime = new JLabel("Total Service Time: ");
 		myServiceTime.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		myWaitTime = new JLabel("Total Wait Time: ");
 		myWaitTime.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		myIdleTime = new JLabel("Total Idle Time: ");
 		myIdleTime.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		myAverageServiceTime = new JLabel("Average Service Time: ");
 		myAverageServiceTime.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		myAverageWaitTime = new JLabel("Average Wait Time: ");
 		myAverageWaitTime.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		myAverageIdleTime = new JLabel("Average Idle Time: ");
 		myAverageIdleTime.setFont(new Font("TimesRoman", Font.PLAIN, 15));
 		
 		myCashierStats = new JLabel("Individual Cashier Stats");
 		myCashierStats.setFont(new Font("TimesRoman", Font.BOLD, 20));
		myCashierWait = new JLabel("");
		myCashierWait.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		myCashierServed = new JLabel("");
		myCashierServed.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		myCashierServeTime = new JLabel("");
		myCashierServeTime.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		myCashierIdle = new JLabel("");
		myCashierIdle.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		myNumberOfCustomersLabel = new JLabel("Number Of Customers:");
		myNumberOfCustomersLabel.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		myServiceTimeLabel = new JLabel("Service Time:");
		myServiceTimeLabel.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		myTimeBetweenCustomersLabel = new JLabel("Between Customers:");
		myTimeBetweenCustomersLabel.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		myNumberOfQueuesLabel = new JLabel("Number Of Queues:");
		myNumberOfQueuesLabel.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		
		myNumberOfCustomersEntered = new JComboBox<Integer>();
		for(int i = 1; i < 1000; i++)
		{
			myNumberOfCustomersEntered.addItem(i);
		}
		myServiceTimeEntered = new JComboBox<Integer>();
		for(int i = 1; i < 1000; i++)
		{
			myServiceTimeEntered.addItem(i);
		}
		myTimeBetweenCustomersEntered = new JComboBox<Integer>();
		for(int i = 1; i < 1000; i++)
		{
			myTimeBetweenCustomersEntered.addItem(i);
		}
		myNumberOfQueuesEntered  = new JComboBox<Integer>();
		for(int i = 1; i < 6; i++)
		{
			myNumberOfQueuesEntered.addItem(i);
		}
		
		myPanel.add(myPanel3);
		myPanel.add(myPanel5);
		myPanel.add(myPanel4);
		myPanel3.add(myOverallStats);
		myPanel3.add(myCustomersServed);
		myPanel3.add(myServiceTime);
		myPanel3.add(myWaitTime);
		myPanel3.add(myIdleTime);
		myPanel3.add(myAverageServiceTime);
		myPanel3.add(myAverageWaitTime);
		myPanel3.add(myAverageIdleTime);
		myPanel5.add(myCashierStats);
		myPanel5.add(myCashierServed);
		myPanel5.add(myCashierServeTime);
		myPanel5.add(myCashierWait);
		myPanel5.add(myCashierIdle);
		myPanel4.add(myNumberOfCustomersLabel);
		myPanel4.add(myNumberOfCustomersEntered);
		myPanel4.add(myServiceTimeLabel);
		myPanel4.add(myServiceTimeEntered);
		myPanel4.add(myTimeBetweenCustomersLabel);
		myPanel4.add(myTimeBetweenCustomersEntered);
		myPanel4.add(myNumberOfQueuesLabel);
		myPanel4.add(myNumberOfQueuesEntered);
		myPanel4.add(mySuspend);
		getContentPane().add(myPanel);
		getContentPane().add(myPanel2);
		
		this.setVisible(true);
 	}

	/**
	 * The reflection part of the project where all the button listeners are
	 * done and where the methods are called for each button.
	 * @param controller
	 */
	private void associateListeners(SimulationController controller) 
	{
		Class<? extends SimulationController> controllerClass;
        Method cashierStats, suspend;
        Class<?>[] classArgs;
               
        controllerClass = controller.getClass();
        classArgs = new Class[1];
        suspend = null;
        cashierStats = null;
        
        try
        {
           classArgs[0] = Class.forName("java.lang.Integer");
        }
        catch(ClassNotFoundException e)
        {
           String error;
           error = e.toString();
           System.out.println(error);
        }
         
        try
        {
        	suspend = controllerClass.getMethod("startAndPause", (Class<?>[])null);
        	cashierStats = controllerClass.getMethod("cashierStats", classArgs);
        }
        catch(NoSuchMethodException exception)
        {
           String error;
           error = exception.toString();
           System.out.println(error);
        }
        catch(SecurityException exception)
        {
           String error;
           error = exception.toString();
           System.out.println(error);
        }
        
        Integer[] args;
        myLinesListener = new ButtonListener[10][5];

        for (int i = 0; i < 10; i++)
        {
        	for(int j = 0; j < 5; j++)
        	{
        		args = new Integer[1];
                args[0] = new Integer(j);
                myLinesListener[i][j] = new ButtonListener(controller, cashierStats, args);
        	}
        }
        
        mySuspendListener = new ButtonListener(controller, suspend);
 	}
	
	public void setOverallStats(int served, int serviceTime, int idleTime, int waitTime)
	{
 		myCustomersServed.setText("Total Customers Served: " + served);
 		myServiceTime.setText("Total Service Time: " + serviceTime);
 		myWaitTime.setText("Total Wait Time: " + waitTime);
 		myIdleTime.setText("Total Idle Time: " + idleTime);
	}
	
	public void setCashier(int cashier, int served, int serviceTime, int idleTime, int waitTime)
	{
		myCashierStats.setText("Individual Cashier "+ (cashier + 1) + " Stats");
		myCashierServed.setText("Total Served: "+ served);
		myCashierServeTime.setText("Average Service Time:  "+ serviceTime);
		myCashierWait.setText("Average Wait Time: " + waitTime);
		myCashierIdle.setText("Average Idle Time: "+ idleTime);
	}
	
	public void setServed(int l, int served)
	{
		myLines[9][l].setText("Served: " + served);
		myLines[9][l].repaint();
	}
	
	public void setButton(String text)
	{
		mySuspend.setText(text);
	}
	
	public void setLines(int l, int size)
	{
		if(size < 9)
		{
			myLines[0][l].setText("Overflow: 0");
			myLines[0][l].repaint();
		}
		else
		{
			myLines[0][l].setText("Overflow: " + (size - 8));
			myLines[0][l].repaint();
		}
		switch(size)
		{
			case 0: myLines[7][l].setIcon(null);
					myLines[6][l].setIcon(null);
					myLines[5][l].setIcon(null);
					myLines[4][l].setIcon(null);
					myLines[3][l].setIcon(null);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;
			case 1: myLines[7][l].setIcon(null);
					myLines[6][l].setIcon(null);
					myLines[5][l].setIcon(null);
					myLines[4][l].setIcon(null);
					myLines[3][l].setIcon(null);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;
			case 2: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(null);
					myLines[5][l].setIcon(null);
					myLines[4][l].setIcon(null);
					myLines[3][l].setIcon(null);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;
			case 3: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(null);
					myLines[4][l].setIcon(null);
					myLines[3][l].setIcon(null);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;
			case 4: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(myPicture);
					myLines[4][l].setIcon(null);
					myLines[3][l].setIcon(null);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;
			case 5: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(myPicture);
					myLines[4][l].setIcon(myPicture);
					myLines[3][l].setIcon(null);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;
			case 6: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(myPicture);
					myLines[4][l].setIcon(myPicture);
					myLines[3][l].setIcon(myPicture);
					myLines[2][l].setIcon(null);
					myLines[1][l].setIcon(null);
					break;	
			case 7: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(myPicture);
					myLines[4][l].setIcon(myPicture);
					myLines[3][l].setIcon(myPicture);
					myLines[2][l].setIcon(myPicture);
					myLines[1][l].setIcon(null);
					break;
			case 8: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(myPicture);
					myLines[4][l].setIcon(myPicture);
					myLines[3][l].setIcon(myPicture);
					myLines[2][l].setIcon(myPicture);
					myLines[1][l].setIcon(myPicture);
					break;	
			default: myLines[7][l].setIcon(myPicture);
					myLines[6][l].setIcon(myPicture);
					myLines[5][l].setIcon(myPicture);
					myLines[4][l].setIcon(myPicture);
					myLines[3][l].setIcon(myPicture);
					myLines[2][l].setIcon(myPicture);
					myLines[1][l].setIcon(myPicture);
					break;
		}
	}
	
	public Integer getMyNumberOfCustomersEntered() 
	{
		return myNumberOfCustomersEntered.getSelectedIndex() + 1;
	}

	public Integer getMyServiceTimeEntered() 
	{
		return myServiceTimeEntered.getSelectedIndex() + 1;
	}

	public Integer getMyTimeBetweenCustomersEntered() 
	{
		return myTimeBetweenCustomersEntered.getSelectedIndex() + 1;
	}

	public Integer getMyNumberOfQueuesEntered() 
	{
		return myNumberOfQueuesEntered.getSelectedIndex() + 1;
	}
	
}