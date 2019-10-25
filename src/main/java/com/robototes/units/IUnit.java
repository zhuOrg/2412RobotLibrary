package com.robototes.units;

import com.robototes.units.distance.DistanceUnit;
import com.robototes.units.distance.Meter;

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

	/**
	 * 
	 * @param other Unit to multiply by
	 * @return The two units multiplied, often converted to a default type or basic
	 *         unit
	 */
	public IUnit multiply(IUnit other);

	/**
	 * 
	 * @param other Unit to divide by.
	 * @return The two units divided, often converted to a default type or basic
	 *         unit
	 */
	public IUnit divide(IUnit other);

	public default <T extends IUnit> IUnit toUnit(Class<T> newUnit) {
		try {
			if (newUnit.newInstance().getTextUnit().equals(this.getTextUnit())) {
				return newUnit.newInstance().setValue(this.getValue());
			}
		} catch (Exception e) {

		}
		return null;

	}

}
