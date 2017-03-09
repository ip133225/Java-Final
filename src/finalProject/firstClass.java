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
	
	public static String replay = "Yes";
	
	public static void main(String[] args) 
	{
		do
		{
			
					
			replay = JOptionPane.showInputDialog(null, "Would you like to play again? Type Yes or No");
			
		} while(replay == "Yes");
		
	}
	
	public static void winMessage()
	{
		JOptionPane.showMessageDialog(null, "Congratulations! You survived the four days required for help to arrive. You win!");
	}
	
	public static void loseMessage()
	{
		JOptionPane.showMessageDialog(null, "You died. Better luck next time.");
	}
	
}
