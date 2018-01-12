import org.junit.Assert;
import org.junit.Test;

public class BooleanTest {

	// attributes
	
	/**
	 * Testing of attribute TRUE
	 * Description : This field is a Boolean object representing the primitive value true.
	 */
	@Test
	public void testTrueAttribute() {
		Assert.assertEquals(true, lab.Boolean.TRUE.booleanValue());

	}

	// constructor
	
	/**
	 * Testing of Boolean() constructor
	 * Description: Create a Boolean object representing the value of the argument value.
	 */
	@Test
	public void testBoolean() {
		try {
			new lab.Boolean(true);
			new lab.Boolean(false);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	// functions
	
	/**
	 * Testing of booleanValue() method
	 * Return the primitive boolean value of this Boolean object.
	 */
	@Test
	public void testbooleanValue() {
		lab.Boolean b = new lab.Boolean(true);
		Assert.assertEquals(true, b.booleanValue());
		lab.Boolean bool = null;
		Assert.assertNull(bool);
	}

	/**
	 * Testing of compareTo() method to throw exception. 
	 * Method has been written to not throw an exception at random execution
	 * @throws IllegalArgumentException
	 *             - if other is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void compareToException() throws IllegalArgumentException {
		lab.Boolean.TRUE.compareTo(null);
	}

	/**
	 * Testing of compareTo() method to throw no exceptions
	 */
	@Test
	public void compareTo() {
		try {
			int compareResult;

			// 0 if both Booleans represent the same value,
			lab.Boolean one = new lab.Boolean(true);
			lab.Boolean two = new lab.Boolean(true);
			compareResult = one.compareTo(two);
			Assert.assertEquals(0, compareResult);

			// a positive number if this Boolean represents true and the other false,
			two = new lab.Boolean(false);
			compareResult = one.compareTo(two);
			Assert.assertTrue(compareResult > 0);

			// and a negative number if this Boolean represents false and the other true.
			compareResult = two.compareTo(one);
			Assert.assertTrue(compareResult < 0);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
