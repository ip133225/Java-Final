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

	public static int weapon, food, vehicle, survivors;
	private static String replay = "Yes", base, home, chooseSearch;
	
	public static void main(String[] args) 
	{
		do
		{
			base = JOptionPane.showInputDialog(null, "Welcome to the Zombie Wasteland Survival Game.\nChoose where you set up base:\nCity or Suburbs?");
			
			if("City".equals(base))
				home = JOptionPane.showInputDialog(null, "Where in the city do you set up base?\nA cafe, an aumsement park, or a gun store");
			if("Suburbs".equals(base))
				home = JOptionPane.showInputDialog(null, "Where in the suburbs do you set up base?\nA barn yard, a prison, or a church");
			chooseSearch = JOptionPane.showInputDialog(null, "Would you like to search your base for supplies, or leave in the hopes of finding something?\nSearch or Leave?");
			if("Search".equals(chooseSearch))
			{
				if("cafe".equals(home))
				{
					food = 1;
					weapon = 1;
					JOptionPane.showMessageDialog(null, "You found a single kitchen knife and some nonperishable food." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if("amusement park".equals(home))
				{
					weapon = 1;
					vehicle = 1;
					JOptionPane.showMessageDialog(null, "You found a crowbar and a beat up golf cart." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if("gun store".equals(home))
				{
					weapon = 1;
					JOptionPane.showMessageDialog(null, "You found a small pistol and some ammo for it" + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if("barn yard".equals(home))
				{
					weapon = 1;
					JOptionPane.showMessageDialog(null, "You found a pitchfork." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if("prison".equals(home))
				{
					weapon = 1;
					JOptionPane.showMessageDialog(null, "You found an old taser." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);;
				}
			}
					
			replay = JOptionPane.showInputDialog(null, "Would you like to play again? Type Yes or No");
			
		} while(replay == "Yes");
		
	}
	
	public static void winMessage()
	{
		JOptionPane.showMessageDialog(null, "Congratulations! You survived the four days required for help to arrive. You win!");
		if(vehicle == 0 && food == 0 && weapon == 0)
			JOptionPane.showMessageDialog(null, "You survived with no weapon, vehicle, or extra food. Well done.");
	}
	
	public static void loseMessage()
	{
		JOptionPane.showMessageDialog(null, "You died. Better luck next time.");
	}
	
}
