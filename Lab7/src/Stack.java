/**
 * A stack. It stores integers.
 * 
 * @author Varsha
 *
 */
public class Stack {
	private int[] content;
	private int size;

	/*
	 * The maximal number of integers that can be stored in a stack.
	 */
	private final static int CAPACITY = 5;

	private boolean isLocked;

	/**
	 * Initializes this stack to be empty.
	 */
	public Stack() {
		this.content = new int[Stack.CAPACITY];
		this.size = 0;
	}

	/**
	 * Pushes the given integer onto this stack.
	 *
	 * @param value
	 *            the integer to be pushed onto this stack.
	 */
	public synchronized void push(int value) {
		this.beginPush();
		this.content[this.size] = value;
		this.size++;
		System.out.printf("Push %d\n", value);
		this.endPush();
	}

	private synchronized void beginPush() {
		while (this.size >= Stack.CAPACITY || this.isLocked) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isLocked = true;
	}

	private synchronized void endPush() {
		this.isLocked = false;
		this.notifyAll();
	}

	/**
	 * Pops the top of this stack and returns the integer.
	 *
	 * @return the top of this stack.
	 */
	public synchronized int pop() {
		this.beginPop();
		this.size--;
		int value = this.content[this.size];
		System.out.printf("Pop %d\n", value);
		this.endPop();
		return value;
	}

	private synchronized void beginPop() {
		while (this.size == 0 || this.isLocked) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isLocked = true;
	}

	private synchronized void endPop() {
		this.isLocked = false;
		this.notifyAll();
	}

}