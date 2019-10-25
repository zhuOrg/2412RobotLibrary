package test;

import com.robototes.units.area.AreaTypes;
import com.robototes.units.distance.DistanceTypes;
import com.robototes.units.distance.Meter;

public class UnitTest {
	public static void main(String[] args) {

		DistanceTypes[] types = DistanceTypes.values();

		for (DistanceTypes type : types) {
			System.out.println(type.getRatioToDefault());
		}
		
		System.out.println();

		AreaTypes[] atypes = AreaTypes.values();

		for (AreaTypes type : atypes) {
			System.out.println(type.getRatioToDefault());
		}
		
		System.out.println();

		Meter meterFromFeet = new Meter(10, DistanceTypes.FEET);
		System.out.println(meterFromFeet);

		Meter meterFromKm = new Meter(100, DistanceTypes.KILOMETER);
		System.out.println(meterFromKm);

	}
}
