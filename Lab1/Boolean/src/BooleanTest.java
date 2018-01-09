import org.junit.Assert;
import org.junit.Test;

public class BooleanTest {
		
	// attributes
			/**
			 * This field is a Boolean object representing the primitive value true.
			 */
			@Test
			public void testTrueAttribute() {
				Assert.assertEquals(true, lab.Boolean.TRUE.booleanValue());
			}

			// constructor
			/**
			 * Create a Boolean object representing the value of the argument value.
			 */
			@Test
			public void testBoolean(){
				try {
					new lab.Boolean(true);
					new lab.Boolean(false);
					
				}catch(Exception e) {
					Assert.fail(e.getMessage());
				}
			}

			// functions
			/**
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
			 * Exception thrown by compareTo method
			 * @throws IllegalArgumentException
			 *             - if other is null.
			 */
			@Test(expected=IllegalArgumentException.class)
			public void compareToException() throws IllegalArgumentException {
				lab.Boolean.TRUE.compareTo(null);
			}
			
			/**
		         * Returns 0 if both booleans are of same value;
			 * Returns a positive number if first object is true and second object is false;
			 * Returns a negative number if first object is false and second object is true.
			 */
			@Test
			public void compareTo() {
				try {
					int compareResult;
					
					//0 if both Booleans represent the same value, 
					lab.Boolean one = new lab.Boolean(true);
					lab.Boolean two = new lab.Boolean(true);
					compareResult = one.compareTo(two);
					Assert.assertEquals(0, compareResult);
					
					//a positive number if this Boolean represents true and the other false, 
					two = new lab.Boolean(false);
					compareResult = one.compareTo(two);
					Assert.assertTrue(compareResult > 0);
					
					// and a negative number if this Boolean represents false and the other true.
					compareResult = two.compareTo(one);
					Assert.assertTrue(compareResult < 0);
					
					
					
				}catch(Exception e) {
					Assert.fail(e.getMessage());
				}
			}

}
