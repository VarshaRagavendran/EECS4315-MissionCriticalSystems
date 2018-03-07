
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

/**
 * Native Peer class uses Model Java Interface (MJI), which provides the
 * infrastructure for interaction between JPF and the host JVM.
 * 
 * @author Varsha
 *
 */
public class JPF_java_lang_StrictMath extends NativePeer {

	/**
	 * Returns the cube root of a double value. For positive finite x, cbrt(-x) ==
	 * -cbrt(x); that is, the cube root of a negative value is the negative of the
	 * cube root of that value's magnitude. Special cases: If the argument is NaN,
	 * then the result is NaN. If the argument is infinite, then the result is an
	 * infinity with the same sign as the argument. If the argument is zero, then
	 * the result is a zero with the same sign as the argument.
	 * 
	 * @param a
	 *            - a value
	 * @return - the cube root of a.
	 */
	@MJI
	public double cbrt__D__D(MJIEnv env, int clsObjRef, double a) {
		System.out.println("native peer class");
		return StrictMath.cbrt(a);
	}
}
