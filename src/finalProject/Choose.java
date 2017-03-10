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
	public static int base, search, food = 0, vehicle = 0, weapon = 0;
	public static boolean inCity;
	
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
		String[] chooseCityBase = {"A Desolate Cafe", "An Old Amusement Park", "A Deserted Gun Store"};
		String[] chooseSuburbBase = {"An Empty Barn Yard", "A Damaged Prison Building", "An Abandoned Church"};
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
	
	public static void searchorLeave(int base)
	{
		String[] searchorLeave = {"Search", "Leave"};
		
		search = JOptionPane.showOptionDialog(null, "Do you want to search your base for supplies, or leave to scavenge the surrounding area?", "Search or Leave", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, searchorLeave, searchorLeave[0]);
		if(search == 0)
		{
			if(inCity == true)
			{
				if(base == 0)
				{
					++food;
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a single kitchen knife and some nonperishable food." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 1)
				{
					++weapon;
					++vehicle;
					JOptionPane.showMessageDialog(null, "You found a crowbar and a beat up golf cart." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 2)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a pistol and some ammo." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
			}
			else
			{
				if(base == 0)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a single pitchfork." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 1)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found an old taser." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 2)
				{
					JOptionPane.showMessageDialog(null, "It seems the church has been ransacked. You found nothing." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
			}
		}
	}
	
	public static void chooseFightOrFlee()
	{
		JOptionPane.showInputDialog(null, "Oh no! A zombie horde has found you wandering around. Do you choose to fight or flee from the horde?"
				+ "(Hint: If you have no weapon, do not fight)");
	}
	public static void chooseVehicle()
	{
		JOptionPane.showInputDialog(null, "Do you choose to to hotwire the first vehicle you see or search for vehicle with keys?");
	}
}
