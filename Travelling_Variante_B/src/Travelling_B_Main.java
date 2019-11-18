import java.util.*;

public class Travelling_B_Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean repeatTravelling = true;
		do { // repeating the code for creating new towns
			int distances[][] = createDistances();
			int townOrder[] = new int[10];
			for (int i = 0; i < 10; i++) {
				townOrder[i] = i;
			}
			int lengthOld = routeLength(townOrder, distances);
			System.out.println("Die Strecke für die Rundreise von Stadt 1-10 wieder zu 1 beträgt " + lengthOld + ".");
			boolean optimizeAgain = true;
			do { // repeats optimization process
				System.out.println("Wie oft soll optimiert werden?");
				int optimizations = in.nextInt();
				int testTownOrder[] = new int[10];
				for (int i = 0; i < 10; i++) {
					testTownOrder[i] = townOrder[i];
				}
				for (int i = 0; i < optimizations; i++) {
					testTownOrder = changeRoute(testTownOrder);
					int lengthNew = routeLength(testTownOrder, distances);
					if (lengthOld > lengthNew) { // checks if the new route is the shorter
						lengthOld = lengthNew;
						for (int j = 0; j < 10; j++) {
							townOrder[j] = testTownOrder[j];
						}
						// System.out.println(lengthOld);
					}
				}
				System.out.println("Die kürzeste gefundene Strecke bei " + optimizations + " Optimierungen beträgt "
						+ lengthOld + ".\nSoll erneut optimiert werden?\n (1) Ja\n (2) Nein");
				if (in.nextInt() == 2) {
					optimizeAgain = false;
				}
			} while (optimizeAgain == true);
			System.out.println("Sollen neue Städte / Distanzen erstellt werden\n (1) Ja\n (2) Nein");
			if (in.nextInt() == 2) {
				repeatTravelling = false;
			}
		} while (repeatTravelling == true);
		System.out.println("Bis zum nächsten Mal!");
	}

	public static int[][] createDistances() {
		// creates the distances between the towns

		int distances[][] = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				distances[i][j] = -1;
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == j) {
					distances[i][j] = 0; // distance town n to town n = 0
				} else if (distances[j][i] != -1) {
					distances[i][j] = distances[j][i]; // mirrors: town A-->B = B-->A
				} else {
					distances[i][j] = (int) (1 + 99 * Math.random());
				}
				System.out.print(distances[i][j] + "	");
			}
			System.out.println("");
		}
		return distances;
	}

	public static int routeLength(int townOrder[], int distance[][]) {
		// adds all lengths together and returns the sum

		int length = 0;
		for (int i = 1; i < 10; i++) {
			length = length + distance[townOrder[i]][townOrder[i - 1]];
		}
		length = length + distance[townOrder[9]][townOrder[0]];
		return length;
	}

	public static int[] changeRoute(int testTownOrder[]) {
		// switches to randomly chosen towns and returns new order

		int changePositionA = (int) (Math.random() * 10);
		int changePositionB = (int) (Math.random() * 10);
		int changeHelp = testTownOrder[changePositionA];
		testTownOrder[changePositionA] = testTownOrder[changePositionB];
		testTownOrder[changePositionB] = changeHelp;
		return testTownOrder;
	}

}
