import java.util.*;
public class tictac {
	
	private static int[] grid = new int[9]; // 0= unused, 1= used by PC, 3= used by Player
	private static String[] XO = new String[9]; // equals grid but contains blanks, X and O instead of 0,1,2
	private static int fieldPC;
	private static int inputPlayer;
	private static boolean pcOrPlayer= true; //true: PCs turn, false: Players turn
	private static Scanner in = new Scanner(System.in);
	private static int[] win = new int[2];
	private static int fillToWin = 2; 
	
	public static void main(String[] args) {	
		resetgame();
		newgame();	
	}
	
	public static void resetgame() {//resets the game to start values
		for(int k=0; k<9; k++) {
			grid[k]=0;
			XO[k]=" ";
			win[0]=0;
			win[1]=0;
		}
	}
	
	public static void pcchoose() {
		if ((grid[0]+grid[1]+grid[2])==fillToWin) {	//tries first to check if 2 fields in one row are used by PC
			for (int i=0; i< 3; i++) {				//tries second to check if 2 fields in one row are used by Player
				if (grid[i]==0 ) {
					fieldPC=i;
				}
			}
		}
		else if ((grid[3]+grid[4]+grid[5])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[i+3]==0 ) {
					fieldPC=i+3;
				}
			}
		}
		else if ((grid[6]+grid[7]+grid[8])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[i+6]==0 ) {
					fieldPC=i+6;
				}
			}
		}
		else if ((grid[0]+grid[3]+grid[6])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[i*3]==0 ) {
					fieldPC=i*3;
				}
			}
		}
		else if ((grid[1]+grid[4]+grid[7])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[i*3+1]==0 ) {
					fieldPC=i*3+1;
				}
			}
		}
		else if ((grid[2]+grid[5]+grid[8])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[i*3+2]==0 ) {
					fieldPC=i*3+2;
				}
			}
		}
		else if ((grid[0]+grid[4]+grid[8])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[i*4]==0 ) {
					fieldPC=i*4;
				}
			}
		}
		else if ((grid[2]+grid[4]+grid[6])==fillToWin) {
			for (int i=0; i< 3; i++) {				
				if (grid[6-2*i]==0 ) {
					fieldPC=6-2*i;
				}
			}
		}
		else if(fillToWin==2) {
			fillToWin=6;
			pcchoose();
		}
		else {
			System.out.println("PC setzt!");
			do{
				fieldPC = (int) (Math.round((Math.random()*8)));
			} while(grid[fieldPC] != 0); 
		}
		grid[fieldPC]=1;
		XO[fieldPC]="X";
		pcOrPlayer = false;
	}
	
	public static void wincheck() {
		for (int i=0; i<2; i++) {//x=1 : checks if PC has won, x=3 :checks if Player has won
			int x=i*2+1; 
			if		((grid[0]==x && grid[1]==x && grid[2]==x) || 
					(grid[3]==x && grid[4]==x && grid[5]==x) || 
					(grid[6]==x && grid[7]==x && grid[8]==x) ||
					(grid[0]==x && grid[3]==x && grid[6]==x) ||
					(grid[1]==x && grid[4]==x && grid[7]==x) ||
					(grid[2]==x && grid[5]==x && grid[8]==x) ||
					(grid[0]==x && grid[4]==x && grid[8]==x) ||
					(grid[2]==x && grid[4]==x && grid[6]==x)) {
				if(x==1) {
					System.out.println("PC hat gewonnen!!!");
					win[0]=1;
				}
				else {
					System.out.println("Spieler hat gewonnen!!!");
					win[1]=1;
				}
				win[0]=1;
			}
		}
	}
	
	public static void gridcreate() { //creates the grid, blanks if unused, X for PC, O for Player/User
		System.out.println("["+XO[0]+"] ["+XO[1]+"] ["+XO[2]+"]"
				+ "\n\n["+XO[3]+"] ["+XO[4]+"] ["+XO[5]+"]"
				+ "\n\n["+XO[6]+"] ["+XO[7]+"] ["+XO[8]+"]");	
	}
	
	public static void newgame() {
		System.out.println("Willkommen zu TicTacToe! \n "
				+ "(1) Soll der PC beginnen? \n "
				+ "(2) Willst du beginnen? \n "
				+ "(3) Zufällig?");
		inputPlayer = in.nextInt();
		if(inputPlayer==1) { //player starts
			pcOrPlayer = true;
			System.out.println("PC beginnt!");
		}
		else if(inputPlayer==2) { // PC starts
			pcOrPlayer = false;
			System.out.println("Spieler beginnt!");
		}
		else {
			if( Math.round(Math.random()) == 0) { // gives the number 1 or 0, 0: PC starts, 1: Player starts
				pcOrPlayer = true;   
				System.out.println("PC beginnt!");
			}
			else {
				pcOrPlayer = false;
				System.out.println("Spieler beginnt!");
			}
		}
		gridcreate();
		for(int i=0; i <9; i++) { //repeats the game max. 9 times
			if(pcOrPlayer == true) {
				fillToWin=2; //the sum of fields has to be 2 that the PC can fill the missing one to win
				pcchoose();
			}
			else {
				System.out.println("Welches Feld möchtest du wählen?(0-8)");	
				do{
					inputPlayer= in.nextInt();
					if(grid[inputPlayer]!=0) {
						System.out.println("Feld ist bereits belegt!\nBitte wähle ein anderes!");
					}
				} while(grid[inputPlayer] != 0);
				grid[inputPlayer] = 3;
				XO[inputPlayer] ="O";
				pcOrPlayer = true;
			}
			gridcreate();
			wincheck();	
			if(win[0]==1 || win[1]==1) {
				break;
			}
			if(i==8 && win[0]==0 && win[1]==0) { //checks if all fields are used but nobody has won
				System.out.println("Unentschieden!");
				break;
			}
		}
		System.out.println("(1) Nochmal Spielen?\n(2) Aufhören?");
		if(in.nextInt() ==1 ) {
			resetgame();
			newgame();
		}
		System.out.println("Bis zum nächsten Mal!");
	}

}
