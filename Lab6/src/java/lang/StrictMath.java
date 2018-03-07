package java.lang;

/**
 * Model class to capture the behavior of the native method, cbrt(double a), in
 * the StrictMath API, in pure Java.
 * 
 * @author Varsha
 *
 */
public class StrictMath {

	/**
	 * Returns the cube root of a double value. For positive finite x, cbrt(-x) ==
	 * -cbrt(x); that is, the cube root of a negative value is the negative of the
	 * cube root of that value's magnitude. Special cases: If the argument is NaN,
	 * then the result is NaN. If the argument is infinite, then the result is an
	 * infinity with the same sign as the argument. If the argument is zero, then
	 * the result is a zero with the same sign as the argument.
	 * 
	 * @param a - a value
	 * @return - the cube root of a.
	 */
	public static double cbrt(double a) {

		System.out.println("peer class");
		if (Double.isNaN(a)) {
			return Double.NaN;
		} else if (Double.isInfinite(a) || a == 0) {
			return a;
		} else {
			double val = a;
			double update = 0.0;
			while (Math.abs(Math.pow(update, 3) - a) > 0.0000001) {
				//Newton's method is an iterative method that can be used to calculate the cube root.
				update = ((1 / 3.0) * ((a / (Math.pow(val, 2))) + 2 * (val)));
				val = update;
			}
			return update;
		}
	}

}
