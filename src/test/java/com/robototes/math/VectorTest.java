package com.robototes.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class VectorTest {

	@Test
	public void testVectorAdd() {
		Vector one = new Vector(1, 1);
		Vector two = new Vector(0, 1);

		assertEquals("Adding two vectors", one.add(two), new Vector(1, 2));
		assertEquals("Subtracting two vectors", one.sub(two), new Vector(1, 0));

		assertEquals("Adding two values to a vector", one.add(0, 1), new Vector(1, 2));
		assertEquals("Subtracting two values from a vector", one.sub(0, 1), new Vector(1, 0));
	}

	@Test
	public void testVectorScale() {
		Vector one = new Vector(1, 1);
		assertEquals("Scaling a vector up", one.multiply(5), new Vector(5, 5));

		Vector two = new Vector(1, 1);
		assertEquals("Scaling a vector down", two.divide(5), new Vector(0.2, 0.2));
	}

	@Test
	public void testVectorDot() {
		Vector one = new Vector(2, 1);
		Vector two = new Vector(1, 2);

		assertEquals("Dot product of two vectors", one.dot(two), 4, MathUtils.EPSILON);
	}

	@Test
	public void testAngleBetween() {
		Vector one = new Vector(1, 0);
		Vector two = new Vector(0, 1);

		assertEquals("Angle between two vectors", one.angleBetween(two), Math.PI / 2, MathUtils.EPSILON);

		Vector three = new Vector(-1, 0);

		assertEquals("Angle between two opposite vectors", one.angleBetween(three), Math.PI, MathUtils.EPSILON);
	}

	@Test
	public void testConstructors() {
		Vector one = new Vector(3, 4);
		assertEquals("Length of vector", one.length, 5, MathUtils.EPSILON);

		Vector two = new Vector(0);
		assertEquals("Vector from angle", two, new Vector(1, 0));

		Vector three = new Vector(Math.PI / 4);
		assertEquals("Vector from complex angle", three, new Vector(1 / Math.sqrt(2), 1 / Math.sqrt(2)));
	}

}
