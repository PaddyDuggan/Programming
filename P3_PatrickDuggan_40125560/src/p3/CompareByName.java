package p3;

import java.util.Comparator;

/**
 * Author Patrick Duggan 40125560
 */

public class CompareByName implements Comparator<Accommodation> {

	@Override
	public int compare(Accommodation o1, Accommodation o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
