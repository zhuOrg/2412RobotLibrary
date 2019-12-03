package com.robototes.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testGetFormattedValue() {
		double value = Math.PI;
		assertEquals("Formatting a value to a certain length", StringUtils.getFormattedValue(value, 5), "3.14159");
	}

	@Test
	public void testRepeatString() {
		String base = "hi";
		assertEquals("Repeating a base String", StringUtils.repeatString(base, 3), "hihihihi");
	}

}
