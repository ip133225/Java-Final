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

	public static boolean yes;
	public static int weapon, food, vehicle, survivors;
	private static String base, home, chooseSearch;
	
	public static void chooseFightOrFlee()
	{
		JOptionPane.showInputDialog(null, "Oh no! A zombie horde has found you wandering around. Do you choose to fight or flee from the horde?"
				+ "(Hint: If you have no weapon, do not fight)");
	}
	public static void chooseVehicle()
	{
		JOptionPane.showInputDialog(null, "Do you choose to to hotwire the first vehicle you see or search for vehicle with keys?");
	}
	
	public static void chooseBase()
	{
		base = JOptionPane.showInputDialog(null, "Welcome to the Zombie Wasteland Survival Game.\nChoose where you set up base:\nCity or Suburbs?");
		
		if("City".equals(base))
			home = JOptionPane.showInputDialog(null, "Where in the city do you set up base?\nA cafe, an aumsement park, or a gun store");
		if("Suburbs".equals(base))
			home = JOptionPane.showInputDialog(null, "Where in the suburbs do you set up base?\nA barn yard, a prison, or a church");
		
		chooseSearch = JOptionPane.showInputDialog(null, "Would you like to search your base for supplies, or leave in the hopes of finding something?\nSearch or Leave?");
		
		
	}
	
}
