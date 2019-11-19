import java.util.*;

public class stackMain {
	public static char stack[] = new char[100];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int pointer = 0;
		boolean repeatStack = true;
		do {
			boolean wrongInput = false;
			System.out.println("String eingeben!");
			String inputUser = in.next();
			for (int i = 0; i < inputUser.length(); i++) {
				pointer = i;
				stack[i] = push(inputUser.charAt(i), pointer);
			}
			char charAtPosPointer;
			char stackBracket[] = new char[inputUser.length()];
			int pointerBracket = -1;
			for (int i = pointer; i >= 0; i--) {
				charAtPosPointer = pull(stack, i);

				switch (charAtPosPointer) {
				case ')':
					pointerBracket++;
					stackBracket[pointerBracket] = ')';
					break;
				case ']':
					pointerBracket++;
					stackBracket[pointerBracket] = ']';
					break;
				case '}':
					pointerBracket++;
					stackBracket[pointerBracket] = '}';
					break;
				case '(':
					if (pointerBracket != -1) {
						if (stackBracket[pointerBracket] == ')') {
							pointerBracket--;
						}
					} else {
						wrongInput = true;
					}
					break;
				case '[':
					if (pointerBracket != -1) {
						if (stackBracket[pointerBracket] == ']') {
							pointerBracket--;
						}
					} else {
						wrongInput = true;
					}
					break;
				case '{':
					if (pointerBracket != -1) {
						if (stackBracket[pointerBracket] == '}') {
							pointerBracket--;
						}
					} else {
						wrongInput = true;
					}
					break;
				}
				if (i == 0 && pointerBracket == -1) {
					System.out.println("Korrekte Eingabe!");
				} else if (wrongInput == true || (i == 0 && pointerBracket != -1)) {
					System.out.println("Falsche Eingabe!!!");
					break;

				}
			}

			System.out.println("\nNochmal\n (1) Ja\n (2) Nein");
			if (in.nextInt() == 2) {
				repeatStack = false;
			}
		} while (repeatStack == true);
	}

	public static char push(char input, int pointer) {
		stack[pointer] = input;
		return stack[pointer];
	}

	public static char pull(char stack[], int pointer) {
		char charAtPosPointer = stack[pointer];
		stack[pointer] = ' ';
		return charAtPosPointer;
	}

}
