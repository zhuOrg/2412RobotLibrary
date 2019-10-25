package test;

import com.robototes.units.distance.Centimeter;
import com.robototes.units.distance.DistanceUnit.DistanceRatios;
import com.robototes.units.distance.Feet;
import com.robototes.units.distance.Inch;

public class RatioTest {

	public static void main(String[] args) {
		Inch inchTest = new Inch(60);
		Feet feetTest = new Feet(5);
		Centimeter cmTest = new Centimeter(10);

		System.out.println(DistanceRatios.inchesToFeet.compute(inchTest));
		System.out.println(DistanceRatios.inchesToFeet.reverseCompute(feetTest));
		System.out.println(DistanceRatios.cmToFeet.compute(cmTest));
		System.out.println(DistanceRatios.cmToFeet.reverseCompute(feetTest));
		System.out.println(DistanceRatios.cmToFeet);
		
		System.out.println(inchTest.getClass().getSuperclass().getName());
	}
}
