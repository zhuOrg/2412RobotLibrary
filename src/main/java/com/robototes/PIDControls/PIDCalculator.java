package com.robototes.PIDControls;

import com.robototes.math.MathUtils;

public class PIDCalculator {
	public double errorSum;
	public double pastError;

	public double minOutput = Double.MIN_VALUE;
	public double maxOutput = Double.MAX_VALUE;

	public PIDConstants constants;

	public PIDCalculator(PIDConstants constants) {
		this.constants = constants;
	}

	public PIDConstants getConstants() {
		return this.constants;
	}

	public void setMinMax(double min, double max) {

		if (max < min) {
			throw new IllegalArgumentException("Min cannot be greater than max");
		}

		minOutput = min;
		maxOutput = max;
	}

	public double getOutput(double error, double timestep) {

		double outP = error * constants.getK_P(); // really simple, multiply the error by a set value to get outP

		errorSum += error;
		double outI = errorSum * constants.getK_I();
		errorSum *= constants.getK_IDamp(); // multiply errorSum after calculating outI to not sink the value of outI.
		// dampen the value to make sure that error doesnt build up too much over time

		double deltaError = (error - pastError) / timestep;
		double outD = deltaError * constants.getK_D();

		double output = outP + outI + outD; // sum all the outputs together to get the output value

		output = MathUtils.constrain(output, minOutput, maxOutput); // make sure the output value is within the range of
																	// values

		pastError = error; // set values for the next calculation

		return output;
	}

}
