package com.robototes.units.distance;

import com.robototes.units.IUnit;


/**
 * 
 * @author Eli Orona
 * @class A representation of centimeters in the program.
 */
public class Centimeter extends DistanceUnit {

	public static String unit = "Centimeter";

	public Centimeter(double value) {
		super(value);
	}

	public Centimeter() {
		super();
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return "cm";
	}

	@Override
	public IUnit createInstance() {
		return new Centimeter(0);
	}

	@Override
	public Feet toFeet() {
		return DistanceRatios.cmToFeet.compute(this);
	}

	@Override
	public Inch toInches() {
		return DistanceRatios.cmToInches.compute(this);
	}

	@Override
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public Centimeter toCm() {
		return this;
	}

	@Override
	public Meter toMeters() {
		return DistanceRatios.metersToCm.reverseCompute(this);
	}

}
