package com.robototes.units.distance;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona
 * @class A representation of meters in the program.
 */
public class Meter implements IUnit {

	private double value;
	public static String unit = "Meter";

	public Meter(double value) {
		this.value = 0;
	}

	public Meter() {
		this(0);
	}

	public Meter(double value, DistanceTypes type) {
		this.value = type.ratio.compute(value);
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
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public IUnit setValue(double value) {
		this.value = value;
		return this;
	}

}
