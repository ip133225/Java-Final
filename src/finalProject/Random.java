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
	
	public static boolean successGen()
	{
		boolean success = false;
		int random = (int)(Math.random() * 100 + 1);
		if(random >= 50)
			success = true;
		else
			success = false;
		return success;
	}
	
	public static boolean getFood()
	{
		if(Random.successGen())
		{
			Choose.food = Choose.food + 3;
			JOptionPane.showMessageDialog(null, "You managed to find some nonperishables in a nearby building.");
			return true;
		}
		else
		{
			firstClass.death = true;
			JOptionPane.showMessageDialog(null, "You couldn't find food. You starved to death.");
			return false;
		}
	}
	
	public static void flee()
	{
		if(successGen())
		{
			JOptionPane.showMessageDialog(null, "You were quick enough to escape the zombies. Barely.");
		}
		else
		{
			firstClass.death = true;
			JOptionPane.showMessageDialog(null, "You were too slow, and the zombies caught you. You died.");
		}
	}

}
