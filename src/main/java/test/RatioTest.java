package test;

import com.robototes.units.Ratio;
import com.robototes.units.distance.Foot;
import com.robototes.units.distance.Inch;

public class RatioTest {

	public static void main(String[] args) {
		Inch inchTest = new Inch(60);

		Foot feetTest = new Foot(5);

		Ratio<Inch, Foot> inchesToFeet = new Ratio<Inch, Foot>(1d / 12d);
		
		
	}
}
