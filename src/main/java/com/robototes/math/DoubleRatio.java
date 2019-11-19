package com.robototes.math;

import com.robototes.utils.StringUtils;

public class DoubleRatio implements Ratio<Double> {

	public double ratio;
	public String from;
	public String to;

	public DoubleRatio(double ratio, String from, String to) {
		this.ratio = ratio;
		this.from = from;
		this.to = to;
	}

	public DoubleRatio(Ratio<?> firstRatio, Ratio<?> secondRatio) {
		this.ratio = 1d / (firstRatio.getRatio() * secondRatio.getRatio());
		this.from = firstRatio.getFrom();
		this.to = secondRatio.getTo();
	}

	@Override
	public double calculateRatio(Double from) {
		return from * ratio;
	}

	@Override
	public double calculateRatio(double from) {
		return from * ratio;
	}

	@Override
	public double calculateReverseRatio(Double to) {
		return 1d / ratio * to;
	}

	@Override
	public double calculateReverseRatio(double to) {
		return 1d / ratio * to;
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
