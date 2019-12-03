package com.robototes;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobototesLibraryTest {

	@Test
	public void testGetVersion() {
		assertEquals("Get current version of library", "0.1", RobototesLibrary.getVersion());
	}

}
