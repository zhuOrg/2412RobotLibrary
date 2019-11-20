package test;

import com.robototes.math.MathUtils;
import com.robototes.math.MathUtils.MathFunction;

public class UtilsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MathUtils.map(10, 5, 15, -10, 0));

		double[] numberTest = { 1, 2, 3 };

		System.out.println(MathUtils.cubeValues(numberTest)[2]);

		MathFunction weirdThing = (i) -> Math.pow(i, 6) * 5.329;

		System.out.println(MathUtils.runFunction(numberTest, weirdThing)[0]);
	}

}
