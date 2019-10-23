package com.robototes.units;

public interface IUnit {
	public double getValue();

	public void setValue(double value);

	public String getUnit();

	/**
	 * 
	 * @param valueLength The number of wanted decimal places (Should be a value
	 *                    above 0)
	 * @return The formatted value of the unit as a string
	 */
	public String getFormattedValue(int valueLength);

	public String getTextUnit();
}
