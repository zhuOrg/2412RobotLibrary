package com.robototes.units.distance;

import com.robototes.CommonFunctions;
import com.robototes.units.IUnit;
import com.robototes.units.Ratio;

/**
 * 
 * @author Eli Orona
 * @class An abstract class that represents distance in the program.
 */
public abstract class DistanceUnit implements IUnit {
	protected double distance;

	protected static String unit;

	/**
	 * 
	 * @param value The distance the DistanceUnit starts out with.
	 */
	public DistanceUnit(double value) {
		distance = value;
	}

	/**
	 * A constructor that returns a DistanceUnit with a distance of 0.
	 */
	public DistanceUnit() {
		this.distance = 0;
	}

	@Override
	public DistanceUnit setValue(double value) {
		this.distance = value;
		return this;
	}

	@Override
	public double getValue() {
		return this.distance;
	}

	@Override
	public String getFormattedValue(int valueLength) {
		return CommonFunctions.getFormattedValue(distance, valueLength);
	}

	/**
	 * 
	 * @return The unit converted to Feet
	 */
	public abstract Feet toFeet();

	/**
	 * 
	 * @return The unit converted to Inches
	 */
	public abstract Inch toInches();

	/**
	 * 
	 * @return The unit converted to Centimeters
	 */
	public abstract Centimeter toCm();

	/**
	 * 
	 * @return The unit converted to Meters
	 */
	public abstract Meter toMeters();

	/**
	 * 
	 * @return
	 * @return The unit in a string value
	 */
	public abstract String toString();

	/**
	 * @class A class full of common distance ratios.
	 * @author Eli Orona
	 * 
	 */
	public static class DistanceRatios {
		public static Ratio<Inch, Feet> inchesToFeet = new Ratio<Inch, Feet>(1d / 12d, new Inch(), new Feet());

		public static Ratio<Centimeter, Inch> cmToInches = new Ratio<Centimeter, Inch>(1d / 2.54, new Centimeter(),
				new Inch());

		public static Ratio<Meter, Centimeter> metersToCm = new Ratio<Meter, Centimeter>(1 / 100d, new Meter(),
				new Centimeter());

		public static Ratio<Centimeter, Feet> cmToFeet = new Ratio<Centimeter, Feet>(cmToInches, inchesToFeet);

		public static Ratio<Meter, Feet> metersToFeet = new Ratio<Meter, Feet>(metersToCm, cmToFeet);

		public static Ratio<Meter, Inch> metersToInches = new Ratio<Meter, Inch>(metersToCm, cmToInches);
	}

}
