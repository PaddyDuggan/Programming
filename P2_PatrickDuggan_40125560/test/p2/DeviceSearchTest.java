package p2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test the device search class
 * @author PatrickDuggan_40125560
 *
 */
class DeviceSearchTest {
	
	//declaring test data
	SmartRadiator r1, r2, r3;
	ArrayList<SmartRadiator> radiators;

	@BeforeEach
	void setUp() throws Exception {
		
		//initialising test data
		
		//populating the array list to be tested
		r1 = new SmartRadiator("Radiator 1", "Philips", Room.BATHROOM, PowerState.ON, -10, 5);
		r2 = new SmartRadiator("Radiator 2", "Dyson", Room.BEDROOM, PowerState.OFF, 30, 10);
		r3 = new SmartRadiator("Radiator 3", "Samsung", Room.KITCHEN, PowerState.ON, 10, 26);
		
		//adding objects to the array list
		radiators = new ArrayList<>();
		radiators.add(r1);
		radiators.add(r2);
		radiators.add(r3);
	}

	/**
	 * Tests the searchByRoom method
	 */
	@Test
	void testSearchByRoom() {
		
		ArrayList<SmartRadiator> searchResults = DeviceSearch.searchByRoom(radiators, Room.BATHROOM);
		
		assertEquals(1, searchResults.size());
		assertTrue(searchResults.contains(r1));
		
	}

	/**
	 * Tests the searchByTemp method
	 */
	@Test
	void testSearchByTemp() {
		
		ArrayList<SmartRadiator> searchResults = DeviceSearch.searchByTemp(radiators, 10, 30);
		
		assertEquals(2, searchResults.size());
		assertTrue(searchResults.contains(r2));
		assertTrue(searchResults.contains(r3));

		
	}

}
