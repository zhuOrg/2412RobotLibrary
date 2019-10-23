package com.robototes;

import java.text.DecimalFormat;

public class CommonFunctions {

	public static String repeatString(String string, int repeats) {
		String returnString = "";

		for (int i = 0; i < repeats; i++) {
			returnString += string;
		}

		return returnString;
	}

	/**
	 * 
	 * @param valueLength The number of wanted decimal places (Should be a value
	 *                    above 0)
	 * @return A formatted value as a string
	 */
	public static String getFormattedValue(double value, int valueLength) {

		DecimalFormat formatter = new DecimalFormat("#." + CommonFunctions.repeatString("#", valueLength));

		return formatter.format(value);
	}
}
