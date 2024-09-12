package p3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Author Patrick Duggan 40125560
 */

class AccomodationTest {

	//test data
	//declare object
	Accommodation accom;
	
	//name test data
	String nameValid, nameInvalid;
	
	//type test data
	Type typeValid, typeInvalid;
	
	//stars test data
	int starsValidLow, starsValidMid, starsValidHigh;
	int starsInvalidLow, starsInvalidHigh;
	
	//city test data
	String cityValid, cityInvalid;
	
	//price test data
	int priceValid, priceInvalid;
	
	//rooms test data
	int roomsValid, roomsInvalid;
	

	@BeforeEach
	void setUp() throws Exception {
		
		accom = new Accommodation();
		
		//name getter/setter test
		nameValid = "a";
		nameInvalid = "";
		
		//type getter/setter test
		typeValid = Type.BNB;
		typeInvalid = null;
		
		//stars getter/setter valid test
		starsValidLow = 1;
		starsValidMid = 3;
		starsValidHigh = 5;
		
		//stars getter/setter invalid test
		starsInvalidLow = 0;
		starsInvalidHigh = 6;
		
		//city getter/setter test
		cityValid = "b";
		cityInvalid = "";
		
		//price getter/setter test
		priceValid = 0;
		priceInvalid = -1;
		
		//rooms getter/setter test
		roomsValid = 0;
		roomsInvalid = -1;
		
		accom = new Accommodation(nameValid, typeValid, starsValidMid, cityValid, priceValid, roomsValid);
		
	}

	@Test
	void testAccomodationConstructorValidArgs() {
		
		accom = new Accommodation(nameValid, typeValid, starsValidMid, cityValid, priceValid, roomsValid);
		
		assertEquals(nameValid, accom.getName());
		assertEquals(typeValid, accom.getType());
		assertEquals(starsValidMid, accom.getStars());
		assertEquals(cityValid, accom.getCity());
		assertEquals(priceValid, accom.getPrice());
		assertEquals(roomsValid, accom.getRooms());
	}
	
	@Test
	void testAccomodationConstructorInvalidArgs() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			accom = new Accommodation(nameInvalid, typeValid, starsValidMid, cityValid, priceValid, roomsValid);
		});
		assertThrows(NullPointerException.class, ()->{
			accom = new Accommodation(nameValid, typeInvalid, starsValidMid, cityValid, priceValid, roomsValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			accom = new Accommodation(nameValid, typeValid, starsInvalidLow, cityValid, priceValid, roomsValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			accom = new Accommodation(nameValid, typeValid, starsValidMid, cityInvalid, priceValid, roomsValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			accom = new Accommodation(nameValid, typeValid, starsValidMid, cityValid, priceInvalid, roomsValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			accom = new Accommodation(nameValid, typeValid, starsValidMid, cityValid, priceValid, roomsInvalid);
		});
		
	}

	@Test
	void testGetSetName() {
		
		accom.setName(nameValid);
		assertEquals(nameValid, accom.getName());
		
	}

	@Test
	void testGetSetType() {
		
		accom.setType(typeValid);
		assertEquals(typeValid, accom.getType());
		
	}

	@Test
	void testGetSetStarsValid() {
		
		accom.setStars(starsValidLow);
		assertEquals(starsValidLow, accom.getStars());
		
		accom.setStars(starsValidMid);
		assertEquals(starsValidMid, accom.getStars());
		
		accom.setStars(starsValidHigh);
		assertEquals(starsValidHigh, accom.getStars());
		
	}
	
	@Test
	void testGetSetStarsInvalid() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			accom.setStars(starsInvalidLow);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			accom.setStars(starsInvalidHigh);
		});
		
	}

	@Test
	void testGetSetCity() {
		
		accom.setCity(cityValid);
		assertEquals(cityValid, accom.getCity());
		
	}

	@Test
	void testGetSetPrice() {
		
		accom.setPrice(priceValid);
		assertEquals(priceValid, accom.getPrice());
		
	}

	@Test
	void testGetSetRooms() {
		
		accom.setRooms(roomsValid);
		assertEquals(roomsValid, accom.getRooms());
		
	}

}
