import java.util.*;

public class stackMain {
	public static char stack[] = new char[100];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int pointer = 0;
		boolean repeatStack = true;
		do {
			int bracket1 = 0;
			int bracket2 = 0;
			int bracket3 = 0;
			boolean wrongInput = false;
			System.out.println("String eingeben!");
			String inputUser = in.next();
			char searchingFor = ' ';
			for (int i = 0; i < inputUser.length(); i++) {
				pointer = i;
				stack[i] = push(inputUser.charAt(i), pointer);
			}
			char charAtPosPointer;
			for (int i = pointer; i >= 0; i--) {
				charAtPosPointer = pull(stack, i);
//				if (searchingFor == ' ') {
//					switch (charAtPosPointer) {
//					case ')':
//						searchingFor = '(';
//						bracket1++;
//						break;
//					case '}':
//						searchingFor = '{';
//						bracket2++;
//						break;
//					case ']':
//						searchingFor = '[';
//						bracket3++;
//						break;
//					case '(':
//						wrongInput = true;
//						break;
//					case '[':
//						wrongInput = true;
//						break;
//					case '{':
//						wrongInput = true;
//						break;
//					}
//
//				} else {
//					switch (charAtPosPointer) {
//					case '(':
//						if (searchingFor == '(') {
//							searchingFor = ' ';
//							stack[i] = ' ';
//							bracket1--;
//						} else {
//							wrongInput = true;
//						}
//						break;
//					case '{':
//						if (searchingFor == '{') {
//							searchingFor = ' ';
//							stack[i] = ' ';
//							bracket2--;
//						} else {
//							wrongInput = true;
//						}
//						break;
//					case '[':
//						if (searchingFor == '[') {
//							searchingFor = ' ';
//							stack[i] = ' ';
//							bracket3--;
//						} else {
//							wrongInput = true;
//						}
//						break;
//					}
//				}
				if (wrongInput == true || (i == 0 && searchingFor != ' ')) {
					System.out.println("Falsche Eingabe!!!");
					break;
				} else if (i == 0) {
					System.out.println("Korrekte Eingabe!");
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
