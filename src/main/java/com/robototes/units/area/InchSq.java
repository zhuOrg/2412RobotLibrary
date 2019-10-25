package com.robototes.units.area;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona
 * @class A representation of inches in the program.
 */
public class InchSq extends AreaUnit {

	protected static String unit = "InchSq";

	public InchSq(double value) {
		super(value);
	}

	public InchSq() {
		super();
	}

	@Override
	public FeetSq toFeetSq() {
		return AreaRatios.inchesSqToFeetSq.compute(this);
	}

	@Override
	public InchSq toInchesSq() {
		return this;
	}

	@Override
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return "in^2";
	}

	@Override
	public IUnit createInstance() {
		return new InchSq(0);
	}

	@Override
	public CentimeterSq toCmSq() {
		return AreaRatios.cmSqToInchesSq.reverseCompute(this);
	}

	@Override
	public MeterSq toMetersSq() {
		return AreaRatios.metersSqToInchesSq.reverseCompute(this);
	}
}
