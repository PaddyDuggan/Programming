package p3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Author Patrick Duggan 40125560
 */

public class WriterThread implements Runnable {
	
	//Attempted to create a Writer Thread which would run a thread using a method call from the Launcher class - 
	//unfortunately i did not have time to complete the Map which was to be plugged into this class
	
	private Map<String, Double> avgCities;
	
	
	

	/**
	 * @param avgCities
	 */
	public WriterThread(Map<String, Double> avgCities) {
		this.avgCities = avgCities;
	}




	@Override
	public void run() {
		
		System.out.println("Thread starting...");
		
		//Map<String, Double> results = Launcher.citiesByAverageHotelCost(newMap);
		
		try {
			File file = new File("averageCosts.csv");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//for loop in here to iterate through map
			
			bw.flush();
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	System.out.println("Thread closing...");
		
	}

}
