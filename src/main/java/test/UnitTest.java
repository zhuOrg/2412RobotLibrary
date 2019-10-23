package test;

import com.robototes.units.distance.Foot;
import com.robototes.units.distance.Inch;

public class UnitTest {
	public static void main(String[] args) {
		Inch inchTest = new Inch(60);

		Foot feetTest = new Foot(5);

		System.out.println(inchTest);
		System.out.println(feetTest.getFormattedValue(1));
	}
}
