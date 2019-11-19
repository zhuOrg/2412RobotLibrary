package com.robototes.math;

import static java.lang.Math.*;

public class MathUtils {
	public static double constrain(double value, double minValue, double maxValue) {
		return min(max(value, minValue), maxValue);
	}

	public static double map(double value, double minInputValue, double maxInputValue, double minOutputValue,
			double maxOutputValue) {

		return (value - minInputValue) / (maxInputValue - minInputValue) * (maxOutputValue - minOutputValue)
				+ minOutputValue;

	}

	public static double cube(double value) {
		return cube.compute(value);
	}

	public static double[] cubeValues(double[] values) {
		return runFunction(values, cube);
	}

	public static double[] runFunction(double[] input, MathFunction function) {
		double[] output = new double[input.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = function.compute(input[i]);
		}
		return output;
	}

	public static interface MathFunction {
		public double compute(double i);
	}

	private static MathFunction cube = (i) -> pow(i, 3);

	public static double distance(double... values) {
		double total = 0;
		for (double value : values) {
			total += pow(value, 2);
		}
		return sqrt(total);
	}
}
