import java.util.*;

public class TravellingMain {
	public static int townOrderOld[] = new int[11];
	public static int townX[] = new int[11]; //x coordinates for start and towns
	public static int townY[] = new int[11]; //y coordinates for start and towns
	public static double distanceOld = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Willkommen zu TravellingSalesmanProblem!\n");
		boolean townAgain = true;	//for rerunning the program
		do {
			boolean optimizeAgain = true;// for rerunning the optimizing process
			mapCreate();
			do {
				double distanceNew = 0;
				System.out.println("\nWie oft soll optimiert werden?");
				while (!in.hasNextInt()) {
					in.next();
					System.out.println("Eingabe nicht erkannt!");
				}
				int intInputUser = in.nextInt();
				for (int i = 0; i < intInputUser; i++) {
					distanceNew = optimizeOrder();
				}
				System.out.println("Beste Optimierung bei " + intInputUser + " durchläufen: ");
				System.out.print("Start --> ");
				for (int i = 1; i < 11; i++) { //output town order
					System.out.print("Stadt " + (townOrderOld[i]) + " --> ");
				}
				System.out.print("Start\nErgibt eine Strecke von: " + distanceNew);
				System.out.println("\nSoll die Strecke erneut optimiert werden\n(1) Ja\n(2) Nein");
				while (!in.hasNextInt()) {
					in.next();
					System.out.println("Eingabe nicht erkannt!");
				}
				if (in.nextInt() == 2) {
					optimizeAgain = false;
				}
			} while (optimizeAgain == true);
			System.out.println("\nSollen neue Städte erstellt werden?\n(1) Ja\n(2) Nein");
			while (!in.hasNextInt()) {
				in.next();
				System.out.println("Eingabe nicht erkannt!");
			}
			if (in.nextInt() == 1) {
				distanceOld = (-1); // for resetting the process
			} else {
				townAgain = false;
			}
		} while (townAgain == true);
		System.out.println("Bis zum nächsten Mal!");
	}

	public static void mapCreate() {
		for (int i = 0; i < 11; i++) { //random coordinates for start and towns
			townOrderOld[i] = i;
			townX[i] = (int) (100 * Math.random());
			townY[i] = (int) (100 * Math.random());
			if (i == 0) {
				System.out.println("Start hat die Koordinaten: " + townX[i] + ", " + townY[i]);
			} else {
				System.out.println("Stadt " + (i) + " hat die Koordinaten: " + townX[i] + ", " + townY[i]);
			}
		}
		for (int i = 0; i < 10; i++) {
			// distance between start and between the towns except last to start
			distanceOld = distanceOld + Math.sqrt(Math.pow((townX[townOrderOld[i + 1]] - townX[townOrderOld[i]]), 2)
					+ Math.pow((townY[townOrderOld[i + 1]] - townY[townOrderOld[i]]), 2));

		}
		// distance between all towns, including distance between last and start
		distanceOld = distanceOld + Math.sqrt(Math.pow((townX[townOrderOld[0]] - townX[townOrderOld[9]]), 2)
				+ Math.pow((townY[townOrderOld[0]] - townY[townOrderOld[10]]), 2));
		System.out.println(
				"\nDie Distanz vom Start --> Stadt 1 --> Stadt 2... --> Stadt 10 zum Start beträgt: " + distanceOld);
		// mapDraw();
	}

//	public static void mapDraw() {
//		Integer mapDraw[][] = new Integer[50][100];
//		for (int i = 0; i < 50; i++) {
//			for (int j = 0; j < 100; j++) {
//				mapDraw[i][j] = 0;
//			}
//		}
//		if (distanceOld != (-1)) {
//			// gerade durch die punkte
//
//		}
//		for (int i = 0; i < 10; i++) {
//			int shift = 0;
//			while (mapDraw[Math.round(townX[i] / 2)][Math.round(townY[i])] != 0) {
//				shift++;
//			}
//			mapDraw[Math.round(townX[i] / 2) + shift][Math.round(townY[i])] = (i + 1);
//		}
//		for (int i = 0; i < 50; i++) {
//			for (int j = 0; j < 100; j++) {
//				if (mapDraw[i][j] == 0) {
//					System.out.print(" ");
//				} else {
//					System.out.print(mapDraw[i][j] + " ");
//				}
//			}
//			System.out.println("");
//		}
//
//	}

	public static double optimizeOrder() {
		double distanceNew = 0;
		int townOrderNew[] = new int[11];
		int switchTownA = (int) (Math.random() * 11); 	//random position A gets switched with
		int switchTownB = (int) (Math.random() * 11);	//random position B
		for (int i = 0; i < 11; i++) {
			townOrderNew[i] = townOrderOld[i]; //
		}
		int switchTownHelp = townOrderOld[switchTownA];	//switching the order with 3 variables 
		townOrderOld[switchTownA] = townOrderOld[switchTownB];
		townOrderOld[switchTownB] = switchTownHelp;
		for (int i = 0; i < 10; i++) {
			// distance between the towns except last to first
			distanceNew = distanceNew + Math.sqrt(Math.pow((townX[townOrderOld[i + 1]] - townX[townOrderOld[i]]), 2)
					+ Math.pow((townY[townOrderOld[i + 1]] - townY[townOrderOld[i]]), 2));

		}
		// distance between all towns, including distance between last and first
		distanceNew = distanceNew + Math.sqrt(Math.pow((townX[townOrderOld[0]] - townX[townOrderOld[9]]), 2)
				+ Math.pow((townY[townOrderOld[0]] - townY[townOrderOld[10]]), 2));
		if (distanceNew <= distanceOld) {
			distanceOld = distanceNew;
		} else {
			for (int i = 0; i < 11; i++) {
				townOrderOld[i] = townOrderNew[i];
			}
		}

		int helpStart;
		while (townOrderOld[0] != 0) {		//puts "start" in the first place, start equals 0
			helpStart = townOrderOld[0];
			for (int j = 0; j < 10; j++) {
				townOrderOld[j] = townOrderOld[j + 1];
			}
			townOrderOld[10] = helpStart;
		}
		return distanceOld;					// returns the shorter distance

	}
}
