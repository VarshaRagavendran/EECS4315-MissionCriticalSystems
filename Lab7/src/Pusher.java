import java.util.Random;

/**
 * Each Pusher object is a Thread that pushes the integers 0, 1, …, 9 onto a
 * stack. The stack is provided as an argument to the constructor of the Pusher
 * class
 * 
 * @author Varsha
 *
 */
public class Pusher extends Thread {
	private Stack stack;

	/**
	 * Initializes this pusher with the given stack.
	 * 
	 * @param stack
	 *            the stack onto which this pusher pushes.
	 */
	public Pusher(Stack stack) {
		super();
		this.stack = stack;
	}

	/**
	 * Pushes integers 0...9 onto a stack.
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.stack.push(i);
		}
	}
}
