/**
 * 
 */
package finalProject;

import javax.swing.JOptionPane;

/**
 * @author mh137428
 *
 */
public class Choose 
{
	public static int base;
	
	public static void chooseFightOrFlee()
	{
		JOptionPane.showInputDialog(null, "Oh no! A zombie horde has found you wandering around. Do you choose to fight or flee from the horde?"
				+ "(Hint: If you have no weapon, do not fight)");
	}
	public static void chooseVehicle()
	{
		JOptionPane.showInputDialog(null, "Do you choose to to hotwire the first vehicle you see or search for vehicle with keys?");
	}
	
	public static int chooseLocation()
	{
		String[] chooseLocation = {"City", "Suburbs"};
		int inCity;
		
		JOptionPane.showMessageDialog(null, "Welcome to the Zombie Wasteland Survival Game!");
		inCity = JOptionPane.showOptionDialog(null, "To begin, choose a place you would live:", "Choose Location", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, chooseLocation, chooseLocation[0]);
		return inCity;
	}
	
	public static int chooseBase()
	{
		String[] chooseLocation = {"City", "Suburbs"};
		String[] chooseCityBase = {"A Desolate Cafe", "An Old Amusement Park", "A Deserted Gun Store"};
		String[] chooseSuburbBase = {"An Empty Barn Yard", "A Damaged Prison Building", "An Abandoned Church"};
		String[] searchOrLeave = {"Search", "Leave"};
		boolean inCity;
		int variable;
		
		inCity = Determine.inCity(chooseLocation());
		
		if(inCity == true)
		{
			base = JOptionPane.showOptionDialog(null, "Where in the city do you want to set up your base?", "Choose Base", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, chooseCityBase, chooseCityBase[0]);
		}
		else
		{
			base = JOptionPane.showOptionDialog(null, "Where in the suburbs do you want to set up your base?", "Choose Base", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, chooseSuburbBase, chooseSuburbBase[0]);
		}
		return base;
	}
}
