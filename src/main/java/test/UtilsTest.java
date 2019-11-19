package test;

import com.robototes.utils.MathUtils;

public class UtilsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MathUtils.map(10, 5, 15, 0, 10));

		double[] cubeTest = { 1, 2, 3 };

		System.out.println(MathUtils.cubeValues(cubeTest)[2]);

	}

}
