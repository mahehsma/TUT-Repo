
public class DArray {
	private char[] charArray;
	private int size;
	private int pointer=0;
	boolean isEmpty=true;

	DArray(int s) { //constructor creates array (length 10)
		this.size = s;
		charArray = new char[size];
	}

	void set(char ch) {
		if (pointer >= size) { //checks if the stack size is too small
			char[] helpArray = new char[pointer + 10]; //increases stack size by 10
			for (int i = 0; i < size; i++) {
				helpArray[i] = charArray[i];
			}
			size = pointer + 10;
			charArray = helpArray;
		}
		charArray[pointer] = ch; //pushes input (ch) at the position of pointer
		pointer++;
		isEmpty=false;
	}

	char get() {
		pointer--;
		if (pointer==0) {
			isEmpty=true;
		}
		if (pointer < 0 ) {
			return '0';
		} else {
			return charArray[pointer];
		}

	}
}
