package com.robototes.units;

import static org.junit.Assert.*;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.RotationUnits;

public class RotationsTest {

	@Test
	public void testRotations() {
		Rotations r = new Rotations(1);
		assertEquals("Rotations from rot", r.rotations, 1, MathUtils.EPSILON);

		Rotations fromRadian = new Rotations(2 * Math.PI, RotationUnits.RADIAN);
		assertEquals("rad to rot", fromRadian, new Rotations(1));
		Rotations fromDegrees = new Rotations(360, RotationUnits.DEGREE);
		assertEquals("deg to rot", fromDegrees, new Rotations(1));
	}

	@Test
	public void testAdd() {
		Rotations one = new Rotations(5);
		Rotations two = new Rotations(6);
		assertEquals("Add whole Rotations", one.add(two), new Rotations(11));

		Rotations three = new Rotations(3.5);
		Rotations four = new Rotations(36, RotationUnits.DEGREE);
		assertEquals("Add two different Rotations", three.add(four), new Rotations(3.6));
	}

	@Test
	public void testSubtract() {
		Rotations one = new Rotations(6);
		Rotations two = new Rotations(5);
		assertEquals("Subtract whole Rotations", one.subtract(two), new Rotations(1));

		Rotations three = new Rotations(3.5);
		Rotations four = new Rotations(36, RotationUnits.DEGREE);
		assertEquals("Subtract two different Rotations", three.subtract(four), new Rotations(3.4));
	}

	@Test
	public void testMultiply() {
		Rotations one = new Rotations(5);
		Rotations scalar = new Rotations(2);
		assertEquals("Scale a Rotations up", one.multiply(scalar), new Rotations(10));
	}

	@Test
	public void testDivide() {
		Rotations one = new Rotations(5);
		Rotations scalar = new Rotations(2);
		assertEquals("Scale a Rotations down", one.divide(scalar), new Rotations(2.5));
	}

	@Test
	public void testGetValue() {
		Rotations one = new Rotations(5);
		assertEquals("Get a Rotations value", one.getValue(), 5, MathUtils.EPSILON);
	}

	@Test
	public void testConvertTo() {
		Rotations oneMeter = new Rotations(1);

		double epsilon = 0.00001; // MathUtils.Epsilon is too small for the inaccuracies in conversion

		assertEquals("rot to rad", oneMeter.convertTo(RotationUnits.RADIAN), 2 * Math.PI, epsilon);
		assertEquals("rot to deg", oneMeter.convertTo(RotationUnits.DEGREE), 360, epsilon);
	}

	@Test
	public void testToString() {
		Rotations one = new Rotations(1);
		assertEquals("Simple toString()", one.toString(), "1rot");

		Rotations two = new Rotations(36, RotationUnits.DEGREE);
		assertEquals("Complex toString()", two.toString(), "0.1rot");
	}

}
