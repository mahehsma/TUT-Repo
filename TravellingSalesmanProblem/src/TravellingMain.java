
public class TravellingMain {
	public static int townOrderOld[] = new int[10];
	public static int townX[] = new int[10];
	public static int townY[] = new int[10];
	public static double distanceOld = (-1);

	public static void main(String[] args) {
		double distanceNew = 0;
		mapCreate();
		for (int i = 0; i < 1000; i++) {
			distanceNew = optimizeOrder();
		}
		System.out.println("Beste Optimierung bei 1000 durchläufen: ");
		for (int i = 0; i < 10; i++) {
			System.out.print("Stadt " + (townOrderOld[i] + 1) + " --> ");
		}
		System.out.print("Stadt " + (townOrderOld[0] + 1) + "\nErgibt eine Strecke von: " + distanceNew);
		//mapDraw();
	}

	public static void mapCreate() {
		for (int i = 0; i < 10; i++) {
			townOrderOld[i] = i;
			townX[i] = (int) (100 * Math.random());
			townY[i] = (int) (100 * Math.random());
			System.out.println("Stadt " + (i + 1) + " hat die Koordinaten: " + townX[i] + ", " + townY[i]);
		}
		mapDraw();
	}

	public static void mapDraw() {
		Integer mapDraw[][] = new Integer[50][100];
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 100; j++) {
				mapDraw[i][j] = 0;
			}
		}
		if (distanceOld !=(-1)) {
			//gerade durch die punkte
			
		}
		for (int i = 0; i < 10; i++) {
			int shift=0;
			while (mapDraw[Math.round(townX[i] / 2)][Math.round(townY[i])] != 0) {
				shift++;
			}
			mapDraw[Math.round(townX[i] / 2)+shift][Math.round(townY[i])] = (i + 1);
		}
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 100; j++) {
				if (mapDraw[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(mapDraw[i][j] + " ");
				}
			}
			System.out.println("");
		}

	}

	public static double optimizeOrder() {
		double distanceNew = 0;
		int townOrderNew[] = new int[10];
		int switchTownA = (int) (Math.random() * 10);
		int switchTownB = (int) (Math.random() * 10);
		for (int i = 0; i < 10; i++) {
			townOrderNew[i] = townOrderOld[i];
		}
		int switchTownHelp = townOrderOld[switchTownA];
		townOrderOld[switchTownA] = townOrderOld[switchTownB];
		townOrderOld[switchTownB] = switchTownHelp;
		for (int i = 0; i < 9; i++) {
			distanceNew = distanceNew + Math.sqrt((townX[townOrderOld[i + 1]] - townX[townOrderOld[i]])
					* (townX[townOrderOld[i + 1]] - townX[townOrderOld[i]])
					+ (townY[townOrderOld[i + 1]] - townY[townOrderOld[i]])
							* (townY[townOrderOld[i + 1]] - townY[townOrderOld[i]]));

		}
		distanceNew = distanceNew + Math.sqrt(
				(townX[townOrderOld[0]] - townX[townOrderOld[9]]) * (townX[townOrderOld[0]] - townX[townOrderOld[9]])
						+ (townY[townOrderOld[0]] - townY[townOrderOld[9]])
								* (townY[townOrderOld[0]] - townY[townOrderOld[9]]));
		if (distanceOld == (-1)) {
			distanceOld = distanceNew;
		}
		if (distanceNew <= distanceOld) {
			distanceOld = distanceNew;
			for (int i = 0; i < 10; i++) {
				townOrderNew[i] = townOrderOld[i];
			}
		} else {
			for (int i = 0; i < 10; i++) {
				townOrderOld[i] = townOrderNew[i];
			}
		}
		return distanceOld;

	}
}
