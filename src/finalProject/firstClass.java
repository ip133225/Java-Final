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
		do
		{
			Choose.food = 0;
			Choose.weapon = 0;
			Choose.vehicle = 0;
			death = false;
			base = Choose.base();
			Choose.searchorLeave(base);
			if(death == false)
			{
				JOptionPane.showMessageDialog(null, "Day 1 Ends, Day 2 Begins");
				Choose.beginDay2();
				if(death == false)
				{
					JOptionPane.showMessageDialog(null, "Day 2 Ends, Day 3 Begins");
					Choose.beginDay3();
					if(death == false)
					{
						JOptionPane.showMessageDialog(null, "Day 3 Ends, Day 4 Begins");
						Choose.beginDay4();
					}
				}		
			}
			
			replay = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
		} while(replay == JOptionPane.YES_OPTION);
		
	}
	
}
