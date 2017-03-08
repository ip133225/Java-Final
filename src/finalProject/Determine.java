/**
 * 
 */
package finalProject;

/**
 * @author mh137428
 *
 */
public class Determine 
{
	public static int weapon, food, vehicle, survivors;
	
	public static void main(String[] args) 
	{
	
	}
	
	public static boolean weapon()
	{
		boolean doesHaveWeapon = false;
		if(weapon == 1)
			doesHaveWeapon = true;
		return doesHaveWeapon;
	}
	
	public static boolean food()
	{
		boolean doesHaveFood = true;
		if(food == 0)
			doesHaveFood = false;
		return doesHaveFood;
	}
	
	public static boolean vehicle()
	{
		boolean doesHaveVehicle = false;
		if(vehicle == 1)
			doesHaveVehicle = true;
		return doesHaveVehicle;
	}
	
	public static boolean survivors()
	{
		boolean doesHaveSurvivors = false;
		if(survivors == 1)
			doesHaveSurvivors = true;
		return doesHaveSurvivors;
	}

}
