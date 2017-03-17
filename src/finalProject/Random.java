/**
 * 
 */
package finalProject;

import javax.swing.JOptionPane;

/**
 * @author mh137428
 *
 */
public class Random 
{
	
	public static boolean successGen()		//Random generator uses values to succeed or fail
	{
		boolean success = false;
		int random = (int)(Math.random() * 100 + 1);
		if(random <= Choose.random)
			success = true;
		else
			success = false;
		return success;
	}
	
	public static boolean getFood()			//Determines if User finds food or not, based on random generator
	{
		if(Random.successGen())
		{
			Choose.food = Choose.food + 3;
			JOptionPane.showMessageDialog(null, "You managed to find some nonperishables in a nearby building. +3 Food"  
					+ "\nStats:\nFood: " + Choose.food + "\nWeapons: " + Choose.weapon + "\nVehicles: " + Choose.vehicle, 
					null, JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		else
		{
			firstClass.death = true;
			JOptionPane.showMessageDialog(null, "You couldn't find food. You starved to death.", null, JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public static void flee()				//Determines if User can flee a horde, based on random generator
	{
		if(successGen())
		{
			JOptionPane.showMessageDialog(null, "You were quick enough to escape the zombies. Barely.", null, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			firstClass.death = true;
			JOptionPane.showMessageDialog(null, "You were too slow, and the zombies caught you. You died.", null, JOptionPane.ERROR_MESSAGE);
		}
	}

}
