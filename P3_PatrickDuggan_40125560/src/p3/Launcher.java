package p3;

/**
 * Author Patrick Duggan 40125560
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Launcher {

	private static Scanner scanner = new Scanner(System.in);
	private static final int QUIT = 10;

	/**
	 * Entry point of program - no need to modify this method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launchMenu();
		scanner.close();// close scanner once menu system completes
	}

	// TODO modify readData method to populate List appropriately - method partially
	// completed already
	// TODO add static methods to this class as required to achieve tasks outlined
	// in menu
	// TODO modify launchMenu method to add calls to new methods you write etc to
	// accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user
	 * choices Partially implemented already. Requires updating to add calls to other
	 * methods written to achieve the tasks described in tasks 3-9
	 */
	public static void launchMenu() {
		List<Accommodation> mainList = readRoomData("Rooms.csv");

		System.out.println();
		int option;
		System.out.println("AccommyNation.com - Wherever you go, you'll need to stay");

		// repeat until quit chosen
		do {
			displayOptions();

			// get input
			option = getMenuChoice("Enter choice ...");
			System.out.println();

			try {
				// process choice - invoke relevant methods etc.
				switch (option) {

				case 1:
					mainList = readRoomData("Rooms.csv");
					break;
				case 2:
					System.out.println("Number of places to stay is " + mainList.size());
					break;
				case 3:
					System.out.println("Details of all places to stay:\n");
					printDetails(mainList);
					break;
				case 4:
					System.out.println("Three least expensive palces to stay in LA with a 4 star rating:\n");
					List<Accommodation> cheapLAFourStar = findXCheapest(mainList, 3, "Los Angeles", 4);
					printDetails(cheapLAFourStar);
					break;
				case 5:
					System.out.println("Number of unique city names in current list:\n");
					findUniqueCityNames(mainList);
					break;
				case 6:
					System.out.println("Four most expensive BnBs in Dublin:");
					List<Accommodation> expensiveBnbsDublin = findXCheapestByType(mainList, 4, "Dublin", Type.BNB);
					printDetails(expensiveBnbsDublin);
					break;
				case 7:
					averagePriceOfAccomInCity(mainList, Type.HOTEL, "New York");
					break;
				case 8:
					System.out.println("Removing all entries from list with fewer than 10 rooms available in Paris...\n");
					removeEntriesWithFewerThanXRoomsInX(mainList, 10, "Paris");
					break;
				case 9:
					Collections.sort(mainList, new CompareByName());
					//Map<String , Double> newMap = citiesMap(mainList); //this is where i would have assigned each city and avg to map
					//Map<String, Double> avgCities = citiesByAverageHotelCost(newMap);
					//callWriterThread (avgCities);
					
					break;
				case QUIT:
					System.out.println("Quitting");
					break;
				default:
					System.out.println("Try options again...");
				}

			} catch (Exception e) {
				System.out.println("Exception caught");
				System.out.println(e.getMessage());
				System.out.println("please try again");
			}

		} while (option != QUIT);
	}

	/**
	 * Method to call writer thread
	 * @param avgCities
	 */
	public static void callWriterThread(Map<String, Double> avgCities) {
		WriterThread myThread = new WriterThread(avgCities);
		Thread t = new Thread();
		t.start();
		
	}

	/**
	 * Method to calculate the average cost of hotel by city and return a map
	 * @param newMap
	 * @return
	 */
	public static Map<String, Double> citiesByAverageHotelCost(Map<String, Double> newMap) {
		
		//here is where i would calculate average hotel cost and assign that value to each key (city)
		
		return null;
	}

//	private static Map<String, Double> citiesMap(List<Accommodation> mainList) {
//		
//		List<Accommodation> localCopy = new ArrayList<Accommodation>();
//		Map<String, Double> myMap = new HashMap<String, Double>();
//		
//		double totalCityCost = 0;
//		for(Accommodation accom: mainList) {
//			if(myMap.containsKey(accom.getCity())) {
//				totalCityCost+= accom.g
//				myMap.replace(accom.getCity(), value)
//			}
//		}
//		return myMap;
//		
//	}

	/**
	 * Method to remove entries with few than X amount of rooms available in a given city
	 * @param mainList
	 * @param rooms
	 * @param city
	 */
	private static void removeEntriesWithFewerThanXRoomsInX(List<Accommodation> mainList, int rooms,
			String city) {
		
		
		Set<Accommodation> entriesRemoved = new HashSet<Accommodation>();
		
		for(Accommodation accom: mainList) {
			if(accom.getCity().equals(city) && accom.getRooms()<rooms) {
				
			} else {
				entriesRemoved.add(accom);
			}
		}
		
		mainList.clear();
		mainList.addAll(entriesRemoved);
		
		
	}

	/**
	 * Method to calculate the average price of accommodation in a given city
	 * @param mainList
	 * @param type
	 * @param city
	 */
	private static void averagePriceOfAccomInCity(List<Accommodation> mainList, Type type, String city) {
		
		int counter = 0;
		double averagePrice = 0;
		for(Accommodation accom: mainList) {
			if(accom.getCity().equals(city) && accom.getType().equals(type)) {
				averagePrice +=accom.getPrice();
				counter++;
			}
		}
		averagePrice = averagePrice / counter;
		System.out.printf("%s %s: %s%.2f","Average Price",city,"$",averagePrice);
		
	}

	/**
	 * Method to find the cheapest X amount of accommodations by type
	 * @param mainList
	 * @param amount
	 * @param city
	 * @param type
	 * @return
	 */
	private static List<Accommodation> findXCheapestByType(List<Accommodation> mainList, int amount, String city,
			Type type) {
		
		List<Accommodation> cheapestByType = new ArrayList<Accommodation>();
		Collections.sort(mainList, new CompareByPrice());
		
		for(Accommodation accom: mainList) {
			if(accom.getCity().equals(city) && accom.getType().equals(type) && cheapestByType.size()<amount) {
				cheapestByType.add(accom);
			}
		}
		
		return cheapestByType;
	}

	/**
	 * Method to find unique city names - adding each city to a new set of strings and then printing the size of the set of strings
	 * (the number of unique cities)
	 * @param mainList
	 */
	private static void findUniqueCityNames(List<Accommodation> mainList) {
		
		Set<String> uniqueCities = new HashSet<String>();
		
		for(Accommodation accom: mainList) {
			uniqueCities.add(accom.getCity());
		}
		
		System.out.println("Number of Cities: "+uniqueCities.size());
		
	}

	/**
	 * Method to find the X amount of cheapest accomodation in a given city with a given amount of stars
	 * @param mainList
	 * @param amount
	 * @param city
	 * @param stars
	 * @return
	 */
	private static List<Accommodation> findXCheapest(List<Accommodation> mainList, int amount, String city, int stars) {
		
		List<Accommodation> cheapLAFourStar = new ArrayList<Accommodation>();
		Collections.sort(mainList, new CompareByPrice().reversed());
		
		for(Accommodation accom: mainList) {
			if(accom.getCity().equals(city) && accom.getStars() == stars && cheapLAFourStar.size()<amount) {
				cheapLAFourStar.add(accom);
			}
		}
		
		return cheapLAFourStar;
	}

	/**
	 * Method to print details of items in a list
	 * @param mainList
	 */
	private static void printDetails(List<Accommodation> mainList) {
		
		for(Accommodation accom: mainList) {
			accom.printDetails();
		}
		
	}

	/**
	 * Read data from a given filename for a formatted csv file of accommodation
	 * data
	 * 
	 * @param filename
	 * @return list of accommodation objects for each row of the file containing
	 *         valid data
	 */
	public static List<Accommodation> readRoomData(String filename) {
		
		List<Accommodation> listFromFile = new ArrayList<Accommodation>();
		
		File file = new File(filename);
		
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {
			
			//discard header
			String line = reader.readLine();
			//read first line
			line = reader.readLine();
			
			while(line != null) {
				
				try {
					
					//split values based off separator
					String[] fields = line.split(",");
					
					//instantiate Accom object
					String name = fields[0];
					
					Type myType = null;
					if(fields[1].equalsIgnoreCase("BNB")) {
						myType = Type.BNB;
					} else if(fields[1].equalsIgnoreCase("hotel")) {
						myType = Type.HOTEL;
					} else {
						myType = Type.HOSTEL;
					}
					
					int stars = Integer.parseInt(fields[2]);
					String city = fields[3];
					int price = Integer.parseInt(fields[4]);
					int rooms = Integer.parseInt(fields[5]);
					
					//create object and assign values
					Accommodation accom = new Accommodation(name, myType, stars, city, price, rooms);
					//add to array list
					listFromFile.add(accom);
					
				} catch (Exception ex) {
					System.out.println("Bad data, exception caught, skipping line");
					ex.printStackTrace();
				}
				
				line = reader.readLine(); // attempt to read next line
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO update method to read from formatted csv
		// TODO create an Accommodation object for each line of the file and add to
		// rooms list
		// TODO skip any lines which contain data which doesnt match business rules

		System.out.println(listFromFile.size() + " entries read successfully");
		return listFromFile;
	}

	/**
	 * Display prompt and get int user input via static scanner repeat if invalid
	 * input type given - no need to modify this method
	 * 
	 * @return int value entered via scanner
	 */
	private static int getMenuChoice(String prompt) {
		try {
			System.out.println(prompt);
			int choice = scanner.nextInt();
			return choice;
		} catch (Exception e) {
			System.out.println("Invalid input try again");
			// clear buffer if required
			if (scanner.hasNext()) {
				scanner.next();// read and discard line break
			}
			return getMenuChoice(prompt);// return recursive call to method to recover
		}
	}

	/**
	 * Writes menu options to console - no need to modify this method
	 */
	private static void displayOptions() {
		System.out.println();
		System.out.println("Menu Options:");
		System.out.println("1. (Re)read Data From Original File (use to restore removed data for example)");
		System.out.println("2. Display the number of places to stay in the current list");
		System.out.println("3. Display details for all places to stay in the current list");
		System.out.println(
				"4. Display details of the 3 least expensive 4 Star places to stay in Los Angeles (low to high)");
		System.out.println("5. Display the number of cities in the current list");
		System.out.println("6. Display details of the 4 most expensive BnBs in Dublin (high to low)");
		System.out.println("7. Display the average price of a hotel in New York");
		System.out.println("8. Remove all entries with fewer than 10 rooms available for Paris from the current list");
		System.out.println("9. (Separate Thread) Write out to a formatted csv, "
				+ "\nthe name of each city and the average price of a hotel there (2 decimal places, alphabetcically by City name)");
		System.out.println("10. Quit");
	}

}
