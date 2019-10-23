package com.robototes.units.distance;

import com.robototes.CommonFunctions;
import com.robototes.units.IUnit;

public abstract class DistanceUnit implements IUnit {
	protected double distance;

	protected static String unit;

	public DistanceUnit(double value) {
		distance = value;
	}

	@Override
	public void setValue(double value) {
		this.distance = value;
	}

	@Override
	public double getValue() {
		return this.distance;
	}

	@Override
	public String getFormattedValue(int valueLength) {
		return CommonFunctions.getFormattedValue(distance, valueLength) + " " + getTextUnit();
	}

	/**
	 * 
	 * @return The unit converted to Feet
	 */
	public abstract Foot toFeet();

	/**
	 * 
	 * @return The unit converted to Inches
	 */
	public abstract Inch toInches();

	/**
	 * 
	 * @return
	 * @return The unit in a string value
	 */
	public String toString() {
		return "";
	}

}
