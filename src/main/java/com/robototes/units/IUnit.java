package com.robototes.units;

/**
 * 
 * @author Eli Orona
 * @class An interface all units use.
 */
public interface IUnit {

	/**
	 * 
	 * @return The value of the unit as a double.
	 */
	public double getValue();

	/**
	 * 
	 * @param value Sets the value of the unit to this new value.
	 * @return The unit.
	 */
	public IUnit setValue(double value);

	/**
	 * 
	 * @return the name of the class, can be used as a unit in most cases.
	 */
	public String getUnit();

	/**
	 * 
	 * @param valueLength The number of wanted decimal places (Should be a value
	 *                    above 0)
	 * @return The formatted value of the unit as a string
	 */
	public String getFormattedValue(int valueLength);

	/**
	 * 
	 * @return A text value of a unit, often how it would be written
	 */
	public String getTextUnit();

	/**
	 * 
	 * @return A new instance of a unit, can be useful in some places.
	 */
	public IUnit createInstance();
}
