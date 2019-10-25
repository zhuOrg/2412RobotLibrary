package com.robototes.units.distance;

import com.robototes.units.IUnitType;
import com.robototes.units.Ratio;

public enum DistanceTypes implements IUnitType {
	DEFAULT("", null), //
	METER("m", new Ratio<DistanceTypes, DistanceTypes>(1d, DEFAULT, DEFAULT)),
	CENTIMETER("cm", new Ratio<DistanceTypes, DistanceTypes>(100d, METER, DEFAULT)),
	INCH("in", new Ratio<DistanceTypes, DistanceTypes>(2.54d, CENTIMETER, DEFAULT)),
	FEET("ft", new Ratio<DistanceTypes, DistanceTypes>(1d / 12d, INCH, DEFAULT));

	public final char[] unit;
	public final Ratio<DistanceTypes, DistanceTypes> ratio;

	DistanceTypes(String unit, Ratio<DistanceTypes, DistanceTypes> ratioToDefault) {
		this.unit = unit.toCharArray();
		this.ratio = ratioToDefault;
	}

	@Override
	public String getUnit() {
		return new String(unit);
	}

	@Override
	public <DistanceTypes> Ratio<DistanceTypes, DistanceTypes> getRatioToDefault() {
		return (Ratio<DistanceTypes, DistanceTypes>) ratio;
	}

//	@Override
//	public <T extends IUnitType> Ratio<T, T> getRatioToDefault() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
