import java.util.*;
public class conversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean again = true;       // checks if the user wants do convert again
		boolean againCheck = true;	// checks if the user given an accepted answer
		
		while (again==true) {		// repeats until the user declines it
			againCheck = true;
			int mode = 0;
			System.out.println("Bitte Möglichkeit Wählen: (1) Euro --> Dollar    (2) Dollar --> Euro"); 
			mode = in.nextInt();
			if (mode == 1) { // if the user chooses types in 1 it converts the next number given by the user from EURO in Dollar
				System.out.println("Betrag in Euro eingeben der in Dollar umgerechnet werden soll.");
				Double inputEuro = in.nextDouble();
				Double outDollar = (Double)(inputEuro * 1.11);
				System.out.println(inputEuro + " Euro sind ca " + outDollar + " Dollar.");
			}
			else {
				if(mode == 2) {  // if the user chooses types in 2 it converts the next number given by the user from Dollar in Euro
					System.out.println("Betrag in Dollar eingeben der in Euro umgerechnet werden soll.");
					Double inputDollar = in.nextDouble();
					Double outEuro = (Double)(inputDollar / 1.11);
					System.out.println(inputDollar + " Dollar sind ca " + outEuro + " Euro.");
					
				}
				else {  // if the user types in any number except 1 or 2 the program tells him that the input is wrong
					System.out.println("Eingabe nicht erkannt!");
				}
			}
			while (againCheck == true){ // now the user has to choose whether he wants to do an other conversion or wants to exit the program
				System.out.println("Nochmal? (J/N), (j/n)"); 
				String inAgain = in.next();
				if ((inAgain.charAt(0) == 'J')|| (inAgain.charAt(0) == 'j')){ //every word beginning with "J" or "j" is accepted to rerun the program
					again = true;
					againCheck = false;
				}
				else if ((inAgain.charAt(0) == 'N')|| (inAgain.charAt(0) == 'n')){ //every word beginning with "N" or "n" is accepted to rerun the program
					again = false;
					againCheck = false;
				}
				else {
					System.out.println("Eingabe nicht erkannt!"); // if the user`s input is wrong it asks again until "J","j" or "N","n" is detected
					againCheck = true;
				}
			}
		}
	}
}
