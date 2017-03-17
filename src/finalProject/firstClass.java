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
	
	public static int replay, base, location, days;
	public static boolean death = false;
	
	public static void main(String[] args) 
	{
		
		JOptionPane.showMessageDialog(null, "Welcome to the Zombie Wasteland Survival Game!");
		
		do																														//Loop for playing again
		{
			Choose.food = 1;																									//Resets values for playing again 
			Choose.weapon = 0;
			Choose.vehicle = 0;
			Choose.survivors = 0;
			death = false;
			Choose.difficulty();																								//User chooses difficulty for randomness
			base = Choose.base();																								//User chooses home
			Choose.searchorLeave(base);																							//User chooses and earns based on home
			if(death == false)
			{
				JOptionPane.showMessageDialog(null, "Day 1 Ends, Day 2 Begins", null, JOptionPane.INFORMATION_MESSAGE);			//If User is alive, begin day 2
				Choose.beginDay2();
				if(death == false)
				{
					JOptionPane.showMessageDialog(null, "Day 2 Ends, Day 3 Begins", null, JOptionPane.INFORMATION_MESSAGE);		//If User is alive, begin day 3
					Choose.beginDay3();
					if(death == false)
					{
						JOptionPane.showMessageDialog(null, "Day 3 Ends, Day 4 Begins", null, JOptionPane.INFORMATION_MESSAGE);	//If User is alive, begin day 4
						Choose.beginDay4();
					}
				}		
			}
			
			replay = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);//Ask User to play again
		} while(replay == JOptionPane.YES_OPTION);
		
	}
	
}
