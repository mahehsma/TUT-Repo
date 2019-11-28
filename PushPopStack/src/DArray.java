
public class DArray {
	char[] charArray;
	int size;

	DArray(int s) {
		this.size = s;
		charArray = new char[size];
	}

	void set(int pos, char ch) {
		if (pos > size) {
			char[] helpArray = new char[pos + 10];
			for (int i = 0; i < size; i++) {
				helpArray[i] = charArray[i];
			}
			size = pos + 10;
			charArray = helpArray;
		}
		charArray[pos] = ch;
	}

	char get(int pos) {
		if (pos >= size || pos < 0 || charArray[pos] == ' ') {
			return '0';
		} else {
			return charArray[pos];
		}

	}
}
