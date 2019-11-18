package com.robototes.utils;

public class MathUtils {
	public static double constrain(double value, double minValue, double maxValue) {
		return Math.min(Math.max(value, minValue), maxValue);
	}

	public static double map(double value, double minInputValue, double maxInputValue, double minOutputValue,
			double maxOutputValue) {

		return (value - minInputValue) / (maxInputValue - minInputValue) * (maxOutputValue - minOutputValue)
				+ minOutputValue;

	}

	public static double cube(double value) {
		return Math.pow(value, 3);
	}

	public static double[] cubeValues(double[] values) {
		double[] cubedValues = new double[values.length];

		for (int i = 0; i < values.length; i++) {
			double d = values[i];
			cubedValues[i] = cube(d);
		}

		return cubedValues;
	}
}
