package com.robototes.units;

import com.robototes.utils.StringUtils;

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
		return StringUtils.getFormattedValue(value, valueLength);
	}

	@Override
	public String getTextUnit() {
		return unit;
	}

	@Override
	public IUnit createInstance() {
		return new BasicUnit(0, unit);
	}

	@Override
	public IUnit multiply(IUnit other) {
		return new BasicUnit(this.getValue() * other.getValue(), this.getUnit()+"*"+other.getUnit());
	}

	@Override
	public IUnit divide(IUnit other) {
		return new BasicUnit(this.getValue() / other.getValue(), this.getUnit()+"*("+other.getUnit()+")^-1");
	}

}
