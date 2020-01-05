
public class MiniRSA {
	int eKey; // public key
	int nKey; // public key
	int dKey; // private key

	public MiniRSA(int e, int N, int d) {
		this.eKey = e;
		this.nKey = N;
		this.dKey = d;
	}

	public byte[] decrypt(byte[] input) {
		byte[] decryptedBytes = new byte[input.length / 2]; // length/2 because k1+k2 = 1 'symbol' 
		for (int i = 0; i < input.length / 2; i++) { 
			byte k1 = (byte) ((Math.pow(input[i * 2], dKey)) % nKey); 
			byte k2 = (byte) ((Math.pow(input[i * 2 + 1], dKey)) % nKey);
			decryptedBytes[i] =(byte) (k1 * 20 + k2);
		}
		return decryptedBytes;
	}

	public byte[] encrypt(String userInput) {
		byte[] encryptedBytes = new byte[userInput.length() * 2]; // length*2 because everything gets split in k1 / k2
		for (int i = 0; i < userInput.length(); i++) {
			byte k1 = (byte) (userInput.charAt(i) / 20);
			byte k2 = (byte) (userInput.charAt(i) % 20);
			encryptedBytes[i * 2] = (byte) ((Math.pow(k1, eKey)) % nKey);
			encryptedBytes[i * 2 + 1] = (byte) ((Math.pow(k2, eKey)) % nKey);
		}
		return encryptedBytes;
	}
}
