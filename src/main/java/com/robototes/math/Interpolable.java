package com.robototes.math;

public interface Interpolable<T> {
	/**
	 * Interpolates between two values with a given percentage.
	 * 
	 * @param other Value to interpolate
	 * @param t     Percent of interpolation
	 * @return Interpolated value.
	 */
	T interpolate(T other, double t);
}
