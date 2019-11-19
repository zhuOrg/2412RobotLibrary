package com.robototes.units;

import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.RotationUnits;

public class Rotations implements IUnit<Rotations> {

	public double rotations;
	public static RotationUnits mainUnit = RotationUnits.DEGREE;

	public Rotations(double value) {
		this.rotations = value;
	}

	public Rotations(double value, RotationUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Rotations add(Rotations other) {
		return new Rotations(this.rotations + other.rotations);
	}

	@Override
	public Rotations subtract(Rotations other) {
		return new Rotations(this.rotations - other.rotations);
	}

	@Override
	public double getValue() {
		return rotations;
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public Rotations divide(Rotations other) {
		return new Rotations(this.rotations / other.rotations);
	}

	@Override
	public Rotations multiply(Rotations other) {
		return new Rotations(this.rotations * other.rotations);

	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(rotations);
	}

}
