package controllers;

import java.io.File;

import java.util.Scanner;


import utils.Serializer;
import utils.XMLSerializer;


/**
 * This is the main class that uses console i/o to interact with the user.  
 * ****************Known Bugs: Depth Search  ****************************
 * @author Judy O'Brien
 * @version 1
 */



/**
 * Creates a new scanner for i/o
 * @param a new File called dictionary.xml
 * @returns an array and hashtree of data
 * @
 */
public class Main {



	private static Scanner input = new Scanner(System.in);


	public static void main(String[] args) throws Exception {

		File  dictionary = new File("dictionary.xml");
		Serializer serializer = new XMLSerializer(dictionary);
		DictionaryAPI d = new DictionaryAPI(serializer); 
		if (dictionary.isFile())
		{
			d.load();
		}
		else d.loadDefaultFiles();
	

	/**
	 * Runs the program using i/o from user
	 * 
	 */

	System.out.println("Dictionary");
	System.out.println("-----------------");

	boolean goodInput = false;
	do{
		try{
			int option = mainMenu();
			while (option != 0)
			{
				goodInput = true;

				switch (option)
				{
				case 1:
					System.out.println("Enter the word: ");
					input.nextLine(); //swallow bug
					String temp = input.next();
					System.out.println("Answer From TreeMap =     " +  d.dictionary.get(temp));
					
				
					for(int i = 0; i < d.maxHeap.getSize(); i++){	
						
						if(d.maxHeap.getItem(i).getSpanish().equals(temp))
								System.out.println("Answer From Level Search =    " + d.maxHeap.getItem(i).getEnglish());
								
					}
					System.out.println("========================\n");
					System.out.println("Answer From Judys Search\n");
					d.maxHeap.find(temp);
					System.out.println("========================\n");
					System.out.println("Answer From Other Search");
					d.maxHeap.find3(temp);
					
					
					break;
				case 2:
					System.out.println(d.maxHeap.getMax());
					System.out.println(d.maxHeap.toString());
					System.out.println(d.maxHeap.getSize());
					break;
					
				case 3:
					System.out.println("Enter Spanish word:");
					input.nextLine();
					String english = input.next();
					System.out.println("Enter English translation:");
					input.nextLine();
					String spanish = input.next();
					Item item = new Item(english, spanish);
					d.dictionary.put(english, spanish);
					d.maxHeap.add(item);
				    break;
				   
				case 4:
					d.dictionary.remove(d.maxHeap.getItem(0).getSpanish());
					d.maxHeap.removeMax();
					
					System.out.println("Size of Heap : "  + d.maxHeap.getSize());
				    break;
				    
				default:    System.out.println("Invalid option entered: " + option);
				mainMenu();
				break;
				}

				//pause the program so that the user can read what we just printed to the terminal window
				System.out.println("\nPress any key to continue...");
				input.nextLine();

				//display the main menu again
				option = mainMenu();
				//the user chose option 0, so exit the program
			}
			System.out.println("Exiting... bye");
			d.store();
			System.exit(0);

		}

		catch (Exception e) {
			input.nextLine(); //swallows bug
			System.err.println("Num expected - You Entered Text. Try Again...\n");
		}
	} while (!goodInput);  	




}


/**
 * mainMenu() - This method displays the menu for the application, 
 * reads the menu option that the user entered and returns it.
 * @return     the users menu choice
 */

private static  int mainMenu() {
	System.out.println("1)Translate a Word to English");
	System.out.println("2)Get Max on Heap"  );
	System.out.println("3)Add an Item");
	
	System.out.println("4)Delete Max Item");
	


	System.out.println("0) Exit");
	System.out.print("==>>");

int option = input.nextInt();
	return option;
}








}//end of main


