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
	
	public static boolean weapon(int weapon)
	{
		boolean doesHaveWeapon = false;
		if(weapon == 1)
			doesHaveWeapon = true;
		return doesHaveWeapon;
	}
	
	public static boolean food(int food)
	{
		boolean doesHaveFood = true;
		if(food == 0)
			doesHaveFood = false;
		return doesHaveFood;
	}
	
	public static boolean vehicle(int vehicle)
	{
		boolean doesHaveVehicle = false;
		if(vehicle == 1)
			doesHaveVehicle = true;
		return doesHaveVehicle;
	}
	
	public static boolean survivors(int survivors)
	{
		boolean doesHaveSurvivors = false;
		if(survivors == 1)
			doesHaveSurvivors = true;
		return doesHaveSurvivors;
	}
	
	public static boolean location(int location)
	{
		boolean inCity = false;
		if(location == 0)
			inCity = true;
		return inCity;
	}

}
