package com.robototes.units.distance;

public class Inch extends DistanceUnit {

	protected static String unit = "Inch";

	public Inch(double value) {
		super(value);
	}

	@Override
	public Foot toFeet() {
		return new Foot(getValue() / 12d);
	}

	@Override
	public Inch toInches() {
		return this;
	}

	@Override
	public String toString() {
		return distance + " " + unit + "(es)";
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return unit + "(es)";
	}
}
