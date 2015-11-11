/**
 * Kathryn Sarullo and Andrew Tompkins
 * Project 3: Queues
 * 11/20/15
 * CSCI142
 * 
 * Description: This class tells the program which method to use if a particular
 * button was pressed using reflection.
 * 
 */
package queues;

import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ButtonListener 
{
	/**
	 * Properties
	 */
	private Object myController;
	private Method myMethod;
	private Object[] myArguments;

	/**
	 * Constructor with two parameters
	 * @param controller : controller being used
	 * @param method : method being used
	 */
	public ButtonListener(Object controller, Method method) 
	{
		myController = controller;
		myMethod = method;
	}
	
	/**
	 * Constructor with three parameters
	 * @param controller : controller being used
	 * @param method : method being used
	 * @param args : arguments needed for the method
	 */
	public ButtonListener(Object controller, Method method, Object[] args) 
	{
		myController = controller;
		myMethod = method;
		myArguments = args;
	}

	/**
	 * Accessing the method when the mouse is released to activate the method 
	 * needed
	 */
	public void mouseReleased(MouseEvent event) 
	{
		Method method;
		Object controller;
		Object[] arguments;

		method = this.getMethod();
		controller = this.getController();
		arguments = this.getArguments();

		try 
		{
			method.invoke(controller, arguments);
		} 
		catch (InvocationTargetException exception) 
		{
			System.out.println("InvocationTargetException");
		} 
		catch (IllegalAccessException exception) 
		{
			System.out.println("IllegalAccessException");
		}
		catch (IllegalArgumentException exception)
		{
			System.out.println("IllegalArgumentException");
		}
	}

	/**
	 * Getting the method
	 * @return the method
	 */
	protected Method getMethod() 
	{
		return myMethod;
	}

	/**
	 * Setting the method
	 * @param method : method needed
	 */
	protected void setMethod(Method method) 
	{
		myMethod = method;
	}

	/**
	 * Getting the controller 
	 * @return the controller
	 */
	protected Object getController() 
	{
		return myController;
	}

	/**
	 * Setting the controller
	 * @param controller : the controller being used
	 */
	protected void setController(Object controller) 
	{
		myController = controller;
	}

	/**
	 * Getting the arguments needed for the method
	 * @return arguments
	 */
	protected Object[] getArguments() 
	{
		return myArguments;
	}

	/**
	 * Setting the arguments needed for the method
	 * @param arguments : the arguments needed for the method
	 */
	protected void setArguments(Object[] arguments) 
	{
		myArguments = arguments;
	}
}
