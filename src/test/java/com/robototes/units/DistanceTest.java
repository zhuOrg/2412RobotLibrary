package com.robototes.units;

import static org.junit.Assert.*;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.DistanceUnits;

public class DistanceTest {

	@Test
	public void testAdd() {
		Distance one = new Distance(5);
		Distance two = new Distance(6);
		assertEquals("Add whole distance", one.add(two), new Distance(11));

		Distance three = new Distance(3.5);
		Distance four = new Distance(10, DistanceUnits.CENTIMETER);
		assertEquals("Add two different distances", three.add(four), new Distance(3.6));
	}

	@Test
	public void testConvertTo() {
		Distance oneMeter = new Distance(1);

		double epsilon = 0.00001; // MathUtils.Epsilon is too small for the inaccuracies in conversion

		assertEquals("Meters to cm", oneMeter.convertTo(DistanceUnits.CENTIMETER), 100, epsilon);
		assertEquals("Meters to mm", oneMeter.convertTo(DistanceUnits.MILLIMETER), 1000, epsilon);
		assertEquals("Meters to cm", oneMeter.convertTo(DistanceUnits.KILOMETER), 0.001, epsilon);

		assertEquals("Meters to inches", oneMeter.convertTo(DistanceUnits.INCH), 39.3700787, epsilon);
		assertEquals("Meters to feet", oneMeter.convertTo(DistanceUnits.FEET), 3.2808399, epsilon);
		assertEquals("Meters to yards", oneMeter.convertTo(DistanceUnits.YARD), 1.0936133, epsilon);
		assertEquals("Meters to miles", oneMeter.convertTo(DistanceUnits.MILE), 0.00062137, epsilon);
	}

	@Test
	public void testDistance() {
		Distance d = new Distance(1);
		assertEquals("Distance from meters", d.distance, 1, MathUtils.EPSILON);

		Distance fromCm = new Distance(100, DistanceUnits.CENTIMETER);
		assertEquals("Cm to meters", fromCm, new Distance(1));
		Distance fromMm = new Distance(1000, DistanceUnits.MILLIMETER);
		assertEquals("Mm to meters", fromMm, new Distance(1));
		Distance fromKm = new Distance(0.001, DistanceUnits.KILOMETER);
		assertEquals("Km to meters", fromKm, new Distance(1));

		Distance fromInch = new Distance(39.3700787, DistanceUnits.INCH);
		assertEquals("Inch to meters", fromInch, new Distance(1));
		Distance fromFeet = new Distance(3.2808399, DistanceUnits.FEET);
		assertEquals("Feet to meters", fromFeet, new Distance(1));
		Distance fromYard = new Distance(1.0936133, DistanceUnits.YARD);
		assertEquals("Yard to meters", fromYard, new Distance(1));
		Distance fromMile = new Distance(0.00062137, DistanceUnits.MILE);
		assertEquals("Mile to meters", fromMile, new Distance(1));
	}

	@Test
	public void testDivide() {
		Distance one = new Distance(5);
		Distance scalar = new Distance(2);
		assertEquals("Scale a distance down", one.divide(scalar), new Distance(2.5));
	}

	@Test
	public void testGetValue() {
		Distance one = new Distance(5);
		assertEquals("Get a distance value", one.getValue(), 5, MathUtils.EPSILON);
	}

	@Test
	public void testMultiply() {
		Distance one = new Distance(5);
		Distance scalar = new Distance(2);
		assertEquals("Scale a distance up", one.multiply(scalar), new Distance(10));
	}

	@Test
	public void testSubtract() {
		Distance one = new Distance(6);
		Distance two = new Distance(5);
		assertEquals("Subtract whole distance", one.subtract(two), new Distance(1));

		Distance three = new Distance(3.5);
		Distance four = new Distance(10, DistanceUnits.CENTIMETER);
		assertEquals("Subtract two different distances", three.subtract(four), new Distance(3.4));
	}

	@Test
	public void testToString() {
		Distance one = new Distance(1);
		assertEquals("Simple toString()", one.toString(), "1m");

		Distance two = new Distance(1, DistanceUnits.CENTIMETER);
		assertEquals("Complex toString()", two.toString(), "0.01m");
	}

}
