package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.jvm.bytecode.ArrayLoadInstruction;
import gov.nasa.jpf.jvm.bytecode.ArrayStoreInstruction;
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
	private int counter;
	// To verify if the method invoking the instruction is the "main" method
	private boolean isMainMethod;
	
<<<<<<< HEAD
	/**
	 * Constructor
	 * Initializes private attributes
	 */
	public ArrayListener() {
=======
	//Constructor
	public ArrayListener(){
		//initialization of attributes
>>>>>>> origin/master
		this.counter = 0;
		this.isMainMethod = false;
	}

	/**
	 * Implements methodEntered method form VMListener to listen to main method
	 * call.
	 */
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		//System.out.println(enteredMethod.getName());
		if (enteredMethod.getName().equals("main") ) {
			isMainMethod = true;
		}
	}
	
	/**
	 * Implements executeInstruction method from VMListener to listen to the instructions executed
	 * at byte code level. If these instructions are of type ArrayLoadInstruction or ArrayStoreInstruction class,
	 * they are considered to be a read and/or write.
	 */
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
		if(isMainMethod) {
			if(instructionToExecute instanceof ArrayLoadInstruction || instructionToExecute instanceof ArrayStoreInstruction) {
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
