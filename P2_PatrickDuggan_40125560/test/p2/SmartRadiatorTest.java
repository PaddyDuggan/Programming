package p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class that tests the public methods and getters and setters within the Smart Radiator class
 * @author PatrickDuggan_40125560
 *
 */
class SmartRadiatorTest {
	
	//test data - declaring variables
	SmartRadiator radiator;
	
	//name
	String nameValidLow, nameValidMid, nameValidHigh;
	String nameInvalidLow, nameInvalidHigh;
	
	//manufacturer
	String manufacturerValidLow, manufacturerValidMid, manufacturerValidHigh;
	String manufacturerInvalidLow, manufacturerInvalidHigh;
	
	//tempnow
	double tempnowValidLow, tempnowValidMid, tempnowValidHigh;
	double tempnowInvalidLow, tempnowInvalidHigh;
	
	//temptarget
	double temptargetValidLow, temptargetValidMid, temptargetValidHigh;
	double temptargetInvalidLow, temptargetInvalidHigh;

	@BeforeEach
	void setUp() throws Exception {
		
		//initialising variables before each
		radiator = new SmartRadiator();
		
		//name - valid test data
		nameValidLow = "xxx";
		nameValidMid = "x".repeat(11);
		nameValidHigh = "x".repeat(20);
		
		//name - invalid test data
		nameInvalidLow = "xx";
		nameInvalidHigh = "x".repeat(21);
		
		//manufacturer - valid test data
		manufacturerValidLow = "xxx";
		manufacturerValidMid = "x".repeat(11);
		manufacturerValidHigh = "x".repeat(20);
		
		//manufacturer - invalid test data
		manufacturerInvalidLow = "xx";
		manufacturerInvalidHigh = "x".repeat(21);
		
		//tempnow - valid test data
		tempnowValidLow = -10;
		tempnowValidMid = 10;
		tempnowValidHigh = 30;
		
		//tempnow - invalid test data
		tempnowInvalidLow = -11;
		tempnowInvalidHigh = 31;
		
		//temptarget - valid test data
		temptargetValidLow = 5;
		temptargetValidMid = 16;
		temptargetValidHigh = 26;
		
		//temptarget - invalid test data
		temptargetInvalidLow = 4;
		temptargetInvalidHigh = 27;
		
	}

	/**
	 * Tests  the smart radiator constructor with valid data
	 */
	@Test
	void testSmartRadiatorConstructorValid() {
		
		radiator = new SmartRadiator(nameValidMid, manufacturerValidMid, Room.BATHROOM, PowerState.OFF, tempnowValidMid, temptargetValidMid);
		
		assertEquals(nameValidMid, radiator.getName());
		assertEquals(manufacturerValidMid, radiator.getManufacturer());
		assertEquals(Room.BATHROOM, radiator.getRoom());
		assertEquals(PowerState.OFF, radiator.getPowerState());
		assertEquals(tempnowValidMid, radiator.getTempNow());
		assertEquals(temptargetValidMid, radiator.getTempTarget());
	}
	
	/**
	 * Tests the smart radiator constructor with invalid data
	 */
	@Test
	void testSmartRadiatorConstructorInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator = new SmartRadiator(nameInvalidLow, manufacturerValidMid, Room.BEDROOM, PowerState.ON, tempnowValidMid, temptargetValidMid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator = new SmartRadiator(nameValidMid, manufacturerInvalidLow, Room.BEDROOM, PowerState.ON, tempnowValidMid, temptargetValidMid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator = new SmartRadiator(nameValidMid, manufacturerValidMid, Room.BEDROOM, PowerState.ON, tempnowInvalidLow, temptargetValidMid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator = new SmartRadiator(nameValidMid, manufacturerValidMid, Room.BEDROOM, PowerState.ON, tempnowValidMid, temptargetInvalidLow);
		});
		
	}

	/**
	 * Tests the setters and getters for temp now with valid data
	 */
	@Test
	void testSetGetTempNowValid() {
		
		radiator.setTempNow(tempnowValidLow);
		assertEquals(tempnowValidLow, radiator.getTempNow());
		
		radiator.setTempNow(tempnowValidMid);
		assertEquals(tempnowValidMid, radiator.getTempNow());
		
		radiator.setTempNow(tempnowValidHigh);
		assertEquals(tempnowValidHigh, radiator.getTempNow());
	}
	
	/**
	 * Tests the setter of tempnow with invalid data
	 */
	@Test
	void testSetTempNowInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setTempNow(tempnowInvalidLow);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setTempNow(tempnowInvalidHigh);
		});
		
	}

	/**
	 * Tests the setters and getters for temp target with valid data
	 */
	@Test
	void testSetGetTempTargetValid() {
		
		radiator.setTempTarget(temptargetValidLow);
		assertEquals(temptargetValidLow, radiator.getTempTarget());
		
		radiator.setTempTarget(temptargetValidMid);
		assertEquals(temptargetValidMid, radiator.getTempTarget());
		
		radiator.setTempTarget(temptargetValidHigh);
		assertEquals(temptargetValidHigh, radiator.getTempTarget());
	}
	
	/**
	 * Tests the setter of temp target with invalid data
	 */
	@Test
	void testSetTempTargetInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setTempTarget(temptargetInvalidLow);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setTempTarget(temptargetInvalidHigh);
		});
		
	}

	/**
	 * Tests the status method
	 */
	@Test
	void testStatus() {
		
		radiator = new SmartRadiator("Radiator Stat", "Tado", Room.BEDROOM, PowerState.ON, 18.7, 21.5);
		
		System.out.println(radiator.status());
	}

	/**
	 * Tests the setters and getters of name with valid data
	 */
	@Test
	void testSetGetNameValid() {
		
		radiator.setName(nameValidLow);
		assertEquals(nameValidLow, radiator.getName());
		
		radiator.setName(nameValidMid);
		assertEquals(nameValidMid, radiator.getName());
		
		radiator.setName(nameValidHigh);
		assertEquals(nameValidHigh, radiator.getName());
		
	}
	
	/**
	 * Tests the setter of name with invalid data
	 */
	@Test
	void testSetNameInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setName(nameInvalidLow);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setName(nameInvalidHigh);
		});
		
	}

	/**
	 * Tests the setters and getters of manufacturer with valid data
	 */
	@Test
	void testSetGetManufacturerValid() {
		
		radiator.setManufacturer(manufacturerValidLow);
		assertEquals(manufacturerValidLow, radiator.getManufacturer());
		
		radiator.setManufacturer(manufacturerValidMid);
		assertEquals(manufacturerValidMid, radiator.getManufacturer());
		
		radiator.setManufacturer(manufacturerValidHigh);
		assertEquals(manufacturerValidHigh, radiator.getManufacturer());
		
	}
	
	/**
	 * Tests the setter of manufacturer with invalid data
	 */
	@Test
	void testSetManufacturerInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setManufacturer(manufacturerInvalidLow);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setManufacturer(manufacturerInvalidHigh);
		});
		
	}

	/**
	 * Tests the setters and getters of room with valid data
	 */
	@Test
	void testSetGetRoomValid() {
		
		radiator.setRoom(Room.BATHROOM);
		assertEquals(Room.BATHROOM, radiator.getRoom());
		
		radiator.setRoom(Room.BEDROOM);
		assertEquals(Room.BEDROOM, radiator.getRoom());
		
		radiator.setRoom(Room.HOUSE);
		assertEquals(Room.HOUSE, radiator.getRoom());
		
		radiator.setRoom(Room.KITCHEN);
		assertEquals(Room.KITCHEN, radiator.getRoom());
		
		radiator.setRoom(Room.LOUNGE);
		assertEquals(Room.LOUNGE, radiator.getRoom());
		
	}
	
	/**
	 * Tests the setter of room with invalid data
	 */
	@Test
	void testSetRoomInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setRoom(null);
		});
	}

	/**
	 * Tests the setters and getters or power with valid data
	 */
	@Test
	void testSetGetPowerStateValid() {
		
		radiator.setPowerState(PowerState.OFF);
		assertEquals(PowerState.OFF, radiator.getPowerState());
		
		radiator.setPowerState(PowerState.ON);
		assertEquals(PowerState.ON, radiator.getPowerState());
		
	}
	
	/**
	 * Tests the setter of power with invalid data
	 */
	@Test
	void testSetPowerStateInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			radiator.setPowerState(null);
		});
		
	}

}
