/**
 * 
 */
package finalProject;

/**
 * @author MH137428
 *
 */
import javax.swing.JOptionPane;
public class firstClass 
{

	private static int weapon, food, vehicle, survivors, home;
	
	public static void main(String[] args) 
	{
		
	}
	
	public static boolean successGen()
	{
		boolean success = false;
		int random = (int)(Math.random() * 100 + 1);
		if(random > 50)
			success = true;
		if(random <= 50)
			success = false;
		return success;
	}
	
	public static boolean determineWeapon()
	{
		boolean doesHaveWeapon = false;
		if(weapon == 1)
			doesHaveWeapon = true;
		return doesHaveWeapon;
	}
	
	public static boolean determineFood()
	{
		boolean doesHaveFood = true;
		if(food == 0)
			doesHaveFood = false;
		return doesHaveFood;
	}
	
	public static boolean determineVehicle()
	{
		boolean doesHaveVehicle = false;
		if(vehicle == 1)
			doesHaveVehicle = true;
		return doesHaveVehicle;
	}
	
	public static boolean determineSurvivors()
	{
		boolean doesHaveSurvivors = false;
		if(survivors == 1)
			doesHaveSurvivors = true;
		return doesHaveSurvivors;
	}
	
	public static void winMessage()
	{
		JOptionPane.showMessageDialog(null, "Congratulations! You survived the four days required for help to arrive. You win!");
		if(vehicle == 0 && food == 0 && weapon == 0)
			JOptionPane.showMessageDialog(null, "You survived with no weapon, vehicle, or extra food. Well done.");
		else if(vehicle == 1)
			JOptionPane.showMessageDialog(null, )
	}
	
}
