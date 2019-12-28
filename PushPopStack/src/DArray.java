
public class DArray {
	private char[] charArray;
	private int sizeStack;
	private int pointer = 0;
	boolean isEmpty = true;

	DArray(int s) { // constructor creates array (length 10)
		this.sizeStack = s;
		charArray = new char[sizeStack];
	}

	void set(char bracket) {
		if (pointer >= sizeStack) { // checks if the stack size is too small
			char[] helpArray = new char[pointer + 10]; // increases stack size by 10
			for (int i = 0; i < sizeStack; i++) {
				helpArray[i] = charArray[i];
			}
			sizeStack = pointer + 10;
			charArray = helpArray; // changes reference from helpArray to charArray
		}
		charArray[pointer] = bracket; // pushes input (bracket) at the position of pointer
		pointer++;
		isEmpty = false;
	}

	char get() {
		pointer--;
		if (pointer == 0) {
			isEmpty = true;
		}
		if (pointer < 0) {
			return '0';
		} else {
			return charArray[pointer]; //returns the bracket at position pointer
		}

	}
}
