package com.robototes.units.area;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona
 * @class A representation of feet in the program.
 */
public class FeetSq extends AreaUnit {

	protected static String unit = "FeetSq";

	public FeetSq(double value) {
		super(value);
	}

	public FeetSq() {
		super();
	}

	@Override
	public FeetSq toFeetSq() {
		return this;
	}

	@Override
	public InchSq toInchesSq() {
		return AreaRatios.inchesSqToFeetSq.reverseCompute(this);
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
		return "ft^2";
	}

	@Override
	public IUnit createInstance() {
		return new FeetSq(0);
	}

	@Override
	public CentimeterSq toCmSq() {
		return AreaRatios.cmSqToFeetSq.reverseCompute(this);
	}

	@Override
	public MeterSq toMetersSq() {
		return AreaRatios.metersSqToFeetSq.reverseCompute(this);
	}
}
