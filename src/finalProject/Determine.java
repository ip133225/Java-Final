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
		boolean hasWeapon = false;
		if(weapon == 1)
			hasWeapon = true;
		return hasWeapon;
	}
	
	public static boolean food(int food)
	{
		boolean hasFood = true;
		if(food == 0)
			hasFood = false;
		return hasFood;
	}
	
	public static boolean vehicle(int vehicle)
	{
		boolean hasVehicle = false;
		if(vehicle == 1)
			hasVehicle = true;
		return hasVehicle;
	}
	
	public static boolean survivors(int survivors)
	{
		boolean hasSurvivors = false;
		if(survivors == 1)
			hasSurvivors = true;
		return hasSurvivors;
	}
	
	public static boolean inCity(String location)
	{
		boolean inCity = false;
		if("City".equals(location))
			inCity = true;
		return inCity;
	}
	
}
