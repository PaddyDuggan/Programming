/**
 * 
 */
package p2;

import java.util.ArrayList;

/**
 * Search class that supports searching within the system
 * @author PatrickDuggan_40125560
 *
 */
public class DeviceSearch {

	/**
	 * Search method that takes in an array list and a specific room, compares them and returns an array list that matched the search criteria
	 * @param radiators
	 * @param room
	 * @return - array list of results
	 */
	public static ArrayList<SmartRadiator> searchByRoom(ArrayList<SmartRadiator> radiators, Room room) {

		ArrayList<SmartRadiator> searchResults = new ArrayList<>();

		for (SmartRadiator radiator : radiators) {
			if (radiator.getRoom() == room) {
				searchResults.add(radiator);
			}
		}

		return searchResults;

	}

	/**
	 * Search method that takes in an array list and two temperatures and returns an arraylist of all radiators that fall within that specified range
	 * @param radiators
	 * @param tempLower
	 * @param tempUpper
	 * @return array list of results
	 */
	public static ArrayList<SmartRadiator> searchByTemp(ArrayList<SmartRadiator> radiators, double tempLower, double tempUpper) {

		ArrayList<SmartRadiator> searchResults = new ArrayList<>();

		for (SmartRadiator radiator : radiators) {
			if(radiator.getTempNow()>=tempLower && radiator.getTempNow()<=tempUpper) {
				searchResults.add(radiator);
			}
		}
		return searchResults;

	}

}
