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
	private JLabel myCashierStats;
	private JButton mySuspend;
	private ButtonListener mySuspendListener;
	
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
		
		myPanel = new JPanel(new GridLayout(3,1));
		myPanel.setSize(285,560);
		myPanel.setLocation(600,0);
		myPanel.setBackground(Color.black);
		
		myPanel3 = new JPanel();
		myPanel3.setBackground(Color.white);
		myPanel3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		
		myPanel5 = new JPanel();
		myPanel5.setBackground(Color.white);
		myPanel5.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		
		myPanel4 = new JPanel();
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
		
		mySuspend = new JButton("Pause");
		mySuspend.addMouseListener(mySuspendListener);
		
		myOverallStats = new JLabel("Overall Stats");
		myOverallStats.setFont(new Font("TimesRoman", Font.BOLD, 20));
		myCustomersServed = new JLabel("Total Customers Served: ");
		myCustomersServed.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		myServiceTime = new JLabel("Total Service Time: ");
		myServiceTime.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		myWaitTime = new JLabel("Total Wait Time: ");
		myWaitTime.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		myIdleTime = new JLabel("Total Idle Time: ");
		myIdleTime.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		myCashierStats = new JLabel("Individual Cashier Stats");
		myCashierStats.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		myPanel.add(myPanel3);
		myPanel.add(myPanel5);
		myPanel.add(myPanel4);
		myPanel3.add(myOverallStats);
		myPanel3.add(myCustomersServed);
		myPanel3.add(myServiceTime);
		myPanel3.add(myWaitTime);
		myPanel3.add(myIdleTime);
		myPanel5.add(myCashierStats);
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
        Method suspend;
        Class<?>[] classArgs;
               
        controllerClass = controller.getClass();
        classArgs = null;
        suspend = null;
        
        try
        {
        	suspend = controllerClass.getMethod("suspend", (Class<?>[])null);
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
        
        mySuspendListener = new ButtonListener(controller, suspend);
	}
}
