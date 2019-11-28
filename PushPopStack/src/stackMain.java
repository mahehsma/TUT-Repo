import java.util.*;

public class stackMain {
	public static char stack[] = new char[1];
	public static int pointer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean repeatStack = true;
		do {
			DArray dArray = new DArray(10);
			boolean wrongInput = false;
			System.out.println("String eingeben!");
			String inputUser = in.next();
			pointer = 0;
			for (int i = inputUser.length() - 1; i >= 0; i--) {

				switch (inputUser.charAt(i)) {
				case ')':
					dArray.set(pointer, inputUser.charAt(i));
					pointer++;
					break;
				case ']':
					dArray.set(pointer, inputUser.charAt(i));
					pointer++;
					break;
				case '}':
					dArray.set(pointer, inputUser.charAt(i));
					pointer++;
					break;
				case '(':
					if (pointer != 0) {
						if (dArray.get(pointer - 1) == ')') {
							dArray.set(pointer - 1, ' ');
							pointer--;
							break;
						}
					}
					wrongInput = true;
					break;
				case '[':
					if (pointer != 0) {
						if (dArray.get(pointer - 1) == ']') {
							dArray.set(pointer - 1, ' ');
							pointer--;
							break;
						}
					}
					wrongInput = true;
					break;
				case '{':
					if (pointer != 0) {
						if (dArray.get(pointer - 1) == '}') {
							dArray.set(pointer - 1, ' ');
							pointer--;
							break;
						}
					}
					wrongInput = true;
					break;
				}
				if (wrongInput == true || (i == 0 && pointer != 0)) {
					System.out.println("Falsche Eingabe!!!");
					break;

				} else if (i == 0 && pointer == 0) {
					System.out.println("Korrekte Eingabe!");
				}
			}
			System.out.println("\nNochmal\n (1) Ja\n (2) Nein");
			if (in.nextInt() == 2) {
				repeatStack = false;
			}
		} while (repeatStack == true);
	}

}
