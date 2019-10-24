package com.robototes.units.distance;

import com.robototes.units.IUnit;


/**
 * 
 * @author Eli Orona
 * @class A representation of feet in the program.
 */
public class Feet extends DistanceUnit {

	protected static String unit = "Feet";

	public Feet(double value) {
		super(value);
	}

	public Feet() {
		super();
	}

	@Override
	public Feet toFeet() {
		return this;
	}

	@Override
	public Inch toInches() {
		return DistanceRatios.inchesToFeet.reverseCompute(this);
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
		return "ft";
	}

	@Override
	public IUnit createInstance() {
		return new Feet(0);
	}

	@Override
	public Centimeter toCm() {
		return DistanceRatios.cmToFeet.reverseCompute(this);
	}

	@Override
	public Meter toMeters() {
		return DistanceRatios.metersToFeet.reverseCompute(this);
	}
}
