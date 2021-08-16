package main;

import java.util.Scanner;

public class Converter 
{
	
	public static void menuMain() //Main Menu - Displays first choice to user.
	{
		System.out.println("Select a type of unit to convert:");
		
		System.out.println("1. Energy");
		System.out.println("2. Power");
		
		System.out.println("3. Quit");
	}
	
	public static void menuEnergy()
	{
		Scanner energy = new Scanner(System.in);
		
		System.out.println("Select a unit to convert from.");
		System.out.println("1. Joules");
		System.out.println("2. calories");
		System.out.println("3. electronvolts");
		
		int convFrom = energy.nextInt();
		
		System.out.println("Select a unit to convert to.");
		System.out.println("1. Joules");
		System.out.println("2. calories");
		System.out.println("3. electronvolts");
		
		int convTo = energy.nextInt();
		
		double convFact1; //Conversion factors. Need two in order to account for the selection options.
		double convFact2;
		String unitFrom; //To print out the units selected.
		String unitTo;
		
		switch(convFrom) // The first conversion factor converts the unit to Joules as a baseline.
		{
			default: //Default is the standard unit in case something breaks.
			
			case 1: unitFrom = "J"; convFact1 = 1;  //1 Joule
			break;
				
			case 2: unitFrom = "cal"; convFact1 = .239006; //Joules per calorie
			break;
				
			case 3:  unitFrom = "eV"; convFact1 = 1.60218e-19; //Joules per electronvolt
			break;
		}
			
		switch(convTo) // The second conversion factor just converts from Joules to whatever unit.
		{
			default:
		
			case 1: unitTo = "J"; convFact2 = 1; // J/J
			break;
				
			case 2: unitTo = "cal";  convFact2 = 1/.239006; // cal/J
			break;
				
			case 3: unitTo = "eV"; convFact2 = 1/1.60218e-19; // eV/J
			break;
		}
		
		System.out.println("Enter a value to convert");
		
		double valueIn = energy.nextDouble();
		double valueOut = valueIn*convFact1*convFact2;
				
		System.out.println("Converted " + valueIn + " " + unitFrom + " to " + valueOut + " " + unitTo);
		energy.close();
	}
	
	public static void menuPower()
	{
		Scanner power = new Scanner(System.in);
		
		System.out.println("Select a unit to convert from.");
		System.out.println("1. Watts");
		System.out.println("2. Horsepower");
		System.out.println("3. British Thermal Units");
		
		int convFrom = power.nextInt();
		
		System.out.println("Select a unit to convert to.");
		System.out.println("1. Watts");
		System.out.println("2. Horsepower");
		System.out.println("3. British Thermal Units");
		
		int convTo = power.nextInt();
		
		double convFact1;
		double convFact2;
		String unitFrom;
		String unitTo;
		
		switch(convFrom) // The first conversion factor converts the unit to Watts as a baseline.
		{
			default: //Default is the standard unit in case something breaks.
			
			case 1: unitFrom = "W"; convFact1 = 1;  //1 W
			break;
				
			case 2: unitFrom = "hp"; convFact1 = 745.7; //W per hp
			break;
			
			case 3: unitFrom = "BTU/h"; convFact1 = 0.293071; //W per BTU 
			
			// Fun fact, BTUs are a measure of energy. When HVAC systems/appliances say BTU they mean BTU/h which is actually power.
			// Did not realize that until this project.

		}
		
		switch(convTo) // The second conversion factor just converts from Watts to whatever unit.
		{
			default:
		
			case 1: unitTo = "W"; convFact2 = 1; // J/J
			break;
				
			case 2: unitTo = "hp";  convFact2 = 1/745.7; // HP/Watts
			break;
			
			case 3: unitTo = "BTU/h"; convFact2 = 1/0.293071;

		}

		
		System.out.println("Enter a value to convert");
		
		double valueIn = power.nextDouble();
		double valueOut = valueIn*convFact1*convFact2;
				
		System.out.println("Converted " + valueIn + " " + unitFrom + " to " + valueOut + " " + unitTo);
		power.close();
	}
	
	public static void main(String[] args) 
	{
		int menuSelection = 0; //Menu control variable.
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(menuSelection != 4)
		{
			if(menuSelection == 0)
			{
				menuMain();
				menuSelection = scanner.nextInt(); //Pauses the program to accept input from user.
			}
			
			 else if(menuSelection == 1)
			{
				menuEnergy();
				menuSelection = 3;
			}
			
			else if(menuSelection == 2)
			{
				menuPower();
				menuSelection = 3;
			}
			
			
			else if(menuSelection ==3)
			{
				System.out.println("Program exited.");
				menuSelection = 4;
				scanner.close();
			}
		}
	}
}