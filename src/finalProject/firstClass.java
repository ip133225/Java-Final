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
	private static String replay;
	
	public static void main(String[] args) 
	{
		do
		{
			
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
		replay = JOptionPane.showInputDialog(null, "Would you like to play again? Type Yes or No");
	}
	
}
