package com.robototes.units.area;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona
 * @class A representation of meters in the program.
 */
public class SquareMeter implements IUnit {

	private double value;
	public static String unit = "SquareMeter";

	public SquareMeter(double value) {
		this.value = 0;
	}

	public SquareMeter() {
		this(0);
	}

	public SquareMeter(double value, AreaTypes type) {
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
		return new SquareMeter(0);
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
