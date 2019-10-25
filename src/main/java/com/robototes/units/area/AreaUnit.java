package com.robototes.units.area;

import com.robototes.units.BasicUnit;
import com.robototes.units.distance.DistanceUnit;
import com.robototes.units.distance.Meter;
import com.robototes.units.IUnit;
import com.robototes.units.Ratio;
import com.robototes.utils.StringUtils;

/**
 * 
 * @author Eli Orona
 * @class An abstract class that represents area in the program.
 */
public abstract class AreaUnit implements IUnit {
	protected double area;

	protected static String unit;

	/**
	 * 
	 * @param value The distance the AreaUnit starts out with.
	 */
	public AreaUnit(double value) {
		area = value;
	}

	/**
	 * A constructor that returns an AreaUnit with a distance of 0.
	 */
	public AreaUnit() {
		this.area = 0;
	}

	@Override
	public AreaUnit setValue(double value) {
		this.area = value;
		return this;
	}

	@Override
	public double getValue() {
		return this.area;
	}

	@Override
	public String getFormattedValue(int valueLength) {
		return StringUtils.getFormattedValue(area, valueLength);
	}

	@Override
	public IUnit multiply(IUnit other) {

		if (other.getClass().getSuperclass().getTypeName().equals("com.robototes.units.area.AreaUnit")) {
			return new BasicUnit(this.toMetersSq().getValue() * ((AreaUnit) other).toMetersSq().getValue(), "m^4");
		} else if (other.getClass().getSuperclass().getTypeName().equals("com.robototes.units.distance.DistanceUnit")) {
			return new BasicUnit(this.toMetersSq().getValue() * ((DistanceUnit) other).toMeters().getValue(), "m^3");
		}

		return null;
	}

	@Override
	public IUnit divide(IUnit other) {
		if (other.getClass().getSuperclass().getTypeName().equals("com.robototes.units.area.AreaUnit")) {
			return new BasicUnit(this.toMetersSq().getValue() / ((AreaUnit) other).toMetersSq().getValue(), "");
		} else if (other.getClass().getSuperclass().getTypeName().equals("com.robototes.units.distance.DistanceUnit")) {
			return new Meter(this.toMetersSq().getValue() / ((DistanceUnit) other).toMeters().getValue());
		}

		return null;
	}

	/**
	 * 
	 * @return The unit converted to Square Feet
	 */
	public abstract FeetSq toFeetSq();

	/**
	 * 
	 * @return The unit converted to Square Inches
	 */
	public abstract InchSq toInchesSq();

	/**
	 * 
	 * @return The unit converted to Square Centimeters
	 */
	public abstract CentimeterSq toCmSq();

	/**
	 * 
	 * @return The unit converted to Square Meters
	 */
	public abstract MeterSq toMetersSq();

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
	public static class AreaRatios {
		public static Ratio<InchSq, FeetSq> inchesSqToFeetSq = new Ratio<InchSq, FeetSq>(1d / (12d * 12d), new InchSq(),
				new FeetSq());

		public static Ratio<CentimeterSq, InchSq> cmSqToInchesSq = new Ratio<CentimeterSq, InchSq>(1d / (2.54 * 2.54),
				new CentimeterSq(), new InchSq());

		public static Ratio<MeterSq, CentimeterSq> metersSqToCmSq = new Ratio<MeterSq, CentimeterSq>((100d * 100d) / 1d,
				new MeterSq(), new CentimeterSq());

		public static Ratio<CentimeterSq, FeetSq> cmSqToFeetSq = new Ratio<CentimeterSq, FeetSq>(cmSqToInchesSq,
				inchesSqToFeetSq);

		public static Ratio<MeterSq, FeetSq> metersSqToFeetSq = new Ratio<MeterSq, FeetSq>(metersSqToCmSq,
				cmSqToFeetSq);

		public static Ratio<MeterSq, InchSq> metersSqToInchesSq = new Ratio<MeterSq, InchSq>(metersSqToCmSq,
				cmSqToInchesSq);
	}

}
