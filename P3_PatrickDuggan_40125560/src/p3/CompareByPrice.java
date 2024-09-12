package p3;

import java.util.Comparator;

/**
 * Author Patrick Duggan 40125560
 */

public class CompareByPrice implements Comparator<Accommodation> {

	@Override
	public int compare(Accommodation o1, Accommodation o2) {
		return o2.getPrice() - o1.getPrice();
	}

}
