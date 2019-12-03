package com.robototes.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterpolatingDoubleTest {

	@Test
	public void testAdd() {
		InterpolatingDouble one = new InterpolatingDouble(5d);
		InterpolatingDouble two = new InterpolatingDouble(2d);

		assertEquals("Add", one.add(two), new InterpolatingDouble(7d));
	}

	@Test
	public void testCompareTo() {
		InterpolatingDouble one = new InterpolatingDouble(5d);
		InterpolatingDouble two = new InterpolatingDouble(4d);

		assertTrue("Comparing a smaller value to a larger value", one.compareTo(two) > 0);
		assertTrue("Comparing a larger value to a smaller value", two.compareTo(one) < 0);

		two = new InterpolatingDouble(5d);
		assertTrue("Comparing two equal values", one.compareTo(two) == 0);
	}

	@Test
	public void testDivide() {
		InterpolatingDouble one = new InterpolatingDouble(5d);
		InterpolatingDouble two = new InterpolatingDouble(2d);

		assertEquals("Divide", one.divide(two), new InterpolatingDouble(2.5d));
	}

	@Test
	public void testInterpolate() {
		InterpolatingDouble one = new InterpolatingDouble(0d);
		InterpolatingDouble two = new InterpolatingDouble(10d);

		assertEquals("Interpolate", one.interpolate(two, 0.5d), new InterpolatingDouble(5d));
	}

	@Test
	public void testInverseInterpolate() {
		InterpolatingDouble one = new InterpolatingDouble(0d);
		InterpolatingDouble two = new InterpolatingDouble(10d);
		InterpolatingDouble three = new InterpolatingDouble(5d);

		assertEquals("Inverse interpolate", one.inverseInterpolate(two, three), 0.5d, MathUtils.EPSILON);
	}

	@Test
	public void testMultiply() {
		InterpolatingDouble one = new InterpolatingDouble(5d);
		InterpolatingDouble two = new InterpolatingDouble(2d);

		assertEquals("Multiply", one.multiply(two), new InterpolatingDouble(10d));
	}

	@Test
	public void testSubtract() {
		InterpolatingDouble one = new InterpolatingDouble(5d);
		InterpolatingDouble two = new InterpolatingDouble(2d);

		assertEquals("Subtract", one.subtract(two), new InterpolatingDouble(3d));
	}

}
