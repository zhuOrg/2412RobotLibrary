package test;

import com.robototes.units.BasicUnit;
import com.robototes.units.IUnit;
import com.robototes.units.IUnitType;
import com.robototes.units.area.AreaUnit;
import com.robototes.units.area.FeetSq;
import com.robototes.units.distance.DistanceTypes;
import com.robototes.units.distance.Meter;

public class UnitTest {
	public static void main(String[] args) {
//		DistanceUnit inchTest = new Inch(60);
//		DistanceUnit feetTest = new Feet(5);

//		System.out.println(inchTest);
//		System.out.println(feetTest);

		AreaUnit feetSqTest = new FeetSq(25);
		
		IUnitType type = DistanceTypes.CENTIMETER;

//		AreaUnit multiplyTest = (AreaUnit) inchTest.multiply(feetTest);
//		System.out.println(multiplyTest.toFeetSq());
//
//		DistanceUnit divideTest = (DistanceUnit) feetSqTest.divide(feetTest);
//		System.out.println(divideTest.toFeet());
//
//		BasicUnit velocityTest = new BasicUnit(10, "m/s");
//		BasicUnit secondTest = new BasicUnit(10, "s");
//
//		IUnit velTimeMult = velocityTest.multiply(secondTest);
//		IUnit meterFromBasic = velTimeMult.toUnit(Meter.class);
//
//		System.out.println(velTimeMult);
//		System.out.println(meterFromBasic);
	}
}
