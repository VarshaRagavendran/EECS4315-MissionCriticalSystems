package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;

/**
 * ArrayListener counts the number of reads and writes of array cells within the
 * main method of ArraySample. Uses both of JPF-CORE listeners VMListener and
 * SearchListener via ListenerAdapter
 * 
 * @author Varsha
 *
 */
public class ArrayListener extends ListenerAdapter {

	// To keep count of # of reads and writes
	private int counter = 0;

	/**
	 * Implements methodEntered method form VMListener to listen to main method
	 * call. Checks Instructions executed in bytecode level for reads/writes.
	 */
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		if (enteredMethod.getName().equals("main")) {
			for (Instruction i : enteredMethod.getInstructions()) {
				// iaload - Retrieves an entry from a int array and places it on the stack.
				// iastore - Takes an int from the stack and stores it in an array of ints.
				if (i.getMnemonic().equals("iastore") || i.getMnemonic().equals("iaload"))
					this.counter++;
			}
		}
	}

	/**
	 * Implements searchFinished method from SearchListener to listen to when the
	 * state is finished. Prints to console the # of read/write instructions
	 * executed.
	 */
	public void searchFinished(Search search) {
		System.out.println("*****");
		System.out.println("Total number of reads and writes of array cells: " + this.counter);
		System.out.println("*****");
	}

}
