package com.robototes.units;

import static org.junit.Assert.*;

import org.junit.Test;

import com.robototes.math.MathUtils;
import com.robototes.units.UnitTypes.VoltageUnits;
import com.robototes.units.UsefulUnits.Voltage;

public class VoltageTest {

	@Test
	public void testVoltage() {
		Voltage r = new Voltage(1);
		assertEquals("Voltage from volt", r.voltage, 1, MathUtils.EPSILON);

		Voltage fromMILLIVOLTS = new Voltage(1000, VoltageUnits.MILLIVOLTS);
		assertEquals("mV to volt", fromMILLIVOLTS, new Voltage(1));
		Voltage fromKILOVOLTSs = new Voltage(0.001, VoltageUnits.KILOVOLTS);
		assertEquals("kV to volt", fromKILOVOLTSs, new Voltage(1));
	}

	@Test
	public void testAdd() {
		Voltage one = new Voltage(5);
		Voltage two = new Voltage(6);
		assertEquals("Add whole Voltage", one.add(two), new Voltage(11));

		Voltage three = new Voltage(3.5);
		Voltage four = new Voltage(10, VoltageUnits.MILLIVOLTS);
		assertEquals("Add two different Voltage", three.add(four), new Voltage(3.51));
	}

	@Test
	public void testSubtract() {
		Voltage one = new Voltage(6);
		Voltage two = new Voltage(5);
		assertEquals("Subtract whole Voltage", one.subtract(two), new Voltage(1));

		Voltage three = new Voltage(3.5);
		Voltage four = new Voltage(10, VoltageUnits.MILLIVOLTS);
		assertEquals("Subtract two different Voltage", three.subtract(four), new Voltage(3.49));
	}

	@Test
	public void testMultiply() {
		Voltage one = new Voltage(5);
		Voltage scalar = new Voltage(2);
		assertEquals("Scale a Voltage up", one.multiply(scalar), new Voltage(10));
	}

	@Test
	public void testDivide() {
		Voltage one = new Voltage(5);
		Voltage scalar = new Voltage(2);
		assertEquals("Scale a Voltage down", one.divide(scalar), new Voltage(2.5));
	}

	@Test
	public void testGetValue() {
		Voltage one = new Voltage(5);
		assertEquals("Get a Voltage value", one.getValue(), 5, MathUtils.EPSILON);
	}

	@Test
	public void testConvertTo() {
		Voltage oneMeter = new Voltage(1);

		double epsilon = 0.00001; // MathUtils.Epsilon is too small for the inaccuracies in conversion

		assertEquals("volt to mV", oneMeter.convertTo(VoltageUnits.MILLIVOLTS), 1000, epsilon);
		assertEquals("volt to kV", oneMeter.convertTo(VoltageUnits.KILOVOLTS), 0.001, epsilon);
	}

	@Test
	public void testToString() {
		Voltage one = new Voltage(1);
		assertEquals("Simple toString()", one.toString(), "1V");

		Voltage two = new Voltage(1, VoltageUnits.KILOVOLTS);
		assertEquals("Complex toString()", two.toString(), "1000V");
	}

}
