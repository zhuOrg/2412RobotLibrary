package com.robototes.units;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

public class DefaultUnit implements IUnit<DefaultUnit> {

	public double value;
	public String unit;

	public DefaultUnit(double value, String unit) {
		this.value = value;
		this.unit = unit;
	}

	@Override
	public DefaultUnit add(DefaultUnit other) {
		return new DefaultUnit(this.value + other.value, this.unit);
	}

	@Override
	public DefaultUnit subtract(DefaultUnit other) {
		return new DefaultUnit(this.value - other.value, this.unit);
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public DefaultUnit divide(DefaultUnit other) {
		return new DefaultUnit(this.value / other.value, this.unit);
	}

	@Override
	public DefaultUnit multiply(DefaultUnit other) {
		return new DefaultUnit(this.value * other.value, this.unit);
	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(value);
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + this.getUnit();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IUnit<?>)) {
			return false;
		}
		return equals((IUnit<?>) obj);
	}

	public boolean equals(IUnit<?> other) {
		return MathUtils.epsilonEquals(value, other.getValue(), 0.00001) && this.unit.equals(other.getUnit());
		// Epsilion is too big with conversion values
	}

}
