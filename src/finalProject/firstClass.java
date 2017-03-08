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
	private static String replay = "Yes", base, home;
	
	public static void main(String[] args) 
	{
		{
			base = JOptionPane.showInputDialog(null, "Welcome to the Zombie Wasteland Survival Game.\nChoose where you set up base:\nCity or Suburbs?");
			
			if("City".equals(base))
				home = JOptionPane.showInputDialog(null, "Where in the city do you set up base?\nA cafe, an aumsement park, or a gun store");
			if("Suburbs".equals(base))
				home = JOptionPane.showInputDialog(null, "Where in the suburbs do you set up base?\nA barn yard, a prison, or a church");
			
		}
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
		replay = JOptionPane.showInputDialog(null, "Would you like to play again? Type Yes or No");
	}
	
}
