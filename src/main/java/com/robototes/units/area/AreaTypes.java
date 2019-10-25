package com.robototes.units.area;

import com.robototes.units.IUnitType;
import com.robototes.units.Ratio;

public enum AreaTypes implements IUnitType {
	SQUAREMETER("m^2"), //
	SQUARECENTIMETER("cm^2", new Ratio<AreaTypes, AreaTypes>((1d / 100d) * (1d / 100d), SQUAREMETER, null)),
	SQUAREINCH("in^2", new Ratio<AreaTypes, AreaTypes>(2.54d * 2.54d, SQUARECENTIMETER, null)),
	SQUAREFEET("ft^2", new Ratio<AreaTypes, AreaTypes>(12d * 12d, SQUAREINCH, null)),
	SQUAREYARD("yd^2", new Ratio<AreaTypes, AreaTypes>(3d * 3d, SQUAREFEET, null)),
	SQUAREKILOMETER("km^2", new Ratio<AreaTypes, AreaTypes>(1000d * 1000d, SQUAREMETER, null)),
	SQUAREMILLIMETER("mm^2", new Ratio<AreaTypes, AreaTypes>((1d / 10d) * (1d / 10d), SQUARECENTIMETER, null));

	public final char[] unit;
	public Ratio<AreaTypes, AreaTypes> ratio;

	AreaTypes(String unit, Ratio<AreaTypes, AreaTypes> ratioToDefault) {
		this.unit = unit.toCharArray();
		this.ratio = new Ratio<AreaTypes, AreaTypes>(//
				ratioToDefault.getRatioValue() * ratioToDefault.getValueInReference().ratio.getRatioValue(), //
				ratioToDefault.getValueInReference().ratio.getValueInReference(), //
				this);
	}

	AreaTypes(String unit) {
		this.unit = unit.toCharArray();
		this.ratio = new Ratio<AreaTypes, AreaTypes>(1, this, this);
	}

	@Override
	public String getUnit() {
		return new String(unit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IUnitType> Ratio<T, T> getRatioToDefault() {
		return (Ratio<T, T>) ratio;
	}

}
