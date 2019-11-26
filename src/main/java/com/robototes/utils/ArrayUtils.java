package com.robototes.utils;

import java.util.ArrayList;

public class ArrayUtils {
	@SuppressWarnings("unchecked")
	public static <T> T[] combineArrays(T[] one, T[] two) {
		ArrayList<T> combined = new ArrayList<T>();

		for (T t : one) {
			combined.add(t);
		}

		for (T t : two) {
			combined.add(t);
		}

		return (T[]) combined.toArray();
	}
}
