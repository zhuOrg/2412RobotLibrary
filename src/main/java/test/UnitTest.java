package test;

import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.UnitRatio;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;
import com.robototes.units.UnitTypes.TimeUnits;

public class UnitTest {
	public static void main(String[] args) {

		// Same unit conversions
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

		// Unit Operations
		Distance distance1 = new Distance(19, DistanceUnits.INCH);
		Distance distance2 = new Distance(3, DistanceUnits.FEET);
		Distance addedDistance = distance1.add(distance2);

		System.out.println(addedDistance.convertTo(DistanceUnits.INCH));

		// Inter Unit Ratios

		InterUnitRatio<RotationUnits, DistanceUnits> rotToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
				RotationUnits.ROTATION, 15, DistanceUnits.INCH);

		InterUnitRatio<DistanceUnits, TimeUnits> inchesToSec = new InterUnitRatio<DistanceUnits, TimeUnits>(
				DistanceUnits.INCH, 5, TimeUnits.SECOND);

		InterUnitRatio<RotationUnits, TimeUnits> rotToSec = new InterUnitRatio<RotationUnits, TimeUnits>(rotToInches,
				inchesToSec);

		System.out.println(rotToInches);
		System.out.println(inchesToSec);
		System.out.println(rotToSec);
	}
}
