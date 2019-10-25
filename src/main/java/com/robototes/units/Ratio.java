package com.robototes.units;

import com.robototes.utils.StringUtils;

public class Ratio<T extends IUnitType, V extends IUnitType> {

	private double ratioValue;
	private T valueInReference;

	public T getValueInReference() {
		return valueInReference;
	}

	public V getValueOutReference() {
		return valueOutReference;
	}

	private V valueOutReference;

	/**
	 * Creates a new ratio with a value.
	 * 
	 * @param ratioValue The value for the ratio
	 * @param valueIn    An instance of the first class for the ratio.
	 * @param valueOut   An instance of the second class for the ratio.
	 */
	public Ratio(double ratioValue, T valueIn, V valueOut) {
		this.ratioValue = ratioValue;
		this.valueInReference = valueIn;
		this.valueOutReference = valueOut;
	}

	/**
	 * Creates a new ratio based on two other ratios.
	 * 
	 * @param <E> Not used.
	 * @param a   Ratio a
	 * @param b   Ratio b, must have same first unit as a's second unit.
	 */
	public <E extends IUnitType> Ratio(Ratio<T, E> a, Ratio<E, V> b) {
		this.ratioValue = a.getRatioValue() * b.getRatioValue();
		this.valueInReference = a.valueInReference;
		this.valueOutReference = b.valueOutReference;
	}

	/**
	 * 
	 * @param input The unit that with be computed, will be a unit of the first
	 *              UnitType of the ratio.
	 * @return A unit with the second UnitType of the class, with the input having
	 *         been converted
	 */
	public double compute(double input) {
		return ratioValue * input;
	}

	/**
	 * 
	 * @param input The unit that with be computed, will be the second class of the
	 *              ratio.
	 * @return The first unit of the class, with the input having been converted
	 */
	public double reverseCompute(double input) {
		return 1 / ratioValue * input;
	}

	/**
	 * 
	 * @return The value of the ratio.
	 */
	public double getRatioValue() {
		return ratioValue;
	}

	/**
	 * @return A human readable interpretation of the ratio.
	 */
	public String toString() {
		return valueInReference.getUnit() + " to " + valueOutReference.getUnit() + ", "
				+ StringUtils.getFormattedValue(ratioValue, 6) + " " + valueInReference.getUnit() + "/"
				+ valueOutReference.getUnit() + ", " + StringUtils.getFormattedValue(1d / ratioValue, 6) + " "
				+ valueOutReference.getUnit() + "/" + valueInReference.getUnit();
	}

}
