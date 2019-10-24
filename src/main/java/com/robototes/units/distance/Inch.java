package com.robototes.units.distance;

import com.robototes.units.IUnit;


/**
 * 
 * @author Eli Orona
 * @class A representation of inches in the program.
 */
public class Inch extends DistanceUnit {

	protected static String unit = "Inch";

	public Inch(double value) {
		super(value);
	}

	public Inch() {
		super();
	}

	@Override
	public Feet toFeet() {
		return DistanceRatios.inchesToFeet.compute(this);
	}

	@Override
	public Inch toInches() {
		return this;
	}

	@Override
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return "in";
	}

	@Override
	public IUnit createInstance() {
		return new Inch(0);
	}

	@Override
	public Centimeter toCm() {
		return DistanceRatios.cmToInches.reverseCompute(this);
	}

	@Override
	public Meter toMeters() {
		return DistanceRatios.metersToInches.reverseCompute(this);
	}
}
