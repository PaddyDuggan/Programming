package p3;

import java.awt.desktop.PrintFilesEvent;
import java.util.Objects;

/**
 * Author Patrick Duggan 40125560
 */

public class Accommodation {
	
	/**
	 * Constants to represent business rules
	 */
	public static final int MIN_NAME_LENGTH = 1;
	public static final int MIN_STARS = 1;
	public static final int MAX_STARS = 5;
	public static final int MIN_CITY_LENGTH = 1;
	public static final int MIN_PRICE = 0;
	public static final int MIN_ROOMS = 0;
	
	/**
	 * Declaring variables for the Accommodation
	 */
	private String name;
	private Type type;
	private int stars;
	private String city;
	private int price;
	private int rooms;
	
	/**
	 * Default constructor
	 */
	public Accommodation() {
		
	}
	
	/** Constructor which takes args to create an Accommodation object
	 * @param name
	 * @param type
	 * @param stars
	 * @param city
	 * @param price
	 * @param rooms
	 */
	public Accommodation(String name, Type type, int stars, String city, int price, int rooms) {
		this.setName(name);
		this.setType(type);
		this.setStars(stars);
		this.setCity(city);
		this.setPrice(price);
		this.setRooms(rooms);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) throws IllegalArgumentException {
		
		if(name.length() >= MIN_NAME_LENGTH && !name.isEmpty()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Invalid name");
		}
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) throws NullPointerException{
		
		if(type.equals(Type.BNB) || type.equals(Type.HOSTEL) || type.equals(Type.HOTEL)) {
			this.type = type;
		} else {
			throw new NullPointerException("Invalid type");
		}
	}
	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}
	/**
	 * @param stars the stars to set
	 */
	public void setStars(int stars) throws IllegalArgumentException{
		
		if(stars >= MIN_STARS && stars <= MAX_STARS) {
			this.stars = stars;
		} else {
			throw new IllegalArgumentException("Invalid stars");
		}
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) throws IllegalArgumentException {
		
		if(city.length() >= MIN_CITY_LENGTH && !city.isEmpty()) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("Invalid city");
		}
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) throws IllegalArgumentException {
		
		if(price >= MIN_PRICE) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("Invalid price");
		}
	}
	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return rooms;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(int rooms) throws IllegalArgumentException  {
		
		if(rooms >= MIN_ROOMS) {
			this.rooms = rooms;
		} else {
			throw new IllegalArgumentException("Invalid rooms");
		}
	}
	
	/**
	 * Method to print details for each Accomodation object
	 */
	public void printDetails() {
		System.out.printf("%-10s %-10s \n%-10s %-10s \n%-10s %-10s \n%-10s%s %s %s %s%s\n%-10s %-10s\n", "Name:", name, 
				"City:", city, "Type:", type, "Capacity:",rooms, "Rooms", "@","$",price, "Rating:","*".repeat(getStars()));
		System.out.println();
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, name, price, rooms, stars, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accommodation other = (Accommodation) obj;
		return Objects.equals(city, other.city) && Objects.equals(name, other.name) && price == other.price
				&& rooms == other.rooms && stars == other.stars && type == other.type;
	}
	
	

}
