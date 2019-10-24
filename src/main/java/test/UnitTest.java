package test;

import com.robototes.units.distance.Feet;
import com.robototes.units.distance.Inch;

public class UnitTest {
	public static void main(String[] args) {
		Inch inchTest = new Inch(60);

		Feet feetTest = new Feet(5);

		System.out.println(inchTest);
		System.out.println(feetTest.getFormattedValue(1));
	}
}
