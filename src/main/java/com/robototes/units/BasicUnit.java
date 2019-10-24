package com.robototes.units;

import com.robototes.CommonFunctions;

public class BasicUnit implements IUnit {

	private double value;

	private String unit;

	public BasicUnit(double value, String unit) {
		this.value = value;
		this.unit = unit;
	}

	@Override
	public BasicUnit setValue(double value) {
		this.value = value;
		return this;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getUnit() {
		return unit;
	}

	/**
	 * 
	 * @return
	 * @return The unit in a string value
	 */
	public String toString() {
		return value + " " + unit;
	}

	@Override
	public String getFormattedValue(int valueLength) {
		return CommonFunctions.getFormattedValue(value, valueLength);
	}

	@Override
	public String getTextUnit() {
		return unit;
	}

	@Override
	public IUnit createInstance() {
		return new BasicUnit(0, unit);
	}

}
