/**
 * This class only contains a main method. In the main method, a number of
 * Popper and Pusher objects are created (for example, 10 Poppers and 5 Pushers)
 * and all these Threads are run concurrently.
 * 
 * @author Varsha
 *
 */
public class Main {
	public static void main(String[] args) {
		Stack stack = new Stack();
		final int PUSHERS = 5;
		final int POPPERS = 10;

		/*
		 * for (int i = 0; i < PUSHERS; i++) { Pusher pusher = new Pusher(stack);
		 * pusher.start(); }
		 */

		/*
		 * for (int i = 0; i < POPPERS; i++) { Popper popper = new Popper(stack);
		 * popper.start(); }
		 */

		for (int i = 0; i < PUSHERS; i++) {
			Pusher pusher = new Pusher(stack);
			pusher.start();
			Popper popper = new Popper(stack);
			popper.start();
		}
	}
}