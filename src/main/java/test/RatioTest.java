package test;

import com.robototes.units.Ratio;
import com.robototes.units.distance.Centimeter;
import com.robototes.units.distance.Feet;
import com.robototes.units.distance.Inch;

public class RatioTest {

	public static void main(String[] args) {
		Inch inchTest = new Inch(60);

		Feet feetTest = new Feet(5);

		Centimeter cmTest = new Centimeter(10);

		Ratio<Inch, Feet> inchesToFeet = new Ratio<Inch, Feet>(1d / 12d, inchTest, feetTest);

		Ratio<Centimeter, Inch> cmToInches = new Ratio<Centimeter, Inch>(1d / 2.54, cmTest, inchTest);

		Ratio<Centimeter, Feet> cmToFeet = new Ratio<Centimeter, Feet>(cmToInches, inchesToFeet);

		System.out.println(inchesToFeet.compute(inchTest));

		System.out.println(inchesToFeet.reverseCompute(feetTest));

		System.out.println(cmToFeet.compute(cmTest));

		System.out.println(cmToFeet.reverseCompute(feetTest));

		System.out.println("end");

	}
}
