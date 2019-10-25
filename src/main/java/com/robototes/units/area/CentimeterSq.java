package com.robototes.units.area;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona
 * @class A representation of centimeters in the program.
 */
public class CentimeterSq extends AreaUnit {

	public static String unit = "CentimeterSq";

	public CentimeterSq(double value) {
		super(value);
	}

	public CentimeterSq() {
		super();
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return "cm^2";
	}

	@Override
	public IUnit createInstance() {
		return new CentimeterSq(0);
	}

	@Override
	public FeetSq toFeetSq() {
		return AreaRatios.cmSqToFeetSq.compute(this);
	}

	@Override
	public InchSq toInchesSq() {
		return AreaRatios.cmSqToInchesSq.compute(this);
	}

	@Override
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public CentimeterSq toCmSq() {
		return this;
	}

	@Override
	public MeterSq toMetersSq() {
		return AreaRatios.metersSqToCmSq.reverseCompute(this);
	}

}
