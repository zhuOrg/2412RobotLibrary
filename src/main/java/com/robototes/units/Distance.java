package com.robototes.units;

import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.IUnitType;

public class Distance implements IUnit<Distance> {

	public double distance;
	public static DistanceUnits mainUnit = DistanceUnits.METER;

	public Distance(double value) {
		this.distance = value;
	}

	public Distance(double value, DistanceUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Distance add(Distance other) {
		return new Distance(this.distance + other.distance);
	}

	@Override
	public Distance subtract(Distance other) {
		return new Distance(this.distance - other.distance);
	}

	@Override
	public Distance multiply(Distance other) {
		return new Distance(this.distance * other.distance);
	}

	@Override
	public Distance divide(Distance other) {
		return new Distance(this.distance / other.distance);
	}

	@Override
	public double getValue() {
		return distance;
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(distance);
	}
}
