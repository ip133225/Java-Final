/**
 * 
 */
package finalProject;

import javax.swing.JOptionPane;

/**
 * @author mh137428
 *
 */
public class Choose 
{
	public static int search, survivors = 0, food = 0, vehicle = 0, weapon = 0, variable;
	private static boolean inCity;
	
	
	
	public static int base()
	{
		String[] chooseCityBase = {"A Desolate Cafe", "An Old Amusement Park", "A Deserted Gun Store"};
		String[] chooseSuburbBase = {"An Empty Barn Yard", "A Damaged Prison Building", "An Abandoned Church"};
		
		inCity = Determine.inCity(location());
		
		if(inCity == true)
		{
			variable = JOptionPane.showOptionDialog(null, "Where in the city do you want to set up your base?", "Choose Base", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, chooseCityBase, chooseCityBase[0]);
		}
		else
		{
			variable = JOptionPane.showOptionDialog(null, "Where in the suburbs do you want to set up your base?", "Choose Base", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, chooseSuburbBase, chooseSuburbBase[0]);
		}
		return variable;
	}
	
	public static int location()
	{
		String[] chooseLocation = {"City", "Suburbs"};
		int inCityNumber;
		
		JOptionPane.showMessageDialog(null, "Welcome to the Zombie Wasteland Survival Game!");
		inCityNumber = JOptionPane.showOptionDialog(null, "To begin, choose a place you would live:", "Choose Location", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, chooseLocation, chooseLocation[0]);
		return inCityNumber;
	
	}
	public static void searchorLeave(int base)
	{
		String[] searchorLeave = {"Search", "Leave"};
		
		variable = JOptionPane.showOptionDialog(null, "Do you want to search your base for supplies, or leave to scavenge the surrounding area?", "Search or Leave", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, searchorLeave, searchorLeave[0]);
		if(variable == 0)
		{
			if(inCity == true)
			{
				if(base == 0)
				{
					++food;
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a single kitchen knife and some nonperishable food." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 1)
				{
					++weapon;
					++vehicle;
					JOptionPane.showMessageDialog(null, "You found a crowbar and a beat up golf cart." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 2)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a pistol and some ammo." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
			}
			else
			{
				if(base == 0)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a single pitchfork." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 1)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found an old taser." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
				if(base == 2)
				{
					JOptionPane.showMessageDialog(null, "It seems the church has been ransacked. You found nothing." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
				}
			}
		}
		else if(inCity == true)
		{
			++vehicle;
			JOptionPane.showMessageDialog(null, "You found a rusty pickup truck." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
		}
		else
		{
			++weapon;
			JOptionPane.showMessageDialog(null, "You found a crossbow and some bolts." + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle);
		}
	}

	public static void beginDay2()
	{
		if(Determine.food(food))
		{
			baseOrLook();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You do not have any food for the day. You will have to go scavenging.");
			if(Random.getFood())
				baseOrLook();
		}
	}
	
	public static void baseOrLook()
	{
		String[] baseHelp = {"Reinforce Base", "Look for Survivors"};
	
		variable = JOptionPane.showOptionDialog(null, "You wake up ready to continue working. Do you want to use local resources to reinforce your base, or look for some survivors?", 
				"Base or Search", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, baseHelp, baseHelp[0]);
		if(variable == 0)
		{
			++survivors;
			JOptionPane.showMessageDialog(null, "You spend half the day gathering resources, and the later half building defenses.\nHowever, once you have settled down to a fire, a group of scavengers meets you.\nYou decide to help them out."
					+ " (This now requires you to use two food per day, instead of one)");
		}
		else
		{
			fightOrFlee();
		}
	}

	public static void fightOrFlee()
	{
		String[] flee = {"Flee"};
		String[] fightorFlee = {"Flee", "Fight"};
		if(weapon > 0)
		{
			variable = JOptionPane.showOptionDialog(null, "While you are out wandering, a group of zombies finds you.\nYou have a weapon, so do you want run away, or fight them off?", 
				"Flee or Fight", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, fightorFlee, fightorFlee[0]);
		}
		else
		{
			variable = JOptionPane.showOptionDialog(null, "While you are out wandering, a group of zombies finds you.\nYou don't have a weapon. You can only flee for a chance of survival.", 
					"Flee", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, flee, flee[0]);
		}
		if(variable == 0)
		{
			Random.flee();
		}
		else
		{
			fight();
		}
	}
	
	public static void fight()
	{
		JOptionPane.showMessageDialog(null, "You finish the battle with blood dripping off of you.\nWell done.");
	}
	
	public static void beginDay3()
	{
		if(Determine.survivors(survivors))
		{
			food = food - 2;
		}
		else 
			--food;
		if(Determine.food(food))
		{
			vehicleWeaponFood();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You do not have any food for the day. You will have to go scavenging.");
			if(Random.getFood())
				vehicleWeaponFood();
		}
	}
	
	public static void vehicleWeaponFood()
	{
		String[] vehicleWeaponFood = {"Look for A Vehicle", "Look for A Weapon", "Look for Extra Food"};
		
		variable = JOptionPane.showOptionDialog(null, "You decide to spend the day preparing for the final day before help arrives.\nHow do you spend it?.", 
				"Preparations", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, vehicleWeaponFood, vehicleWeaponFood[0]);
		if(variable == 0)
			System.out.println("Success");
	}
	
	public static void vehicle()
	{
		JOptionPane.showInputDialog(null, "Do you choose to to hotwire the first vehicle you see or search for vehicle with keys?");
	}
}
