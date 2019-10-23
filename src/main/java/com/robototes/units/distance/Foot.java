package com.robototes.units.distance;

public class Foot extends DistanceUnit {

	protected static String unit = "Foot";

	public Foot(double value) {
		super(value);
	}

	@Override
	public Foot toFeet() {
		return this;
	}

	@Override
	public Inch toInches() {
		return new Inch(getValue() * 12d);
	}

	@Override
	public String toString() {
		return distance + " " + unit + "/Feet";
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return unit + "/Feet";
	}
}
