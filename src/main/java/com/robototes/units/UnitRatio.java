package com.robototes.units;

import com.robototes.math.Ratio;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

public class UnitRatio<T extends IUnit<?>> implements Ratio<IUnit<?>> {

	public double ratio;
	public String from;
	public String to;

	public <K extends IUnitType<?>> UnitRatio(double ratio, IUnitType<K> from, IUnitType<K> to) {
		this.ratio = ratio;
		this.from = from.getUnit();
		this.to = to.getUnit();
	}

	public UnitRatio(double ratio, String from, String to) {
		this.ratio = ratio;
		this.from = from;
		this.to = to;
	}

	public UnitRatio(UnitRatio<?> firstRatio, UnitRatio<?> secondRatio) {
		this.ratio = 1d / (firstRatio.ratio * secondRatio.ratio);
		this.from = firstRatio.from;
		this.to = secondRatio.to;
	}

	public double calculateRatio(IUnit<?> from) {
		return from.getValue() * ratio;
	}

	public double calculateRatio(double from) {
		return from * ratio;
	}

	public double calculateReverseRatio(IUnit<?> to) {
		return to.getValue() * (1d / ratio);
	}

	public double calculateReverseRatio(double to) {
		return to * (1d / ratio);
	}

	public UnitRatio<T> getInverseRatio() {
		return new UnitRatio<T>(1d / ratio, to, from);
	}

	@Override
	public double getRatio() {
		return ratio;
	}

	@Override
	public String getFrom() {
		return from;
	}

	@Override
	public String getTo() {
		return to;
	}

	public String toString() {
		return StringUtils.getFormattedValue(getRatio(), 5) + getFrom() + ":1" + getTo();
	}
}
