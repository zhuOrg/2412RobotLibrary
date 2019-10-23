package com.robototes.units;

public class Ratio<T extends IUnit, V extends IUnit> {

	private double ratioValue;
	
	public Ratio(double ratioValue) {
		this.ratioValue = ratioValue;
	}
	
	public V compute(T input) {
		return null;
	}
	
	public T reverseCompute(V input) {
		return null;
		
	}

}
