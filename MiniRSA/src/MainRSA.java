import java.io.IOException;
import java.util.Scanner;

public class MainRSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to miniRSA!");
		do {
			System.out.println("---Press '1' for encryption, '2' for decryption or '3' for exit!---");
			Scanner in = new Scanner(System.in);
			int enOrDecryption;
			do {
				enOrDecryption = in.nextInt();
			} while (enOrDecryption != 1 && enOrDecryption != 2 && enOrDecryption != 3);
			MiniRSA mini = new MiniRSA(5, 21, 5); //keys
			FileIO fileIO = new FileIO();
			if (enOrDecryption == 1) {
				System.out.println("What do you want to be encrypted?");
				String userInput;
				userInput = in.next();   //input that should be encrypted
				encryption(userInput, mini, fileIO);
				System.out.println("Successfully encrypted and saved as 'testfile' !");
			} else if (enOrDecryption == 2) {
				byte[] decryptedString = decryption(mini, fileIO);
				System.out.println("Decrypting 'testfile'...");
				for (int i = 0; i < (decryptedString.length); i++) {
					System.out.print((char) decryptedString[i]);
				}
				System.out.println("\n'testfile' successfully decrypted");
			} else {
				break;
			}
		} while (1 == 1); //infinity loop until user types 3 --> break
		System.out.println("Bye!");
	}

	public static void encryption(String input, MiniRSA mini, FileIO io) {
		byte[] encryptedString = mini.encrypt(input);
		encryptedString = mini.encrypt(input);
		io.writeFile("testFile", encryptedString);

	}

	public static byte[] decryption(MiniRSA mini, FileIO io) {
		byte[] bytesToDecrypt = new byte[100];
		try {
			bytesToDecrypt = io.readFile("testFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mini.decrypt(bytesToDecrypt);
	}

}
