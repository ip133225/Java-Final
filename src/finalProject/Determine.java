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

	public static boolean weapon(int weapon)		//Determines if user has a weapon
	{
		boolean hasWeapon = false;
		if(weapon > 0)
			hasWeapon = true;
		return hasWeapon;
	}

	public static boolean food(int food)			//Determines if user has food
	{
		boolean hasFood = true;
		if(food < 1)
			hasFood = false;
		return hasFood;
	}

	public static boolean vehicle(int vehicle)		//Determines if user has a vehicle
	{
		boolean hasVehicle = false;
		if(vehicle > 0)
			hasVehicle = true;
		return hasVehicle;
	}

	public static boolean survivors(int survivors)	//Determines if user has survivors
	{
		boolean hasSurvivors = false;
		if(survivors > 0)
			hasSurvivors = true;
		return hasSurvivors;
	}

	public static boolean inCity(int location)		//Determines user's location
	{
		boolean inCity = false;
		if(location == 0)
			inCity = true;
		return inCity;
	}
	
}
