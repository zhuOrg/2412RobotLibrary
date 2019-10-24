package com.robototes.units.distance;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona 
 * @class A representation of meters in the program.
 */
public class Meter extends DistanceUnit {

	public static String unit = "Meter";

	public Meter(double value) {
		super(value);
	}

	public Meter() {
		super();
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return "m";
	}

	@Override
	public IUnit createInstance() {
		return new Meter(0);
	}

	@Override
	public Feet toFeet() {
		return DistanceRatios.metersToFeet.compute(this);
	}

	@Override
	public Inch toInches() {
		return DistanceRatios.metersToInches.compute(this);
	}

	@Override
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public Centimeter toCm() {
		return DistanceRatios.metersToCm.compute(this);
	}

	@Override
	public Meter toMeters() {
		return this;
	}

}
