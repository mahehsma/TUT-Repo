import java.util.*;
public class tictac {
	
	private static int[] grid = new int[9]; // 0= unused, 1= used by PC, 3= used by Player
	private static String[] XO = new String[9]; // equals grid but contains blanks, X and O instead of 0,1,2
	private static int fieldPC;
	private static int inputPlayer;
	private static boolean pcOrPlayer= true; //true: PCs turn, false: Players turn
	private static Scanner in = new Scanner(System.in);
	private static int[] win = new int[2];
	
	public static void main(String[] args) {	
		resetgame();
		newgame();	
	}
	
	public static void resetgame() {
		for(int k=0; k<9; k++) {
			grid[k]=0;
			XO[k]=" ";
			win[0]=0;
			win[1]=0;
		}
	}
	
	public static void pcchoose() {
		if ((grid[0]+grid[1]+grid[2])==2) {		//tries to check if 2 fields are used by PC
			if(grid[0]==0) {
				fieldPC=0;
			}
			else if(grid[1]==0) {
				fieldPC=1;
			}
			else if(grid[2]==0) {
				fieldPC=2;
			}
		}
		else if ((grid[3]+grid[4]+grid[5])==2) {
			if(grid[3]==0) {
				fieldPC=3;
			}
			else if(grid[4]==0) {
				fieldPC=4;
			}
			else if(grid[5]==0) {
				fieldPC=5;
			}
		}
		
		else if ((grid[6]+grid[7]+grid[8])==2) {
			if(grid[6]==0) {
				fieldPC=6;
			}
			else if(grid[7]==0) {
				fieldPC=7;
			}
			else if(grid[8]==0) {
				fieldPC=8;
			}
		}
		else if ((grid[0]+grid[3]+grid[6])==2) {
			if(grid[0]==0) {
				fieldPC=0;
			}
			else if(grid[3]==0) {
				fieldPC=3;
			}
			else if(grid[6]==0) {
				fieldPC=6;
			}
		}
		else if ((grid[1]+grid[4]+grid[7])==2) {
			if(grid[1]==0) {
				fieldPC=1;
			}
			else if(grid[4]==0) {
				fieldPC=4;
			}
			else if(grid[7]==0) {
				fieldPC=7;
			}
		}
		else if ((grid[2]+grid[5]+grid[8])==2) {
			if(grid[2]==0) {
				fieldPC=2;
			}
			else if(grid[5]==0) {
				fieldPC=5;
			}
			else if(grid[8]==0) {
				fieldPC=8;
			}
		}
		else if ((grid[0]+grid[4]+grid[8])==2) {
			if(grid[0]==0) {
				fieldPC=0;
			}
			else if(grid[4]==0) {
				fieldPC=4;
			}
			else if(grid[8]==0) {
				fieldPC=8;
			}
		}
		else if ((grid[2]+grid[4]+grid[6])==2) {
			if(grid[2]==0) {
				fieldPC=2;
			}
			else if(grid[4]==0) {
				fieldPC=4;
			}
			else if(grid[6]==0) {
				fieldPC=6;
			}
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
		if		((grid[0]==1 && grid[1]==1 && grid[2]==1) || //checks if PC has won
				(grid[3]==1 && grid[4]==1 && grid[5]==1) || 
				(grid[6]==1 && grid[7]==1 && grid[8]==1) ||
				(grid[0]==1 && grid[3]==1 && grid[6]==1) ||
				(grid[1]==1 && grid[4]==1 && grid[7]==1) ||
				(grid[2]==1 && grid[5]==1 && grid[8]==1) ||
				(grid[0]==1 && grid[4]==1 && grid[8]==1) ||
				(grid[2]==1 && grid[4]==1 && grid[6]==1)) {
			System.out.println("PC hat gewonnen!!!");
			win[0]=1;
		}
		if		((grid[0]==3 && grid[1]==3 && grid[2]==3) || //checks if Player has won
				(grid[3]==3 && grid[4]==3 && grid[5]==3) || 
				(grid[6]==3 && grid[7]==3 && grid[8]==3) ||
				(grid[0]==3 && grid[3]==3 && grid[6]==3) ||
				(grid[1]==3 && grid[4]==3 && grid[7]==3) ||
				(grid[2]==3 && grid[5]==3 && grid[8]==3) ||
				(grid[0]==3 && grid[4]==3 && grid[8]==3) ||
				(grid[2]==3 && grid[4]==3 && grid[6]==3)) {
			System.out.println("Spieler hat gewonnen!!!");
			win[1]=1;
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
		if(inputPlayer==1) {
			pcOrPlayer = true;
			System.out.println("PC beginnt!");
			pcchoose();
		}
		else if(inputPlayer==2) {
			pcOrPlayer = false;
			System.out.println("Spieler beginnt!");
		}
		else {
			if( Math.round(Math.random()) == 0) {
				pcOrPlayer = true;   
				System.out.println("PC beginnt!");
			}
			else {
				pcOrPlayer = false;
				System.out.println("Spieler beginnt!");
			}
		}
		gridcreate();
		for(int i=0; i <9; i++) {
			if(pcOrPlayer == true) {
				pcchoose();
			}
			else {
				System.out.println("Welches feld möchtest du wählen?(0-8)");				
				do{
					inputPlayer= in.nextInt();
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
		}
		System.out.println("(1) Nochmal Spielen?\n(2) Aufhören?");
		if(in.nextInt() ==1 ) {
			resetgame();
			newgame();
		}
		
	}

}
