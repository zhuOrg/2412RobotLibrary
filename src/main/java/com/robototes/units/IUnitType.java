package com.robototes.units;

public interface IUnitType {
	public String getUnit();

	public <T extends IUnitType> Ratio<T, T> getRatioToDefault();
}
