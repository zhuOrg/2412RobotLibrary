package com.robototes.units;

import com.robototes.math.Ratio;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

public class InterUnitRatio<K extends IUnitType<?>, V extends IUnitType<?>> implements Ratio<IUnit<?>> {

	public double ratio;
	public String from;
	public String to;

	public K fromType;
	public V toType;

	public InterUnitRatio(K fromType, double ratio, V toType) {
		this.fromType = fromType;
		this.from = fromType.getUnit();
		this.ratio = ratio;
		this.to = toType.getUnit();
		this.toType = toType;
	}

	public <E extends IUnitType<?>> InterUnitRatio(InterUnitRatio<K, E> ratioOne, InterUnitRatio<E, V> ratioTwo) {

		this.from = ratioOne.getFrom();
		this.fromType = ratioOne.fromType;

		this.ratio = (ratioOne.ratio * ratioTwo.ratio);

		this.toType = ratioTwo.toType;
		this.to = ratioTwo.getTo();

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

	@Override
	public double calculateRatio(IUnit<?> from) {
		return ratio * fromType.getRatio().calculateReverseRatio(from);
	}

	@Override
	public double calculateRatio(double from) {
		return ratio * from;
	}

	@Override
	public double calculateReverseRatio(IUnit<?> to) {
		return 1d / ratio * toType.getRatio().calculateReverseRatio(to);
	}

	@Override
	public double calculateReverseRatio(double to) {
		return 1d / ratio * to;
	}

	public String toString() {
		return StringUtils.getFormattedValue(getRatio(), 5) + getFrom() + ":1" + getTo();
	}
}
