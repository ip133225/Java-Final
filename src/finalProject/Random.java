/**
 * 
 */
package finalProject;

/**
 * @author mh137428
 *
 */
public class Random 
{

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

}
