package test;

import com.robototes.units.Distance;
import com.robototes.units.UnitRatio;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;

public class UnitTest {
	public static void main(String[] args) {
		UnitRatio<Distance> feetToMeters = new UnitRatio<Distance>(DistanceUnits.FEET.getConversionValue(),
				DistanceUnits.FEET, DistanceUnits.METER);
		System.out.println(feetToMeters);

		UnitRatio<Distance> inchToMeters = new UnitRatio<Distance>(DistanceUnits.INCH.getConversionValue(),
				DistanceUnits.INCH, DistanceUnits.METER);
		System.out.println(inchToMeters);

		UnitRatio<Distance> inchToFeet = new UnitRatio<Distance>(inchToMeters, feetToMeters.getInverseRatio());
		System.out.println(inchToFeet);

		UnitRatio<Distance> feetToCm = DistanceUnits.FEET.getRatio(DistanceUnits.CENTIMETER);
		System.out.println(feetToCm);

		Distance distance1 = new Distance(19, DistanceUnits.INCH);
		Distance distance2 = new Distance(3, DistanceUnits.FEET);
		Distance addedDistance = distance1.add(distance2);

		System.out.println(addedDistance.convertTo(DistanceUnits.INCH));

		System.out.println(RotationUnits.RAIDIAN.getRatio());
	}
}
