package com.robototes.units;

import static org.junit.Assert.*;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.DistanceUnits;

public class DefaultUnitTest {

	// du is the unit label for DefaultUnit in this test

	@Test
	public void testAdd() {
		DefaultUnit one = new DefaultUnit(5, "du");
		DefaultUnit two = new DefaultUnit(6, "du");
		assertEquals("Add two default units", one.add(two), new DefaultUnit(11, "du"));

		DefaultUnit three = new DefaultUnit(3.5, "du");
		DefaultUnit four = new DefaultUnit(0.1, "du");
		assertEquals("Add two different DefaultUnits", three.add(four), new DefaultUnit(3.6, "du"));
	}

	@Test
	public void testConvertTo() {
		DefaultUnit oneDu = new DefaultUnit(1, "du");

		double epsilon = 0.00001; // MathUtils.Epsilon is too small for the inaccuracies in conversion

		assertEquals("Default unit to cm", oneDu.convertTo(DistanceUnits.CENTIMETER), 100, epsilon);
	}

	@Test
	public void testDefaultUnit() {
		DefaultUnit unit = new DefaultUnit(1, "du");
		assertEquals("Default Unit", unit.value, 1, MathUtils.EPSILON);
	}

	@Test
	public void testDivide() {
		DefaultUnit one = new DefaultUnit(5, "du");
		DefaultUnit scalar = new DefaultUnit(2, "du");
		assertEquals("Scale a DefaultUnit down", one.divide(scalar), new DefaultUnit(2.5, "du"));
	}

	@Test
	public void testGetValue() {
		DefaultUnit one = new DefaultUnit(5, "du");
		assertEquals("Get a DefaultUnit value", one.getValue(), 5, MathUtils.EPSILON);
	}

	@Test
	public void testMultiply() {
		DefaultUnit one = new DefaultUnit(5, "du");
		DefaultUnit scalar = new DefaultUnit(2, "du");
		assertEquals("Scale a DefaultUnit up", one.multiply(scalar), new DefaultUnit(10, "du"));
	}

	@Test
	public void testSubtract() {
		DefaultUnit one = new DefaultUnit(6, "du");
		DefaultUnit two = new DefaultUnit(5, "du");
		assertEquals("Subtract whole DefaultUnit", one.subtract(two), new DefaultUnit(1, "du"));

		DefaultUnit three = new DefaultUnit(3.5, "du");
		DefaultUnit four = new DefaultUnit(.1, "du");
		assertEquals("Subtract two different DefaultUnits", three.subtract(four), new DefaultUnit(3.4, "du"));
	}

	@Test
	public void testToString() {
		DefaultUnit one = new DefaultUnit(1, "du");
		assertEquals("Simple toString()", one.toString(), "1du");
	}

}
