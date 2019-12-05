import java.util.*;

public class stackMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean repeatStack = true;
		do {
			DArray dArray = new DArray(10);
			boolean wrongInput = false;
			System.out.println("String eingeben!");
			String inputUser = in.next();
			for (int i = 0; i < inputUser.length(); i++) {

				switch (inputUser.charAt(i)) {
				case '(':
					dArray.set('('); // pushes "("
					break;
				case '[':
					dArray.set('['); // pushes "["
					break;
				case '{':
					dArray.set('{'); // pushes "{"
					break;
				case ')':
					if (dArray.isEmpty == false) {
						if (dArray.get() == '(') { // checks if last item on the stack is "("
							break;
						}
					}
					wrongInput = true;
					break;
				case ']':
					if (dArray.isEmpty == false) {
						if (dArray.get() == '[') { // checks if last item on the stack is "["
							break;
						}
					}
					wrongInput = true;
					break;
				case '}':
					if (dArray.isEmpty == false) {
						if (dArray.get() == '{') { // checks if last item on the stack is "{"
							break;
						}
					}
					wrongInput = true;
					break;
				}
				if (wrongInput == true || (i == (inputUser.length() - 1) && dArray.isEmpty == false)) {
					System.out.println("Falsche Eingabe!!!");
					break;

				} else if (i == (inputUser.length() - 1) && dArray.isEmpty == true) {
					System.out.println("Korrekte Eingabe!");
				}
			}
			System.out.println("\nNochmal\n (1) Ja\n (2) Nein");
			if (in.nextInt() == 2) { // ends program if user wants so
				repeatStack = false;
			}
		} while (repeatStack == true); // let the user rerun the program
		System.out.println("Bis zum nächsten Mal!");
	}

}
