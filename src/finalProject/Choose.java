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
	public static int search, variable, variable2, random, difficulty, survivors = 0, food = 0, vehicle = 0, weapon = 0;
	private static boolean inCity;
	
	public static void difficulty()
	{
		String[] difficultyString = {"Easy", "Normal", "Hard"};
		difficulty = JOptionPane.showOptionDialog(null, "What difficulty do you want to play on?", "Choose Difficulty", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, difficultyString, difficultyString[0]);
		if(difficulty == 0)
			random = 75;
		if(difficulty == 1)
			random = 50;
		if(difficulty == 2)
			random = 5;
	}
	
	public static int base()
	{
		String[] chooseCityBase = {"A Desolate Cafe", "An Old Amusement Park", "A Deserted Gun Store"};
		String[] chooseSuburbBase = {"An Empty Barn Yard", "A Damaged Prison Building", "An Abandoned Church"};
		
		inCity = Determine.inCity(location());
		
		if(inCity == true)
		{
			variable = JOptionPane.showOptionDialog(null, "Where in the city do you want to set up your base?", "Choose Base", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, chooseCityBase, chooseCityBase[0]);
		}
		else
		{
			variable = JOptionPane.showOptionDialog(null, "Where in the suburbs do you want to set up your base?", "Choose Base", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, chooseSuburbBase, chooseSuburbBase[0]);
		}
		return variable;
	}
	
	public static int location()
	{
		String[] chooseLocation = {"City", "Suburbs"};
		int inCityNumber;
		
		inCityNumber = JOptionPane.showOptionDialog(null, "To begin, choose a place you would live:", "Choose Location", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, chooseLocation, chooseLocation[0]);
		return inCityNumber;
	
	}
	
	public static void searchorLeave(int base)
	{
		String[] searchorLeave = {"Search", "Leave"};
		
		variable = JOptionPane.showOptionDialog(null, "Do you want to search your base for supplies, or leave to scavenge the surrounding area?", 
				"Search or Leave", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, searchorLeave, searchorLeave[0]);
		if(variable == 0)
		{
			if(inCity == true)
			{
				if(base == 0)
				{
					++food;
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a single kitchen knife and some nonperishable food. +1 Food, +1 Weapon" 
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if(base == 1)
				{
					++weapon;
					++vehicle;
					JOptionPane.showMessageDialog(null, "You found a crowbar and a beat up golf cart. +1 Weapon, +1 Vehicle" 
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if(base == 2)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a pistol and some ammo. +1 Weapon" 
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				if(base == 0)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found a single pitchfork. +1 Weapon" 
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if(base == 1)
				{
					++weapon;
					JOptionPane.showMessageDialog(null, "You found an old taser. +1 Weapon" 
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if(base == 2)
				{
					JOptionPane.showMessageDialog(null, "It seems the church has been ransacked. You found nothing." 
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if(inCity == true)
		{
			++vehicle;
			JOptionPane.showMessageDialog(null, "You found a rusty pickup truck. +1 Vehicle" 
					+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			++weapon;
			JOptionPane.showMessageDialog(null, "You found a crossbow and some bolts. +1 Weapon" 
					+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void beginDay2()
	{
		--food;
		if(Determine.food(food))
		{
			baseOrLook();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You do not have any food for the day. You will have to go scavenging.", 
					null, JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "You spend half the day gathering resources, and the later half building defenses.\nHowever, once you have settled down to a fire, a lone scavenger meets you.\nYou decide to help them out. +1 Survivor"
					+ " (This now requires you to use two food per day, instead of one)", null, JOptionPane.INFORMATION_MESSAGE);
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
		
		if(Determine.weapon(weapon))
		{
			variable = JOptionPane.showOptionDialog(null, "While you are out wandering, a group of zombies finds you.\nYou have a weapon, so do you want run away, or fight them off?", 
				"Flee or Fight", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, fightorFlee, fightorFlee[0]);
		}
		else
		{
			variable = JOptionPane.showOptionDialog(null, "While you are out wandering, a group of zombies finds you.\nYou don't have a weapon. You can only flee for a chance of survival.", 
					"Flee", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, flee, flee[0]);
		}
		if(variable == 0)
		{
			Random.flee();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You finish the battle with blood dripping off of you.\nWell done.",
					null, JOptionPane.INFORMATION_MESSAGE);
		}
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
			day3();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You do not have any food for the day. You will have to go scavenging.", 
					null, JOptionPane.WARNING_MESSAGE);
			if(Random.getFood())
				day3();
		}
	}
	
	public static void day3()
	{
		String[] vehicleWeaponFood = {"Look for A Vehicle", "Look for A Weapon", "Look for Extra Food"};
		String[] vehicleSearch = {"Hotwire", "Search"};
		
		variable = JOptionPane.showOptionDialog(null, "You decide to spend the day preparing for the final day before help arrives.\nHow do you spend it?."  
				+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, "Preparations", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, vehicleWeaponFood, vehicleWeaponFood[0]);
		if(variable == 0)
		{
			variable2 = JOptionPane.showOptionDialog(null, "Now, do you hotwire the first car you see, or search for a car with the key in the ignition?", "Hotwire or Search", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, vehicleSearch, vehicleSearch[0]);
			if(variable2 == 0)
			{
				if(Random.successGen())
				{
					++vehicle;
					JOptionPane.showMessageDialog(null, "Your knowledge of mechanics pays off. You hotwired the car. +1 Vehicle"
							+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You had no idea how a car works, and tried hotwiring it."
							+ "\nOne thing lead to another, and it blew up with you inside. You are dead.", null, JOptionPane.ERROR_MESSAGE);
					firstClass.death = true;
				}
			}
			if(variable2 == 1)
			{
				++vehicle;
				JOptionPane.showMessageDialog(null, "It takes a couple hours, but you manage to find a car with the keys still inside. +1 Vehicle" 
						+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(variable == 1)
		{
			if(Random.successGen())
			{
				++weapon;
				JOptionPane.showMessageDialog(null, "You scrounged through junk for hours, but managed to find a dull machete. +1 Weapon"  
						+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You tried for hours, but didn't find anything useful."  
						+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(variable == 2)
		{
			if(Random.successGen())
			{
				food = food + 2;
				JOptionPane.showMessageDialog(null, "You managed to kill and skin a deer for some fresh food. +2 Food"  
						+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				++food;
				JOptionPane.showMessageDialog(null, "You managed to find a small amount of food in an old shop. Only enough for one person though. +1 Food"
						 + "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public static void beginDay4()
	{
		if(Determine.survivors(survivors))
		{
			food = food - 2;
		}
		else 
			--food;
		if(Determine.food(food))
		{
			day4();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You do not have any food for the day. You will have to go scavenging.", 
					null, JOptionPane.WARNING_MESSAGE);
			if(Random.getFood())
				day4();
		}
	}
	
	public static void day4()
	{
		String[] searchHelp = {"Search", "Wait"};
		
		variable = JOptionPane.showOptionDialog(null, "The final day has arrived. There is one big question looming over your head though.\nDo you search for help or wait for them to find you?"
				+ "\nStats:\nFood: " + food + "\nWeapons: " + weapon + "\nVehicles: " + vehicle, "Search or Wait", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, searchHelp, searchHelp[0]);
		if(variable == 0)
		{
			if(Determine.vehicle(vehicle))
			{
				JOptionPane.showMessageDialog(null, "You spend hours driving around. Around noon, you hear a whirring in the air.\nYou look up, only to see a helicopter in the distance."
						+ " Help has arrived.", null, JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				fightOrFlee();
				if(firstClass.death == false)
				{
					JOptionPane.showMessageDialog(null, "Once the battle is over you here a helicopter in the distance. "
							+ "You look up, and finally see help arrive.", null, JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else
		{
			if(Determine.food(food))
			{
				JOptionPane.showMessageDialog(null, "You spend most of the day in your base, waiting near your fire.\nYou almost lose hope as you see the sun set, but you keep waiting."
						+ "\nFinally, you hear a helicopter in the distance. Help has arrived.", null, JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.INFORMATION_MESSAGE);
				
			}
			else
			{
				if(Random.getFood())
				{
					JOptionPane.showMessageDialog(null, "You wait at base for hours upon hours.\nLittle hope is left, once you see the sun setting!"
							+ "\nFinally, a helicopter can be heard in the distance. Help has arrived.", null, JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

}
