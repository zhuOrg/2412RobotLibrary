package com.robototes.units.area;

import com.robototes.units.IUnit;

/**
 * 
 * @author Eli Orona
 * @class A representation of meters in the program.
 */
public class MeterSq extends AreaUnit {

	public static String unit = "MeterSq";

	public MeterSq(double value) {
		super(value);
	}

	public MeterSq() {
		super();
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public String getTextUnit() {
		return "m^2";
	}

	@Override
	public IUnit createInstance() {
		return new MeterSq(0);
	}

	@Override
	public FeetSq toFeetSq() {
		return AreaRatios.metersSqToFeetSq.compute(this);
	}

	@Override
	public InchSq toInchesSq() {
		return AreaRatios.metersSqToInchesSq.compute(this);
	}

	@Override
	public String toString() {
		return getFormattedValue(5) + " " + getTextUnit();
	}

	@Override
	public CentimeterSq toCmSq() {
		return AreaRatios.metersSqToCmSq.compute(this);
	}

	@Override
	public MeterSq toMetersSq() {
		return this;
	}

}
