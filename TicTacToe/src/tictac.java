import java.util.*;

public class tictac {

	private static int[] grid = new int[9]; // 0= unused, 1= used by PC, 3= used by Player
	private static int fieldPC; // where PC wants to place his next "X"
	// private static boolean win; // if player or PC9 has won
	private static int fillToWin = 2; // field to use in a row to win Player/PC

	public static void main(String[] args) {
		resetgame();
		newgame();
	}

	public static void resetgame() {// resets the game to start values
		for (int k = 0; k < 9; k++) {
			grid[k] = 0;
		}
	}

	public static void pcchoose() {
		if ((grid[0] + grid[1] + grid[2]) == fillToWin) { // checks first if 2 fields in one row are used by PC
			for (int i = 0; i < 3; i++) { // checks second if 2 fields in one row are used by Player
				if (grid[i] == 0) { // here: first horizontal row
					fieldPC = i;
				}
			}
		} else if ((grid[3] + grid[4] + grid[5]) == fillToWin) { // here: second horizontal row
			for (int i = 0; i < 3; i++) {
				if (grid[i + 3] == 0) {
					fieldPC = i + 3;
				}
			}
		} else if ((grid[6] + grid[7] + grid[8]) == fillToWin) { // here: third horizontal row
			for (int i = 0; i < 3; i++) {
				if (grid[i + 6] == 0) {
					fieldPC = i + 6;
				}
			}
		} else if ((grid[0] + grid[3] + grid[6]) == fillToWin) { // here: first vertical column
			for (int i = 0; i < 3; i++) {
				if (grid[i * 3] == 0) {
					fieldPC = i * 3;
				}
			}
		} else if ((grid[1] + grid[4] + grid[7]) == fillToWin) { // here: second vertical column
			for (int i = 0; i < 3; i++) {
				if (grid[i * 3 + 1] == 0) {
					fieldPC = i * 3 + 1;
				}
			}
		} else if ((grid[2] + grid[5] + grid[8]) == fillToWin) { // here: third vertical column
			for (int i = 0; i < 3; i++) {
				if (grid[i * 3 + 2] == 0) {
					fieldPC = i * 3 + 2;
				}
			}
		} else if ((grid[0] + grid[4] + grid[8]) == fillToWin) { // here: diagonal from top left
			for (int i = 0; i < 3; i++) {
				if (grid[i * 4] == 0) {
					fieldPC = i * 4;
				}
			}
		} else if ((grid[2] + grid[4] + grid[6]) == fillToWin) { // here: diagonal from top right
			for (int i = 0; i < 3; i++) {
				if (grid[6 - 2 * i] == 0) {
					fieldPC = 6 - 2 * i;
				}
			}
		} else if (fillToWin == 2) { // if PC can´t win in the next move, it will check if the player can
			fillToWin = 6;
			pcchoose();
		} else { // if neither PC or player can win, PC chooses randomly
			do {
				fieldPC = (int) (Math.round((Math.random() * 8)));
			} while (grid[fieldPC] != 0);
		}
		grid[fieldPC] = 1;
	}

	public static boolean wincheck() {
		for (int i = 0; i < 2; i++) { // x=1 : checks if PC has won, x=3 :checks if Player has won
			int winInt = i * 2 + 1;
			if ((grid[0] == winInt && grid[1] == winInt && grid[2] == winInt)
					|| (grid[3] == winInt && grid[4] == winInt && grid[5] == winInt)
					|| (grid[6] == winInt && grid[7] == winInt && grid[8] == winInt)
					|| (grid[0] == winInt && grid[3] == winInt && grid[6] == winInt)
					|| (grid[1] == winInt && grid[4] == winInt && grid[7] == winInt)
					|| (grid[2] == winInt && grid[5] == winInt && grid[8] == winInt)
					|| (grid[0] == winInt && grid[4] == winInt && grid[8] == winInt)
					|| (grid[2] == winInt && grid[4] == winInt && grid[6] == winInt)) {
				return true;
			}
		}
		return false;
	}

	public static void gridcreate() { // creates the grid, blanks if unused, X for PC, O for Player/User
		String[] XO = new String[9]; // equals grid but contains blanks, X and O instead of 0,1,3
		for (int i = 0; i < 9; i++) {
			if (grid[i] == 1) {
				XO[i] = "X";
			} else if (grid[i] == 3) {
				XO[i] = "O";
			} else {
				XO[i] = " ";
			}
		}
		System.out.println("[" + XO[0] + "] [" + XO[1] + "] [" + XO[2] + "]" + "\n\n[" + XO[3] + "] [" + XO[4] + "] ["
				+ XO[5] + "]" + "\n\n[" + XO[6] + "] [" + XO[7] + "] [" + XO[8] + "]");
	}

	public static void newgame() {
		int inputPlayer;
		boolean pcOrPlayer = true; // true: PCs turn, false: Players turn
		Scanner in = new Scanner(System.in);
		System.out.println("Willkommen zu TicTacToe! \n " + "(1) Soll der PC beginnen? \n "
				+ "(2) Willst du beginnen? \n " + "(3) Zufällig?");
		while (!in.hasNextInt()) {
			in.next();
			System.out.println("Eingabe nicht erkannt!");
		}
		inputPlayer = in.nextInt();

		if (inputPlayer == 1) { // player starts
			pcOrPlayer = true;
			System.out.println("PC beginnt!");
		} else if (inputPlayer == 2) { // PC starts
			pcOrPlayer = false;
			System.out.println("Spieler beginnt!");
		} else {
			System.out.println("Zufällige Eingabe!");
			if (Math.round(Math.random()) == 0) { // gives the number 1 or 0, 0: PC starts, 1: Player starts
				pcOrPlayer = true;
				System.out.println("PC beginnt!");
			} else {
				pcOrPlayer = false;
				System.out.println("Spieler beginnt!");
			}
		}
		for (int i = 0; i < 9; i++) { // repeats the game max. 9 times
			if (pcOrPlayer == true) {
				fillToWin = 2; // the sum of fields has to be 2 that the PC can fill the missing one to win
				pcchoose();
				System.out.println("PC setzt!");
				pcOrPlayer = false;
			} else {
				System.out.println("Welches Feld möchtest du wählen?(0-8)");
				do {
					while (!in.hasNextInt()) {
						in.next();
						System.out.println("Eingabe nicht erkannt!");
					}
					inputPlayer = in.nextInt();
					if (grid[inputPlayer] != 0) {
						System.out.println("Feld ist bereits belegt!\nBitte wähle ein anderes!");
					}
				} while (grid[inputPlayer] != 0); // Player has to choose an empty field
				grid[inputPlayer] = 3;
				pcOrPlayer = true;
			}
			gridcreate();
			boolean haswon = wincheck();
			if (haswon == true) {
				if (pcOrPlayer == false) {
					System.out.println("Der Pc hat gewonnen!");
				} else {
					System.out.println("Der Spieler hat gewonnen!");
				}
				break;
			}
			if (i == 8 && haswon == false) { // checks if all fields are used but nobody has won
				System.out.println("Unentschieden!");
				break;
			}
		}
		System.out.println("(1) Nochmal Spielen?\n(2) Aufhören?");
		if (in.nextInt() == 1) {
			resetgame();
			newgame();
		}
		System.out.println("Bis zum nächsten Mal!");
	}

}
