package com.robototes.math;

public interface Ratio<T> {
	public double getRatio();

	public String getFrom();

	public String getTo();

	public double calculateRatio(T from);

	public double calculateRatio(double from);

	public double calculateReverseRatio(T to);

	public double calculateReverseRatio(double to);
}
