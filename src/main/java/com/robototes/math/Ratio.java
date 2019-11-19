package com.robototes.math;

public interface Ratio<T> {

	/**
	 * 
	 * @return The double value of the ratio
	 */
	public double getRatio();

	/**
	 * 
	 * @return The label of the from
	 */
	public String getFrom();

	/**
	 * 
	 * @return label of the to
	 */
	public String getTo();

	/**
	 * 
	 * @param from
	 * @return
	 */
	public double calculateRatio(T from);

	/**
	 * 
	 * @param from
	 * @return
	 */
	public double calculateRatio(double from);

	/**
	 * 
	 * @param to
	 * @return
	 */
	public double calculateReverseRatio(T to);

	/**
	 * 
	 * @param to
	 * @return
	 */
	public double calculateReverseRatio(double to);
}
