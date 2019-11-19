package com.robototes.units;

import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.TimeUnits;

public class Time implements IUnit<Time> {

	public double time;
	public static TimeUnits mainUnit = TimeUnits.SECOND;

	public Time(double value) {
		this.time = value;
	}

	public Time(double value, TimeUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Time add(Time other) {
		return new Time(this.time + other.time);
	}

	@Override
	public Time subtract(Time other) {
		return new Time(this.time - other.time);
	}

	@Override
	public double getValue() {
		return time;
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public Time divide(Time other) {
		return new Time(this.time / other.time);
	}

	@Override
	public Time multiply(Time other) {
		return new Time(this.time * other.time);

	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(time);
	}

}
