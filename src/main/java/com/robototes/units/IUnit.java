package com.robototes.units;

import com.robototes.math.Operable;
import com.robototes.units.UnitTypes.IUnitType;

public interface IUnit<T extends IUnit<?>> extends Operable<T> {
	public double getValue();

	public String getUnit();

	/**
	 * @apiNote NOTE: WILL RETURN A UNIT EVEN THOUGH IT SHOULD BE A SCALAR. TREAT AS
	 *          DIVIDING BY A SCALAR.
	 */
	T divide(T other);

	/**
	 * @apiNote NOTE: WILL NOT RETURN A SQUARE UNIT EVEN THOUGH IT SHOULD. TREAT AS
	 *          MULTIPLYING BY SCALAR.
	 */
	T multiply(T other);

	/**
	 * 
	 * @param <K>      UnitType of the unit
	 * @param unitType New unit type
	 * @return value of the unit converted to the new unit.
	 */
	<K extends IUnitType<K>> double convertTo(K unitType);
}
