package com.robototes.units.distance;

import com.robototes.units.IUnitType;
import com.robototes.units.Ratio;

public enum DistanceTypes implements IUnitType {

	METER("m"), //
	CENTIMETER("cm", new Ratio<DistanceTypes, DistanceTypes>(1d / 100d, METER, null)),
	INCH("in", new Ratio<DistanceTypes, DistanceTypes>(2.54d, CENTIMETER, null)),
	FEET("ft", new Ratio<DistanceTypes, DistanceTypes>(12d, INCH, null)),
	YARD("yd", new Ratio<DistanceTypes, DistanceTypes>(3d, FEET, null)),
	KILOMETER("km", new Ratio<DistanceTypes, DistanceTypes>(1000d, METER, null)),
	MILLIMETER("mm", new Ratio<DistanceTypes, DistanceTypes>(1d / 10d, CENTIMETER, null));

	public final String unit;
	public Ratio<DistanceTypes, DistanceTypes> ratio;
	public static String mainUnit = Meter.class.getName();

	DistanceTypes(String unit, Ratio<DistanceTypes, DistanceTypes> ratioToDefault) {
		this.unit = unit;
		this.ratio = new Ratio<DistanceTypes, DistanceTypes>(//
				ratioToDefault.getRatioValue() * ratioToDefault.getValueInReference().ratio.getRatioValue(), //
				ratioToDefault.getValueInReference().ratio.getValueInReference(), //
				this);
	}

	DistanceTypes(String unit) {
		this.unit = unit;
		this.ratio = new Ratio<DistanceTypes, DistanceTypes>(1, this, this);
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IUnitType> Ratio<T, T> getRatioToDefault() {
		return (Ratio<T, T>) ratio;
	}

}
