package com.robototes.math;

import static org.junit.Assert.*;
import static com.robototes.math.MathUtils.*;
import org.junit.Test;

public class MathUtilsTest {

	@Test
	public void testConstrain() {
		double value = 5;
		assertEquals("Constraining a value within range", constrain(value, 0, 10), 5, EPSILON);
		assertEquals("Constraining a vaule out of range", constrain(value, 0, 1), 1, EPSILON);
	}

	@Test
	public void testCube() {
		assertEquals("Cubing a postive value", cube(3), 27, EPSILON);
		assertEquals("Cubing a negative value", cube(-1d / 2d), -1d / 8d, EPSILON);
	}

	@Test
	public void testCubeValues() {
		double[] values = { 1, 2, 3, 4 };
		double[] cubedValues = { 1, 8, 27, 64 };

		assertArrayEquals("Cubing an array of values", cubeValues(values), cubedValues, EPSILON);
	}

	@Test
	public void testDistance() {
		double x = 3;
		double y = 4;
		assertEquals("Simple distance", distance(x, y), 5, EPSILON);

		x = 1;
		y = 1;
		assertEquals("Complex distance", distance(x, y), Math.sqrt(2), EPSILON);

	}

	@Test
	public void testEpsilonEquals() {
		assertTrue("True equals", epsilonEquals(1, 1, EPSILON));
		assertTrue("Close equals", epsilonEquals(1, 1.00000000001, EPSILON));
		assertFalse("Not equal", epsilonEquals(1, 2, EPSILON));
	}

	@Test
	public void testMap() {
		double value = 5;
		assertEquals("Mapping a value within range", map(value, 0, 10, 0, 100), 50, EPSILON);
		assertEquals("Mapping a value outside of the range", map(value, 0, 1, 0, 10), 50, EPSILON);
	}

	@Test
	public void testRunFunction() {
		MathFunction function = i -> 2 * i;
		double[] input = { 1, 2, 3, 4 };
		double[] output = { 2, 4, 6, 8 };
		assertArrayEquals("Running a function", runFunction(input, function), output, EPSILON);
	}

}
